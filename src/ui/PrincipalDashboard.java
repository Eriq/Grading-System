/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import database.DBConnection;
import studentgrades.StudentGrades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Steve Karanja
 */
public class PrincipalDashboard extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalDashboard
     */
    
    int mouseX;
    int mouseY;
    
    public PrincipalDashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentMarksTable = new javax.swing.JTable();
        formSelector = new javax.swing.JComboBox<>();
        subjectSelector = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        streamSelector = new javax.swing.JComboBox<>();
        btnFormReports = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnStreamReports = new javax.swing.JButton();
        btnClassReports = new javax.swing.JButton();
        termSelector = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 250, 154));

        jLabel1.setBackground(new java.awt.Color(0, 250, 154));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRINCIPAL DASHBOARD");

        userLabel.setBackground(new java.awt.Color(0, 250, 154));
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolgrades/Misc-User-icon.png"))); // NOI18N
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });

        closeLabel.setBackground(new java.awt.Color(0, 250, 154));
        closeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        closeLabel.setForeground(new java.awt.Color(255, 255, 255));
        closeLabel.setText("X");
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131)
                .addComponent(userLabel)
                .addGap(26, 26, 26)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(70, 130, 180));

        jLabel2.setBackground(new java.awt.Color(70, 130, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("My classes:");

        DBConnection dc = new DBConnection();
        Connection conn = dc.getConnection();

        String query = "SELECT t1.reg_no, t1.name, t2.opener, t2.midterm, t2.endterm  FROM students t1 LEFT JOIN exams t2 ON " +
                "t1.reg_no = t2.reg_no WHERE t1.stream='A' AND t2.subject=1 AND t2.form=1 AND t2.term=1 AND t2.year=2019;";

        Object columnNames[] = { "Reg No", "Name", "Opening Exam", "Mid-Term Exam", "End-Term Exam"};

        //Object[] rowData;
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        //execute query and store data in resultset
        try {
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                Object rowData[] = {rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),};
                model.addRow(rowData);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

        studentMarksTable.setModel(model);
        jScrollPane1.setViewportView(studentMarksTable);

        formSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));
        formSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formSelectorActionPerformed(evt);
            }
        });

        subjectSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maths", "English", "Kiswahili", "Chemistry", "Physics", "Biology", "History", "Geography", "R.E", "Computer Studies", "Business", "Agriculture", "French", "German" }));
        subjectSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectSelectorActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolgrades/search.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        streamSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        streamSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamSelectorActionPerformed(evt);
            }
        });

        btnFormReports.setText("FORM REPORTS");
        btnFormReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormReportsActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolgrades/add.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(70, 130, 180));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Reports:");

        btnStreamReports.setText("STREAM REPORTS");
        btnStreamReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStreamReportsActionPerformed(evt);
            }
        });

        btnClassReports.setText("MY CLASS REPORTS");
        btnClassReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassReportsActionPerformed(evt);
            }
        });

        termSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Term 1", "Term 2", "Term 3" }));
        termSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subjectSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(formSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(streamSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(termSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnFormReports, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnClassReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addGap(103, 103, 103)
                .addComponent(btnStreamReports, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(termSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFormReports, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClassReports, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStreamReports, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        int sub, sForm , sTerm;
        String sStream = streamSelector.getSelectedItem().toString();
        sub = StudentGrades.getSubjectCode(subjectSelector.getSelectedItem().toString());
        sForm = StudentGrades.getFormCode(formSelector.getSelectedItem().toString());
        sTerm = StudentGrades.getTermCode(termSelector.getSelectedItem().toString());

        DBConnection dc = new DBConnection();
        Connection conn = dc.getConnection();

        String query = "SELECT t1.reg_no, t1.name, t2.opener, t2.midterm, t2.endterm  FROM students t1 LEFT JOIN exams t2 ON " +
                "t1.reg_no = t2.reg_no WHERE t1.stream='"+sStream+"' AND t2.subject="+sub+" AND t2.form="+sForm+" AND t2.term="+sTerm+" AND t2.year=2019;";

        Object columnNames[] = { "Reg No", "Name", "Opening Exam", "Mid-Term Exam", "End-Term Exam"};

        //Object[] rowData;
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        //execute query and store data in resultset
        try {
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                Object rowData[] = {rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),};
                model.addRow(rowData);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        studentMarksTable.setModel(model);
        jScrollPane1.setViewportView(studentMarksTable);

    }//GEN-LAST:event_btnSearchActionPerformed

    private void formSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formSelectorActionPerformed

    private void subjectSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectSelectorActionPerformed

    private void streamSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamSelectorActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFormReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormReportsActionPerformed
        // go to form reports window
        PrincipalFormReports formRpts = new PrincipalFormReports();
        formRpts.setVisible(true);
        formRpts.pack();
        formRpts.setLocationRelativeTo(null);
        formRpts.setDefaultCloseOperation(formRpts.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnFormReportsActionPerformed

    private void btnStreamReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStreamReportsActionPerformed
        // TODO add your handling code here:
        PrincipalStreamReports streamRpts = new PrincipalStreamReports();
        streamRpts.setVisible(true);
        streamRpts.pack();
        streamRpts.setLocationRelativeTo(null);
        streamRpts.setDefaultCloseOperation(streamRpts.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_btnStreamReportsActionPerformed

    private void btnClassReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassReportsActionPerformed
        // TODO add your handling code here:
        PrincipalClassReports pplClassRpts = new PrincipalClassReports();
        pplClassRpts.setVisible(true);
        pplClassRpts.pack();
        pplClassRpts.setLocationRelativeTo(null);
        pplClassRpts.setDefaultCloseOperation(pplClassRpts.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnClassReportsActionPerformed

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        // close application
        System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int cordinateX = evt.getXOnScreen();
        int cordinateY = evt.getYOnScreen();
        
        this.setLocation(cordinateX - mouseX, cordinateY - mouseY);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void termSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_termSelectorActionPerformed

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        // TODO add your handling code here:
        PrincipalLogin pplLogin = new PrincipalLogin();
        pplLogin.setVisible(true);
        pplLogin.pack();
        pplLogin.setLocationRelativeTo(null);
        pplLogin.setDefaultCloseOperation(pplLogin.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_userLabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClassReports;
    private javax.swing.JButton btnFormReports;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStreamReports;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JComboBox<String> formSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> streamSelector;
    private javax.swing.JTable studentMarksTable;
    private javax.swing.JComboBox<String> subjectSelector;
    private javax.swing.JComboBox<String> termSelector;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
