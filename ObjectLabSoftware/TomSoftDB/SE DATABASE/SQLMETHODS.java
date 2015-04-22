package ObjectLabEnterpriseSoftware;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
/**
 * FYI I used select * so far in most cases since I don't know what you want it limited to. Some refinement will be needed. 
 * @author Database
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!
public class SQLMethods 
{
    /* Same url and connection to the DB until it is closed */
    private final String url;
    private Connection conn;
    private ResultSet res;
    private PreparedStatement stmt;

    public SQLMethods() 
    {
        /* To resolve hostname to an IP adr */
        File f = new File("C:\\Sync\\computername.txt");
        String line, ip = "";
        
        try 
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(f.getAbsolutePath());
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) 
                ip = line;

            // Always close files.
            bufferedReader.close();
        }
        catch (IOException ex) 
        {
            System.out.println("Couldn't read file! IOException!");
			ex.printStackTrace();
        }
        url = "jdbc:mysql://" + ip + ":3306/";
        connectToDatabase("com.mysql.jdbc.Driver", url + "jobsdb", "admin", "password");
    }
    
    private void connectToDatabase(String driver, String urlDatabaseName, String userName, String pw)
    {
        try 
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(urlDatabaseName, userName, pw);
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("Driver class not found / created. Exception!\n" + e);
        } 
        catch (InstantiationException | IllegalAccessException | SQLException e) 
        {
            System.out.println(e);
        }
    }
    
    public void closeDBConnection()
    {
        try 
        {
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	// Begining of Select Methods
	// _______________________________________________________________________________________________________________________
	public ResultSet selectAllFromTable(String table)
	{// select entire table
		// (probably not useful)
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM " + table +";");
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}

	public ResultSet selectAllPrintStatus(String status)
	{// select all info from job based onstatus ((probably that not useful)
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM job WHERE status= ?;");
			stmt.setString(1, status);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}

	public ResultSet searchPrinterFilesTypes(String printer)
	{// selects the filetypes for the printer
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT file_extension FROM printer WHERE printer_name = ?;");
			stmt.setString(1, printer);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}

	public ResultSet searchJobsStatusPrinter(String status, String printer) 																
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT Job.file_name, Users.first_name, Users.last_name, Job.submission_date ,Job.printer_name  " + "FROM Job, Users  " + "WHERE status = ? AND printer_name = ? AND Users.towson_id = Job.student_id;");
			stmt.setString(1, status);
			stmt.setString(2, printer);
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return res;
	}

	public ResultSet searchPrintersByBuildName(int buildId)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM job WHERE build_id = ?;");
			stmt.setInt(1, buildId);
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet selectIDFromJob(int id)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM Job Where student_id = ?;");
			stmt.setInt(1, id);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}

	public ResultSet searchJobsByBuildName(String buildName)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM job, printer_build " + "WHERE buildName = ?  AND printer_build.build_id= Job.build_id;");
			stmt.setString(1, buildName);
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet searchID(String fileName)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT file_path FROM job WHERE file_name = ? ;");
			stmt.setString(1, fileName);
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet searchTwo(String table, String column1, String column2, String key1)
	{
		res = null;
		String query = "SELECT * FROM " + table + " WHERE concat(" + column1 + ", ' ', " + column2 + ")" + "LIKE ?;";
		try
		{
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, key1);
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet searchOne(String table, String column1, String key)
	{
		res = null;
		String query = "SELECT * FROM " + table + " WHERE " + column1 + " = ?;";
		try
		{
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, key);
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet selectClasses()
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM class ;");
			res = stmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet selectPassFromadmin(String admin)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT pass FROM admin Where username = ?; ");
			stmt.setString(1, admin);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}

	public ResultSet selectJobForClass(int classes, String status)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT * FROM  job Where class_id = ? AND status = ? ;");
			stmt.setInt(1, classes);
			stmt.setString(2, status);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}

	public ResultSet selectAcceptedFiles(String printer)
	{

		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT file_extension FROM accepted_files Where printer_name = ?;");
			stmt.setString(1, printer);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}
	public ResultSet selectTableHeader(String printer)
	{

		res = null;
		try
		{
			stmt = this.conn.prepareStatement("SELECT custom_field_name  FROM custom_printer_column_name Where printer_name = ?;");
			stmt.setString(1, printer);
			res = stmt.executeQuery();
		} catch (SQLException e)
		{
			System.err.println("SQL Execution Error.");
		}
		return res;
	}
	public String createDynamicQuery(String printer)
	{
		ResultSet temp = selectTableHeader(printer);
		temp.beforeFirst();
		temp.next();
		temp.next();
		String statement1 = "", statement2 ="";
		while(temp.isAfterLast()   ==false)
		{   temp.previous();
			String attr = temp.getString(1);
			statement1= statement1+ " sum( "+ attr+") as "+attr +", ";
			statement2= statement2 + " case when custom_field_name  = \'" +attr+"\' then column_field_data end as "+ attr +",";
			temp.next();
			temp.next();
		}
		temp.previous();
		String attr = temp.getString(1);
		statement1= statement1+ " sum( "+ attr+") as "+attr;
		statement2= statement2 + " case when custom_field_name  = \'" +attr+"\' then column_field_data end as "+ attr;
	return "select report.build_name," + statement1 +" from (Select printer_build.build_name, " +statement2 + " From printer_build, column_build_data, custom_printer_column_names "
			+" where printer_build.printer_name = custom_printer_column_names.printer_name" 
			+" AND column_build_data.build_name= printer_build.build_name" 
			+" AND custom_printer_column_names.column_names_id=column_build_data.column_name_id "
			+" AND printer_build.printer_name=" + printer +"\'"
			+" ) report group by report.build_name;";
	}

	// END OF SELECT METHODS
	// _____________________________________________________________________________________________________________________

	// BEGGINING OF INSERT METHODS
	// _____________________________________________________________________________________________________________________

	public void insertIntoClasses(String className, String classSection, String professor)
	{
		try
		{
			stmt = conn.prepareStatement("INSERT INTO class (class_name, class_section, professor) values (?,?,?);");
			stmt.setString(1, className);
			stmt.setString(2, classSection);
			stmt.setString(3, professor);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoJob(String filename, String filePath, int class_id, int user_id, String printer, String buildName, String comment)
	{
		try
		{
			stmt = conn.prepareStatement("INSERT INTO job (file_name, file_path, class_id, student_id, printer_name, submission_date," + " build_Name, status, comment) values (?,?,?,?,?,NOW(),?,'pending',?);");
			stmt.setString(1, filename);
			stmt.setString(2, filePath);
			stmt.setInt(3, class_id);
			stmt.setInt(4, user_id);
			stmt.setString(5, printer);
			stmt.setString(6, buildName);
			stmt.setString(7, comment);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoPrinter(String printer, String fileExtention)
	{
		try
		{
			stmt = conn.prepareStatement("INSERT INTO printer (printer_name,current, total_run_time) values (?, 'current', 0);");
			stmt.setString(1, printer);
			stmt.setString(2, fileExtention);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoUsers(int idusers, String firstName, String lastName, String email)
	{
		try
		{
			stmt = conn.prepareStatement("INSERT INTO users(towson_id, first_name, last_name, email) values (?,?,?,?);");
			stmt.setInt(1, idusers);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, email);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoAdmin(int user_id, String userName, String pass)
	{
		try
		{
			stmt = conn.prepareStatement("insert into admin (user_id, username, date_created, pass) values (?,?,NOW(),?);");
			stmt.setInt(1, user_id);
			stmt.setString(2, userName);
			stmt.setString(3, pass);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoBuild(String buildname, int models, String printer)
	{
		try
		{
			stmt = conn.prepareStatement("insert into printer_build ( build_name, date_created, total_runtime_seconds, number_of_models, printer_name) values (?,NOW(),0, ? , ?);");
			stmt.setString(1, buildname);
			stmt.setInt(2, models);
			stmt.setString(3, printer);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoColumn(String buildName, int columnid, String data)
	{
		try
		{
			stmt = conn.prepareStatement("insert into column_build_data ( build_name, column_name_id, column_field_data) values (?,?, ?);");
			stmt.setString(1, buildName);
			stmt.setInt(2, columnid);
			stmt.setString(3, data);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoCustom(String printer, String name, boolean num)
	{
		try
		{
			stmt = conn.prepareStatement("insert into custom_printer_column_names ( printer_name, custom_field_name ,numerical) values (?,? ,?);");
			stmt.setString(1, printer);
			stmt.setString(2, name);
			stmt.setBoolean(3, num);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertIntoAcceptedFiles(String printer, String file)
	{
		try
		{
			stmt = conn.prepareStatement("insert into accepted_files ( printer_name, file_extension) values (?,?);");
			stmt.setString(1, printer);
			stmt.setString(2, file);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// END OF INSERT METHODS
	// _____________________________________________________________________________________________________________________

	// BEGGINIGNG OF UPDATE METHODS
	// _____________________________________________________________________________________________________________________
	public void updateJobStatus(String file_name, String status) throws SQLException
	{
		stmt = this.conn.prepareStatement("UPDATE job SET status = ? WHERE file_name = ?;");
		stmt.setString(1, status);
		stmt.setString(2, file_name);
		stmt.executeUpdate();
	}

	public void updateJobFLocation(String filename, String fLocation)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE job SET file_path = ?" + " WHERE file_name = ?;");
			stmt.setString(1, fLocation);
			stmt.setString(2, filename);
			stmt.executeUpdate();
		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updateJobVolume(String file_name, double volume)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE job SET volume = " + volume + " WHERE file_name = ?;");
			stmt.setString(1, file_name);
			stmt.executeUpdate();
		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updatePendingJobsBuildName(int build, String fileName)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE job SET build_id = ? WHERE file_name = ?;");
			stmt.setInt(1, build);
			stmt.setString(2, fileName);
			stmt.executeUpdate();
		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updateFirstName(String updatedFirstName, int id)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("UPDATE users SET first_name = ? WHERE towson_id = ?;");
			stmt.setString(1, updatedFirstName);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateLastName(String updatedLastName, int id)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("UPDATE users SET last_name = ? WHERE towson_id = ?;");
			stmt.setString(1, updatedLastName);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updatePassword(String password, String username)
	{
		res = null;
		try
		{
			stmt = conn.prepareStatement("UPDATE admin SET pass= ? WHERE username= ? ; ");
			stmt.setString(1, password);
			stmt.setString(2, username);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateEmail(String newEmail, int id)
	{
		res = null;
		try
		{
			stmt = conn.prepareStatement("UPDATE users SET email= ? WHERE towson_id= ?;  ");
			stmt.setString(1, newEmail);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateColumnFieldName(String updatedName, int id)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("UPDATE Custom_printer_column_names SET column_field_name = ? WHERE column_names_id = ? ;");
			stmt.setString(1, updatedName);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateColumnFieldData(String data, int columnId, String buildName)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement("UPDATE column_build_data SET column_field_data =? Where column_name_id = ? AND build_name = ? ;");
			stmt.setString(1, data);
			stmt.setInt(2, columnId);
			stmt.setString(3, buildName);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updatePrinterFileExtension(String printer_name, String file_extension)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE printer SET file_extension = ? WHERE printer_name = ?;");
			stmt.setString(1, file_extension);
			stmt.setString(2, printer_name);
			stmt.executeUpdate();

		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updatePrinterCurrent(String printer_name, String current)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE printer SET current  = ? WHERE printer_name = ?;");
			stmt.setString(1, current);
			stmt.setString(2, printer_name);
			System.out.println(stmt);
			stmt.executeUpdate();

		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updatePrinterBuildDateCreated(String buildName, String date_created)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE printer_build SET date_created = NOW() WHERE build_name = ?;");
			stmt.setString(1, buildName);
			System.out.println(stmt);
			stmt.executeUpdate();

		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updatePrinterBuildTotalRuntimeSeconds(String buildName, int total_runtime_seconds)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE printer_build SET total_runtime_seconds = ? WHERE build_name = ?;");
			System.out.println(stmt);
			stmt.setInt(1, total_runtime_seconds);
			stmt.setString(2, buildName);
			stmt.executeUpdate();

		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updatePrinterBuildNumberOfModels(String buildName, int number_of_models)
	{
		try
		{
			stmt = this.conn.prepareStatement("UPDATE printer_build SET number_of_models =? WHERE build_name = ?;");
			System.out.println(stmt);
			stmt.setInt(1, number_of_models);
			stmt.setString(2, buildName);
			stmt.executeUpdate();

		} catch (SQLException ex)
		{
			Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// END OF UPDATE METHODS
	// _____________________________________________________________________________________________________________________

	// BEGINGING OF DELETE METHODS
	// _____________________________________________________________________________________________________________________

	public void deleteByBuildId(int buildid)
	{
		try
		{
			stmt = this.conn.prepareStatement("DELETE FROM Job WHERE build_id = ?;");
			stmt.setInt(1, buildid);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteFromJob(String filename)
	{
		try
		{
			stmt = conn.prepareStatement("Delete From job WHERE file_name = ?; ");
			stmt.setString(1, filename);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deletePrinter(String printerName)
	{
		try
		{
			stmt = conn.prepareStatement("DELETE FROM printer WHERE printer_name = ?; ");
			stmt.setString(1, printerName);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteFromUser(int id)
	{
		try
		{
			stmt = conn.prepareStatement("DELETE FROM users WHERE towson_id = ?; ");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteFromClass(int class_id)
	{
		try
		{
			stmt = conn.prepareStatement("DELETE FROM class WHERE class_id = ?; ");
			stmt.setInt(1, class_id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteFromAdmin(int id)
	{
		try
		{
			stmt = conn.prepareStatement("delete from admin where user_id= ?;");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteColumnName(int primaryKey)
	{
		try
		{
			stmt = conn.prepareStatement("delete from Custom_printer_column_names where column_names_id= ?; ");
			stmt.setInt(1, primaryKey);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteColumnData(String buildName, int columnId)
	{
		try
		{
			stmt = conn.prepareStatement("delete from column_build_data where build_name= ? AND column_name_id = ?;");
			stmt.setString(1, buildName);
			stmt.setInt(2, columnId);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// END OF DELETE METHODS
	// _____________________________________________________________________________________________________________________

	public void runQuery(String query)
	{
		res = null;
		try
		{
			stmt = this.conn.prepareStatement(query);
			stmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}