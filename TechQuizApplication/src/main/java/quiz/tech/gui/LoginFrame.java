/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.tech.gui;

import java.awt.Frame;

import quiz.tech.dao.UserDao;
import quiz.tech.dbconnection.HibernateConnection;
import quiz.tech.entities.User;
import quiz.tech.utils.UserProfile;

/**
 *
 * @author spsub
 */
public class LoginFrame extends javax.swing.JFrame {

	/**
	 * Creates new form LoginFrame
	 */

	private Frame showFrame;
	private User user;

	public LoginFrame() {
		initComponents();
		this.setLocationRelativeTo(null);
		user = new User();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		myPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtUserId = new javax.swing.JTextField();
		txtPassword = new javax.swing.JPasswordField();
		btnLogin = new javax.swing.JButton();
		btnQuit = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jrAdmin = new javax.swing.JRadioButton();
		jrStudent = new javax.swing.JRadioButton();
		lblRegister = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Tech Quiz App");

		myPanel.setBackground(new java.awt.Color(0, 0, 0));

		jLabel1.setBackground(new java.awt.Color(51, 51, 51));
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(153, 255, 102));
		jLabel1.setText("User Login Screen");

		jLabel2.setBackground(new java.awt.Color(51, 51, 51));
		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(153, 255, 102));
		jLabel2.setText("User Id");

		jLabel3.setBackground(new java.awt.Color(51, 51, 51));
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(153, 255, 102));
		jLabel3.setText("Password");

		txtUserId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		btnLogin.setBackground(new java.awt.Color(0, 0, 0));
		btnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnLogin.setForeground(new java.awt.Color(153, 255, 102));
		btnLogin.setText("Login");
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLoginActionPerformed(evt);
			}
		});

		btnQuit.setBackground(new java.awt.Color(0, 0, 0));
		btnQuit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnQuit.setForeground(new java.awt.Color(153, 255, 102));
		btnQuit.setText("Quit");
		btnQuit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQuitActionPerformed(evt);
			}
		});

		jLabel4.setBackground(new java.awt.Color(51, 51, 51));
		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(153, 255, 102));
		jLabel4.setText("UserType");

		jrAdmin.setBackground(new java.awt.Color(51, 51, 51));
		buttonGroup1.add(jrAdmin);
		jrAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jrAdmin.setForeground(new java.awt.Color(153, 255, 102));
		jrAdmin.setText("Admin");

		jrStudent.setBackground(new java.awt.Color(51, 51, 51));
		buttonGroup1.add(jrStudent);
		jrStudent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jrStudent.setForeground(new java.awt.Color(153, 255, 102));
		jrStudent.setText("Student");

		lblRegister.setBackground(new java.awt.Color(51, 51, 51));
		lblRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblRegister.setForeground(new java.awt.Color(153, 255, 102));
		lblRegister.setText("<html><u>Register Here</u></html>");
		lblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblRegisterMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout myPanelLayout = new javax.swing.GroupLayout(myPanel);
		myPanel.setLayout(myPanelLayout);
		myPanelLayout.setHorizontalGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(myPanelLayout.createSequentialGroup().addGap(84, 84, 84).addGroup(myPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(myPanelLayout.createSequentialGroup()
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(myPanelLayout.createSequentialGroup()
								.addGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(myPanelLayout.createSequentialGroup().addGroup(myPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 99,
														Short.MAX_VALUE)
												.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGap(18, 18, 18)
												.addGroup(myPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtUserId).addComponent(txtPassword)))
										.addGroup(myPanelLayout.createSequentialGroup()
												.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, Short.MAX_VALUE).addComponent(btnQuit,
														javax.swing.GroupLayout.PREFERRED_SIZE, 140,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(lblRegister))
								.addGap(84, 84, 84))
						.addGroup(myPanelLayout.createSequentialGroup()
								.addComponent(jrAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jrStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(134, 134, 134))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(106, 106, 106)));
		myPanelLayout.setVerticalGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(myPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(26, 26, 26)
						.addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jrAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jrStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				myPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				myPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed

		if (isValidInput())
			return;

		String userName = UserDao.ValidateUser(user);

		if (userName == null) {
			System.out.println("invalid userid or password");
			return;
		}

		System.out.println("logged in successfully.");
		UserProfile.setUserId(user.getUserId());
		UserProfile.setUserName(userName);
		UserProfile.setUserType(user.getUserType());

		if (user.getUserType().equalsIgnoreCase("ADMIN")) {
			showFrame = new AdminOptionFrame();
		} else {
			showFrame = new StudentOptionFrame();
		}

		showFrame.setVisible(true);
		this.dispose();

	}// GEN-LAST:event_btnLoginActionPerformed

	private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnQuitActionPerformed

		System.out.println("Thank you");
		HibernateConnection.closeConnection();
		System.exit(0);

	}// GEN-LAST:event_btnQuitActionPerformed

	private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblRegisterMouseClicked

		showFrame = new RegistrationFrame();
		showFrame.setVisible(true);
		this.dispose();

	}// GEN-LAST:event_lblRegisterMouseClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLogin;
	private javax.swing.JButton btnQuit;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JRadioButton jrAdmin;
	private javax.swing.JRadioButton jrStudent;
	private javax.swing.JLabel lblRegister;
	private javax.swing.JPanel myPanel;
	private javax.swing.JPasswordField txtPassword;
	private javax.swing.JTextField txtUserId;
	// End of variables declaration//GEN-END:variables

	private boolean isValidInput() {

		String password = String.valueOf(txtPassword.getPassword());

		if (txtUserId.getText().isEmpty() || password.isEmpty()) {
			System.out.println("please fill all the values");
			return true;
		}

		if (jrAdmin.isSelected()) {
			user.setUserType(jrAdmin.getText().toUpperCase());
		} else if (jrStudent.isSelected()) {
			user.setUserType(jrStudent.getText().toUpperCase());
		} else {
			System.out.println("please select the user type.");
			return true;
		}

		try {
			int userId = Integer.parseInt(txtUserId.getText());
			user.setUserId(userId);
		} catch (NumberFormatException ex) {
			System.out.println("please input number as login id");
			return true;
		}
		
		
		user.setPassword(password);

		return false;
	}
}