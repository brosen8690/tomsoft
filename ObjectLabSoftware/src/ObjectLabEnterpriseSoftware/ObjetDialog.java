/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectLabEnterpriseSoftware;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Saurabh
 */
public class ObjetDialog extends javax.swing.JFrame {

    InstanceCall instance;
    static String materialType = "";
    static String fileName = "";
    static String buildName = "";
    static String dateRun = "";
    static Double cubicInches = 0.0;
    static Integer modelAmount = 0;
    static String buildTime = "";
    static String comments = "";
    static Double BuildConsumed = 0.0;
    static Double SupportConsumed = 0.0;
    static Double Volume = 0.0;
    static double buildCost = 0;
    static boolean errFree = true;
    static boolean closing;
    static double Resolution;

    /**
     * Creates new form ObjetDialog
     */
    public ObjetDialog(java.awt.Frame parent, boolean modal, String build, int count) 
    {
        initComponents();
        BuildConError.setVisible(false);
        SupportConError.setVisible(false);
        volumeError.setVisible(false);
        ResolutionError.setVisible(false);
        materialError.setVisible(false);
        
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Windows".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(ObjetDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        setUp(build, count);
    }

    public void ObjetDialogStart() 
    {
        instance = new InstanceCall();
        setTitle("Add Information about" + new File(BPath.getText()).getName());
        hideErrorFields();
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        this.dateRunTxt.setText(sdf.format(date));
        this.setLocationRelativeTo(null);
        //search database for buildName
        //File BPathfile = new File(BPath.getText().replace("\\", "\\\\"));
        setVisible(true);

        addWindowListener
        (
            new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent we) 
                {
                    UtilController.revertBuild(new File(BPath.getText()).getName(), "objet");
                    returnHome();
                    dispose();
                }
            }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BPath = new javax.swing.JTextField();
        dateRunTxt = new javax.swing.JTextField();
        numOfModels = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        minStar = new javax.swing.JLabel();
        hourStar = new javax.swing.JLabel();
        dayStar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        minutes = new javax.swing.JComboBox();
        days = new javax.swing.JComboBox();
        hours = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        runTimeError = new javax.swing.JLabel();
        VolumeText = new javax.swing.JTextField();
        VolumeLbl = new javax.swing.JLabel();
        volumeError = new javax.swing.JLabel();
        SuppConsumedText = new javax.swing.JTextField();
        BuildConsomedLbl = new javax.swing.JLabel();
        SuppConsumedLbl = new javax.swing.JLabel();
        BuildConError = new javax.swing.JLabel();
        SupportConError = new javax.swing.JLabel();
        BuildConsumedText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        materialError = new javax.swing.JLabel();
        material = new javax.swing.JComboBox();
        ResolutionText = new javax.swing.JTextField();
        ResolutionError = new javax.swing.JLabel();
        ResolutionLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Objet Data Entry");
        setMinimumSize(new java.awt.Dimension(370, 363));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BPath.setEditable(false);
        getContentPane().add(BPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 61, 220, -1));

        dateRunTxt.setEditable(false);
        getContentPane().add(dateRunTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 72, -1));

        numOfModels.setEditable(false);
        getContentPane().add(numOfModels, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 117, 72, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Build Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 61, 95, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date Run:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 91, 95, 20));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("No. of Models:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 117, 95, 20));

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, -1, -1));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Comment (Optional):");
        jLabel26.setToolTipText("");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 20));

        comment.setColumns(20);
        comment.setRows(5);
        comment.setMinimumSize(new java.awt.Dimension(169, 94));
        jScrollPane1.setViewportView(comment);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 220, -1));

        minStar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        minStar.setForeground(new java.awt.Color(255, 0, 0));
        minStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minStar.setText("*");
        getContentPane().add(minStar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 40, -1));

        hourStar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        hourStar.setForeground(new java.awt.Color(255, 0, 0));
        hourStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourStar.setText("*");
        getContentPane().add(hourStar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 40, -1));

        dayStar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        dayStar.setForeground(new java.awt.Color(255, 0, 0));
        dayStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayStar.setText("*");
        getContentPane().add(dayStar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 40, -1));

        jLabel11.setText("Days:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, 20));

        jLabel12.setText("Hrs:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 30, 20));

        jLabel10.setText("Min:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, 20));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Run Time:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 95, 20));

        minutes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        getContentPane().add(minutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 40, -1));

        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" }));
        getContentPane().add(days, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 40, -1));

        hours.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        getContentPane().add(hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 40, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Objet Data Entry");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 360, 10));

        runTimeError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        runTimeError.setForeground(new java.awt.Color(255, 0, 0));
        runTimeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        runTimeError.setText("Error Text");
        getContentPane().add(runTimeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 220, 20));
        getContentPane().add(VolumeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 70, -1));

        VolumeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        VolumeLbl.setText("Volume (Cubic Inches):");
        getContentPane().add(VolumeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        volumeError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        volumeError.setForeground(new java.awt.Color(255, 0, 0));
        volumeError.setText("Error Text");
        getContentPane().add(volumeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 140, -1));
        getContentPane().add(SuppConsumedText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 72, -1));

        BuildConsomedLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        BuildConsomedLbl.setText("Build Consumed (g):");
        getContentPane().add(BuildConsomedLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 115, 20));

        SuppConsumedLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SuppConsumedLbl.setText("Support Consumed (g):");
        getContentPane().add(SuppConsumedLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 115, 20));

        BuildConError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BuildConError.setForeground(new java.awt.Color(255, 0, 0));
        BuildConError.setText("Error Text");
        getContentPane().add(BuildConError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, 20));

        SupportConError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        SupportConError.setForeground(new java.awt.Color(255, 0, 0));
        SupportConError.setText("Error Text");
        getContentPane().add(SupportConError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, 20));

        BuildConsumedText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuildConsumedTextActionPerformed(evt);
            }
        });
        getContentPane().add(BuildConsumedText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 72, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Build Material:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 115, 20));

        materialError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        materialError.setForeground(new java.awt.Color(255, 0, 0));
        materialError.setText("Error Text");
        getContentPane().add(materialError, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, 20));

        material.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VeroWhitePlus", "VeroBlackPlus", "VeroBlue", "VeroGrey", "DurusWhite" }));
        material.setSelectedItem(null);
        getContentPane().add(material, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 110, -1));

        ResolutionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolutionTextActionPerformed(evt);
            }
        });
        getContentPane().add(ResolutionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 70, -1));

        ResolutionError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ResolutionError.setForeground(new java.awt.Color(255, 0, 0));
        ResolutionError.setText("Error Text");
        getContentPane().add(ResolutionError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 140, 20));

        ResolutionLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ResolutionLbl.setText("Resolution:");
        getContentPane().add(ResolutionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/black and white bg.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -26, 480, 530));

        jMenu1.setText("File");

        jMenuItem2.setText("Reports");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private boolean validateForm() 
    {
        try 
        {
            BuildConsumed = Double.parseDouble(BuildConsumedText.getText());
        } 
        catch (NumberFormatException e) 
        {
            errFree = false;
            if (BuildConsumedText.getText().equals("")) 
            {
                BuildConError.setText("*Empty Field");
                BuildConError.setVisible(true);
            } 
            else 
            {
                BuildConError.setText("*Numbers only please");
                BuildConError.setVisible(true);
            }
        }
        
        try 
        {
            materialType = material.getSelectedItem().toString();
        } 
        catch (NumberFormatException e) 
        {
            errFree = false;
            materialError.setText("Select a material");
        }

        try 
        {
            Resolution = Double.parseDouble(ResolutionText.getText());
        } 
        catch (NumberFormatException e) 
        {
            errFree = false;
            if (ResolutionText.getText().equals("")) 
            {
                ResolutionError.setText("*Empty Field");
                ResolutionError.setVisible(true);
            } else 
            {
                ResolutionError.setText("*Numbers only please");
                ResolutionError.setVisible(true);
            }
        }

        try 
        {
            SupportConsumed = Double.parseDouble(SuppConsumedText.getText());
        } 
        catch (NumberFormatException e) 
        {
            errFree = false;
            if (SuppConsumedText.getText().equals("")) 
            {
                SupportConError.setText("*Empty Field");
                SupportConError.setVisible(true);
            } 
            else 
            {
                SupportConError.setText("*Numbers only please");
                SupportConError.setVisible(true);
            }
        }

        try 
        {
            Volume = Double.parseDouble(VolumeText.getText());
        } 
        catch (NumberFormatException e) 
        {
            errFree = false;
            if (VolumeText.getText().equals("")) 
            {
                volumeError.setText("*Empty Field");
                volumeError.setVisible(true);
            } 
            else 
            {
                volumeError.setText("*Numbers only please");
                volumeError.setVisible(true);
            }
        }

        try 
        {
            modelAmount = Integer.parseInt(numOfModels.getText());
        } 
        catch (NumberFormatException e) 
        {
            errFree = false;
            
            if (numOfModels.getText().equals("")) 
            {
                jLabel19.setText("*Empty Field");
                jLabel19.setVisible(true);
            } 
            else 
            {
                jLabel19.setText("*Numbers only please");
                jLabel19.setVisible(true);
            }
        }
        return true;
    }
   
   public static void returnHome() 
   {
        
        PrinterBuild.home.studentSubmissionButton.setVisible(false);
        PrinterBuild.home.setPrintersVisible(false);
        PrinterBuild.home.setVisible(true);
    }
   
    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        if (validateForm()) 
        {
            Integer day = Integer.parseInt(days.getSelectedItem().toString());
            Integer hr = Integer.parseInt(hours.getSelectedItem().toString());
            Integer min = Integer.parseInt(minutes.getSelectedItem().toString());
            buildTime = day + ":" + hr + ":" + min;

            String buildPath = BPath.getText();
            buildName = new File(buildPath).getName();
            buildPath = buildPath.replace("\\", "\\\\");
            //File file = new File(buildPath);
            //buildName = file.getName();
            modelAmount = Integer.parseInt(numOfModels.getText());
            String comments = comment.getText();
            
            if(!UtilController.submitBuildInfoToDB(buildName,"objet"))
              JOptionPane.showMessageDialog(new JPanel(), "Build was not created.", "Warning", JOptionPane.WARNING_MESSAGE);  
            
            returnHome();
            dispose();
        } 
        else 
        {
            System.out.println("ERRORS");
            JOptionPane.showMessageDialog(null, "There were errors that prevented your build information from being submitted to the database. \nPlease consult the red error text on screen.");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void hideErrorFields() 
    {
        ResolutionError.setVisible(false);
        runTimeError.setVisible(false);
        dayStar.setVisible(false);
        hourStar.setVisible(false);
        minStar.setVisible(false);
    }
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Reports rpr = new Reports();
        rpr.ReportsPage();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ResolutionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolutionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResolutionTextActionPerformed

    private void BuildConsumedTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildConsumedTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuildConsumedTextActionPerformed
    public static void setUp(String buildName, int countNumOfModels) {
        BPath.setText(buildName);
        numOfModels.setText("" + countNumOfModels);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField BPath;
    private javax.swing.JLabel BuildConError;
    private javax.swing.JLabel BuildConsomedLbl;
    private javax.swing.JTextField BuildConsumedText;
    private javax.swing.JLabel ResolutionError;
    private javax.swing.JLabel ResolutionLbl;
    private javax.swing.JTextField ResolutionText;
    private javax.swing.JLabel SuppConsumedLbl;
    private javax.swing.JTextField SuppConsumedText;
    private javax.swing.JLabel SupportConError;
    private javax.swing.JLabel VolumeLbl;
    private javax.swing.JTextField VolumeText;
    private javax.swing.JTextArea comment;
    private javax.swing.JTextField dateRunTxt;
    private javax.swing.JLabel dayStar;
    private javax.swing.JComboBox days;
    private javax.swing.JLabel hourStar;
    private javax.swing.JComboBox hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox material;
    private javax.swing.JLabel materialError;
    private javax.swing.JLabel minStar;
    private javax.swing.JComboBox minutes;
    public static javax.swing.JTextField numOfModels;
    private javax.swing.JLabel runTimeError;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel volumeError;
    // End of variables declaration//GEN-END:variables
}
