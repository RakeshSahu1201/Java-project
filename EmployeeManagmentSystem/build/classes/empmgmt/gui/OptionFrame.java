/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.gui;

import empmgmt.dbutil.DBConnection;
import javax.swing.JOptionPane;


public class OptionFrame extends javax.swing.JFrame {

    /**
     * Creates new form OptionFrame
     */
    public OptionFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jrbAddEmp = new javax.swing.JRadioButton();
        jrbSearchEmp = new javax.swing.JRadioButton();
        jrbDeleteEmp = new javax.swing.JRadioButton();
        jrbQuit = new javax.swing.JRadioButton();
        btnDoTask = new javax.swing.JButton();
        jrbUpdateEmp = new javax.swing.JRadioButton();
        jrbViewAllEmp = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Your Choice");

        jrbAddEmp.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbAddEmp);
        jrbAddEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbAddEmp.setForeground(new java.awt.Color(255, 255, 255));
        jrbAddEmp.setText("Add Employee");

        jrbSearchEmp.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbSearchEmp);
        jrbSearchEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbSearchEmp.setForeground(new java.awt.Color(255, 255, 255));
        jrbSearchEmp.setText("Search Employee");

        jrbDeleteEmp.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbDeleteEmp);
        jrbDeleteEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbDeleteEmp.setForeground(new java.awt.Color(255, 255, 255));
        jrbDeleteEmp.setText("Delete Employee");

        jrbQuit.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbQuit);
        jrbQuit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbQuit.setForeground(new java.awt.Color(255, 255, 255));
        jrbQuit.setText("Quit");

        btnDoTask.setBackground(new java.awt.Color(0, 0, 0));
        btnDoTask.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDoTask.setForeground(new java.awt.Color(255, 255, 255));
        btnDoTask.setText("Do Task");
        btnDoTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoTaskActionPerformed(evt);
            }
        });

        jrbUpdateEmp.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbUpdateEmp);
        jrbUpdateEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbUpdateEmp.setForeground(new java.awt.Color(255, 255, 255));
        jrbUpdateEmp.setText("Update Employee");

        jrbViewAllEmp.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrbViewAllEmp);
        jrbViewAllEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrbViewAllEmp.setForeground(new java.awt.Color(255, 255, 255));
        jrbViewAllEmp.setText("View All Employee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbViewAllEmp)
                    .addComponent(jrbUpdateEmp)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jrbAddEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbSearchEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addComponent(jrbDeleteEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(btnDoTask, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jrbQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jrbAddEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbSearchEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbDeleteEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbUpdateEmp)
                .addGap(18, 18, 18)
                .addComponent(jrbViewAllEmp)
                .addGap(16, 16, 16)
                .addComponent(jrbQuit)
                .addGap(44, 44, 44)
                .addComponent(btnDoTask, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoTaskActionPerformed
        if(validateInput()==false)
        {
            JOptionPane.showMessageDialog(null,"please select a task","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jrbAddEmp.isSelected())
        {
            AddEmployeeFrame Aemp = new AddEmployeeFrame();
            Aemp.setVisible(true);
            this.dispose();
        }
        else if(jrbSearchEmp.isSelected())
        {
            SearchEmployeeFrame searchemp = new SearchEmployeeFrame();
            searchemp.setVisible(true);
            this.dispose();
        }
        else if(jrbDeleteEmp.isSelected())
        {
            DeleteEmployeeFrame deleteemp = new DeleteEmployeeFrame();
            deleteemp.setVisible(true);
            this.dispose();
        }
        else if(jrbUpdateEmp.isSelected())
        {
            UpdateEmployeeFrame updateemp = new UpdateEmployeeFrame();
            updateemp.setVisible(true);
            this.dispose();
        }
        else if(jrbViewAllEmp.isSelected())
        {
            ViewAllEmployeeFrame viewAllemp = new ViewAllEmployeeFrame();
            viewAllemp.setVisible(true);
            this.dispose();
        }
        else
        {
            DBConnection.closeConnection();
            JOptionPane.showMessageDialog(null,"Thanks for using the app !","Thanks !",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_btnDoTaskActionPerformed

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
            java.util.logging.Logger.getLogger(OptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoTask;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jrbAddEmp;
    private javax.swing.JRadioButton jrbDeleteEmp;
    private javax.swing.JRadioButton jrbQuit;
    private javax.swing.JRadioButton jrbSearchEmp;
    private javax.swing.JRadioButton jrbUpdateEmp;
    private javax.swing.JRadioButton jrbViewAllEmp;
    // End of variables declaration//GEN-END:variables

    private boolean validateInput() {
        return !(jrbAddEmp.isSelected()==false && jrbSearchEmp.isSelected()==false &&
                jrbDeleteEmp.isSelected()==false && jrbUpdateEmp.isSelected()==false &&
                jrbViewAllEmp.isSelected()==false && jrbQuit.isSelected()==false);
    }
}
