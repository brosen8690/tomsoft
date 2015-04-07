package ObjectLabEnterpriseSoftware;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matt
 */
public class SolidscapeMain extends javax.swing.JFrame {

    /**
     * Creates new form Options
     */
    static DefaultListModel allFileListModel = new DefaultListModel();
    static Calculations calc;
    DefaultListModel currentFileListModel = new DefaultListModel();
    private PrinterOpenBuilds SBuild;
    private static FileManager instance;
    public static Reports reports;
    public static SQLMethods dba;
    public static SolidscapePref Settings;
    TomSoftMain home;
    public void SolidscapeMainStart() {
        SBuild = new PrinterOpenBuilds();
        calc = new Calculations();
        home = new TomSoftMain();
        dba = new SQLMethods();
        reports = new Reports();
        instance = new FileManager();
        initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolidscapeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
         addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // close sockets, etc
               home.studentSubmissionButton.setVisible(false);
                home.setPrintersVisible(false);
                home.setVisible(true);
            }
        });
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        CloseButton = new javax.swing.JButton();
        NewBuildButton = new javax.swing.JButton();
        OpenBuildsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Art 101-001\nArt 201-002\nArt 401-004\nArt 501-005\nArt 601-006\nArt 701-007\nArt 801-009");
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solidscape Home");
        setMinimumSize(new java.awt.Dimension(390, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Solidscape Printer");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 10));

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 150, -1));

        NewBuildButton.setText("Enter a Build");
        NewBuildButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBuildButtonActionPerformed(evt);
            }
        });
        getContentPane().add(NewBuildButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, -1));

        OpenBuildsButton.setText("Outstanding Builds");
        OpenBuildsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenBuildsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(OpenBuildsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));

        jLabel2.setBackground(new java.awt.Color(41, 40, 41));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/backgroundrender.png"))); // NOI18N
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 400, 230));

        jMenu1.setText("File");

        jMenuItem1.setText("Reports");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Price Settings");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setText("Contents");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        home.studentSubmissionButton.setVisible(false);
        home.setPrintersVisible(false);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void NewBuildButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBuildButtonActionPerformed
        // TODO add your handling code here:
        ResultSet res = SolidscapeMain.dba.searchPrinterSettings("solidscape");
        try {
            if (res.next()) {
                double Price = Double.parseDouble(res.getString("materialCostPerUnit"));
            }
            PrinterBuild SolidscapeBuild = new PrinterBuild();

            SolidscapeBuild.ZcorpBuildStart("Solidscape");
            SolidscapeBuild.PrinterBuildHeader.setText("Soliscape Build Creator");
        } catch (Exception ex) {
            Settings = new SolidscapePref();
            Settings.SolidscapePrefStart();
        }
    }//GEN-LAST:event_NewBuildButtonActionPerformed

    private void OpenBuildsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenBuildsButtonActionPerformed
        // TODO add your handling code here:
        SBuild.ZcorpOpenBuildsStart("Solidscape");
        SBuild.OpenBuildsHeader.setText("Solidscape Open Builds");
    }//GEN-LAST:event_OpenBuildsButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        reports.ReportsPage();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + SolidscapeMain.getInstance().getPDFAdmin());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");  //print the error
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Settings = new SolidscapePref();
        Settings.SolidscapePrefStart();
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton NewBuildButton;
    private javax.swing.JButton OpenBuildsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
   /**
     * @return the instance
     */
    public static FileManager getInstance() {
        return instance;
    }

    /**
     * @param aInstance the instance to set
     */
    public static void setInstance(FileManager aInstance) {
        instance = aInstance;
    }

}
