package main.gui;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.GridLayout;

public class SettingGUI {
	private static JPanel mainPanel = new JPanel();
	private static JPanel changePicPanel = new JPanel();
	private static JPanel restrictPanel = new JPanel();
	private static JPanel addUserPanel = new JPanel();
	private static JTextField servURL;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	private static JTextField textField;
	private static JTextField txtTempUser;
	private static JTextField textField2;
	private static JTextField txtTempUser2;
	private static JPasswordField passwordField_2;
	private static JTextField textField_1;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void init(final JPanel mainPanelIn, final JFrame frame, final User user, final JTable table, final ArrayList<User> users, final Setting settings) {
		mainPanel.setPreferredSize(new Dimension(500, 600));
		mainPanel.setMaximumSize(new Dimension(500, 600));
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setSize(500, 600);
		mainPanel.setLayout(null);
		frame.setContentPane(mainPanel);
		
		//the upper menu panel
		JPanel menupanel = new JPanel();
		menupanel.setBorder(null);
		menupanel.setBackground(Color.DARK_GRAY);
		menupanel.setBounds(0, 11, 488, 57);
		mainPanel.add(menupanel);
		menupanel.setLayout(null);
		
		//setting logo
		JLabel lblSettings = new JLabel("");
		lblSettings.setBorder(null);
		lblSettings.setBounds(75, 5, 146, 51);
		menupanel.add(lblSettings);
		lblSettings.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/settinglogo.png")));
		lblSettings.setBackground(Color.DARK_GRAY);
		
		//gear icon
		JLabel gearIcon = new JLabel("");
		gearIcon.setBounds(25, 0, 45, 45);
		menupanel.add(gearIcon);
		gearIcon.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/big_setting.png")));
		gearIcon.setRequestFocusEnabled(false);
		gearIcon.setBackground(Color.DARK_GRAY);
		gearIcon.setBorder(null);
		
		//exit button
		JButton exitButton = new JButton("");
		exitButton.setBounds(448, 5, 30, 30);
		menupanel.add(exitButton);
		exitButton.setBorder(null);
		exitButton.setBackground(Color.DARK_GRAY);
		exitButton.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/x_icon.png")));
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(mainPanelIn);
			}
		});
		
		//current admin panel
		JPanel userPanel = new JPanel();
		userPanel.setBorder(null);
		userPanel.setBackground(Color.DARK_GRAY);
		userPanel.setBounds(12, 71, 476, 99);
		mainPanel.add(userPanel);
		userPanel.setLayout(null);
		
		//current admin icon
		JLabel usericon = new JLabel();
		usericon.setBackground(Color.DARK_GRAY);
		usericon.setBounds(0, 0, 93, 93);
		userPanel.add(usericon);
		//usericon.setIcon(new ImageIcon(LoginGUI.class.getResource(user.getSetting().getIcon())));
		usericon.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/panda_orange_2.png")));
		
		
		//current admin name
		JTextField username = new JTextField();
		username.setText(user.getName());
		username.setBounds(96, 0, 81, 23);
		userPanel.add(username);
		
		//button to confirm change pin for admin
		JButton btnChangePin = new JButton("Change Pin");
		btnChangePin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnChangePin.setBorder(null);
		btnChangePin.setForeground(Color.WHITE);
		btnChangePin.setBackground(Color.GRAY);
		btnChangePin.setBounds(183, 24, 114, 25);
		userPanel.add(btnChangePin);
		
		
		//button to confirm change pic for admin
		JButton btnChangeProfilePic = new JButton("Change Profile Pic");
		btnChangeProfilePic.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnChangeProfilePic.setBorder(null);
		btnChangeProfilePic.setForeground(Color.WHITE);
		btnChangeProfilePic.setBackground(Color.GRAY);
		btnChangeProfilePic.setBounds(96, 57, 138, 25);
		btnChangeProfilePic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePicPanel.setPreferredSize(new Dimension(500, 600));
				changePicPanel.setMaximumSize(new Dimension(500, 600));
				changePicPanel.setBackground(Color.DARK_GRAY);
				changePicPanel.setSize(500, 600);
				frame.setContentPane(changePicPanel);
				changePicPanel.setLayout(null);
				
				JLabel chooseLabel = new JLabel("Please choose a new picture:");
				chooseLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
				chooseLabel.setForeground(Color.WHITE);
				chooseLabel.setBackground(Color.DARK_GRAY);
				chooseLabel.setBounds(10, 11, 234, 32);
				changePicPanel.add(chooseLabel);
				
				JPanel pics = new JPanel();
				pics.setBorder(null);
				pics.setBackground(Color.GRAY);
				pics.setBounds(30, 54, 444, 327);
				changePicPanel.add(pics);
				pics.setLayout(null);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/panda_blue_2.png")));
				btnNewButton.setBorder(null);
				btnNewButton.setBackground(Color.GRAY);
				btnNewButton.setBounds(20, 11, 93, 93);
				pics.add(btnNewButton);
				
				JButton button = new JButton("");
				button.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/panda_green_2.png")));
				button.setBorder(null);
				button.setBackground(Color.GRAY);
				button.setBounds(123, 11, 93, 93);
				pics.add(button);
				
				JButton button_1 = new JButton("");
				button_1.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/panda_orange_2.png")));
				button_1.setBorder(null);
				button_1.setBackground(Color.GRAY);
				button_1.setBounds(226, 11, 93, 93);
				pics.add(button_1);
				
				JButton button_2 = new JButton("");
				button_2.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/panda_pink_2.png")));
				button_2.setBorder(null);
				button_2.setBackground(Color.GRAY);
				button_2.setBounds(329, 11, 93, 93);
				pics.add(button_2);
				
				JButton button_3 = new JButton("");
				button_3.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_blue.png")));
				button_3.setBorder(null);
				button_3.setBackground(Color.GRAY);
				button_3.setBounds(20, 115, 93, 93);
				pics.add(button_3);
				
				JButton button_4 = new JButton("");
				button_4.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_green.png")));
				button_4.setBorder(null);
				button_4.setBackground(Color.GRAY);
				button_4.setBounds(123, 115, 93, 93);
				pics.add(button_4);
				
				JButton button_5 = new JButton("");
				button_5.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_orange.png")));
				button_5.setBorder(null);
				button_5.setBackground(Color.GRAY);
				button_5.setBounds(226, 115, 93, 93);
				pics.add(button_5);
				
				JButton button_6 = new JButton("");
				button_6.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_pink.png")));
				button_6.setBorder(null);
				button_6.setBackground(Color.GRAY);
				button_6.setBounds(329, 115, 93, 93);
				pics.add(button_6);
				
				JButton button_7 = new JButton("");
				button_7.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/smile_blue.png")));
				button_7.setBorder(null);
				button_7.setBackground(Color.GRAY);
				button_7.setBounds(20, 219, 93, 93);
				pics.add(button_7);
				
				JButton button_8 = new JButton("");
				button_8.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/smile_green.png")));
				button_8.setBorder(null);
				button_8.setBackground(Color.GRAY);
				button_8.setBounds(123, 219, 93, 93);
				pics.add(button_8);
				
				JButton button_9 = new JButton("");
				button_9.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/smile_orange.png")));
				button_9.setBorder(null);
				button_9.setBackground(Color.GRAY);
				button_9.setBounds(226, 219, 93, 93);
				pics.add(button_9);
				
				JButton button_10 = new JButton("");
				button_10.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/smile_pink.png")));
				button_10.setBorder(null);
				button_10.setBackground(Color.GRAY);
				button_10.setBounds(329, 219, 93, 93);
				pics.add(button_10);
				
				JLabel uploadLbl = new JLabel("Or select a file to upload");
				uploadLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
				uploadLbl.setForeground(Color.WHITE);
				uploadLbl.setBounds(186, 392, 167, 32);
				changePicPanel.add(uploadLbl);
				
				JButton upload = new JButton("Upload");
				upload.setBackground(Color.GRAY);
				upload.setForeground(Color.WHITE);
				upload.setBorderPainted(false);
				upload.setBorder(null);
				upload.setBounds(385, 399, 89, 23);
				changePicPanel.add(upload);
				
				JButton confirm = new JButton("Confirm");
				confirm.setForeground(Color.WHITE);
				confirm.setFont(new Font("Tahoma", Font.PLAIN, 21));
				confirm.setBorder(null);
				confirm.setBackground(Color.GRAY);
				confirm.setBounds(30, 501, 117, 32);
				changePicPanel.add(confirm);
				
				JButton cancel = new JButton("Cancel");
				cancel.setForeground(UIManager.getColor("OptionPane.errorDialog.border.background"));
				cancel.setFont(new Font("Tahoma", Font.PLAIN, 21));
				cancel.setBorder(null);
				cancel.setBackground(Color.GRAY);
				cancel.setBounds(357, 501, 117, 32);
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setContentPane(mainPanel);
					}
				});
				changePicPanel.add(cancel);
			}
		});
		userPanel.add(btnChangeProfilePic);
		
		//admin change pin field
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(96, 24, 81, 22);
		userPanel.add(passwordField);
		
		JButton chngName = new JButton("Change Name");
		chngName.setFont(new Font("Dialog", Font.PLAIN, 11));
		chngName.setForeground(Color.WHITE);
		chngName.setBackground(Color.GRAY);
		chngName.setBounds(183, 0, 114, 23);
		userPanel.add(chngName);
		
		//admin panel server panel
		JPanel servPanel = new JPanel();
		servPanel.setBackground(Color.DARK_GRAY);
		servPanel.setBounds(12, 170, 478, 99);
		mainPanel.add(servPanel);
		servPanel.setLayout(null);
		
		//server logo
		JLabel lblServer = new JLabel("");
		lblServer.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/server.png")));
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setBackground(Color.DARK_GRAY);
		lblServer.setBounds(0, 0, 115, 39);
		servPanel.add(lblServer);
		
		//server url
		servURL = new JTextField();
		servURL.setBounds(22, 34, 205, 27);
		servPanel.add(servURL);
		servURL.setColumns(10);
		
		//confirm server url change button
		JButton btnChangeServerUrl = new JButton("Change Server URL");
		btnChangeServerUrl.setForeground(Color.WHITE);
		btnChangeServerUrl.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnChangeServerUrl.setBorder(null);
		btnChangeServerUrl.setBackground(Color.GRAY);
		btnChangeServerUrl.setBounds(237, 33, 138, 26);
		servPanel.add(btnChangeServerUrl);
		
		//admin total manage restriction
		JButton btnManageRestrictionLevels = new JButton("Manage Restriction Levels");
		btnManageRestrictionLevels.setForeground(Color.WHITE);
		btnManageRestrictionLevels.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnManageRestrictionLevels.setBorder(null);
		btnManageRestrictionLevels.setBackground(Color.GRAY);
		btnManageRestrictionLevels.setBounds(22, 72, 205, 25);
		btnManageRestrictionLevels.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				restrictPanel.setBackground(Color.DARK_GRAY);
				restrictPanel.setSize(500, 600);
				restrictPanel.setLayout(null);
				frame.setContentPane(restrictPanel);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBackground(Color.DARK_GRAY);
				scrollPane.setViewportBorder(null);
				scrollPane.setBorder(null);
				scrollPane.setBounds(8, 47, 484, 369);
				scrollPane.add(table);
				restrictPanel.add(scrollPane);
				
				JLabel lblSelectAnAlbum = new JLabel("Select an album:");
				lblSelectAnAlbum.setForeground(Color.WHITE);
				lblSelectAnAlbum.setFont(new Font("Dialog", Font.BOLD, 18));
				lblSelectAnAlbum.setBackground(Color.DARK_GRAY);
				lblSelectAnAlbum.setBounds(8, 12, 341, 23);
				restrictPanel.add(lblSelectAnAlbum);
				
				JLabel lblSetRestrictionLevel = new JLabel("Set Restriction Level:");
				lblSetRestrictionLevel.setForeground(Color.WHITE);
				lblSetRestrictionLevel.setFont(new Font("Dialog", Font.BOLD, 18));
				lblSetRestrictionLevel.setBackground(Color.DARK_GRAY);
				lblSetRestrictionLevel.setBounds(8, 428, 318, 23);
				restrictPanel.add(lblSetRestrictionLevel);
				
				JButton btnConfirm = new JButton("Confirm");
				btnConfirm.setBorder(null);
				btnConfirm.setForeground(Color.WHITE);
				btnConfirm.setBackground(Color.GRAY);
				btnConfirm.setBounds(12, 542, 117, 25);
				restrictPanel.add(btnConfirm);
				
				textField = new JTextField();
				textField.setBounds(354, 431, 114, 19);
				restrictPanel.add(textField);
				textField.setColumns(10);
				
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setForeground(UIManager.getColor("OptionPane.errorDialog.border.background"));
				btnCancel.setBorder(null);
				btnCancel.setBackground(Color.GRAY);
				btnCancel.setBounds(371, 542, 117, 25);
				btnCancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.setContentPane(mainPanel);
					}
				});
				restrictPanel.add(btnCancel);
			}
		});
		servPanel.add(btnManageRestrictionLevels);
		
		
		//users label
		JLabel lblUsers = new JLabel("");
		lblUsers.setBounds(32, 281, 100, 30);
		mainPanel.add(lblUsers);
		lblUsers.setOpaque(true);
		lblUsers.setPreferredSize(new Dimension(450, 30));
		lblUsers.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/user.png")));
		lblUsers.setBackground(Color.DARK_GRAY);
		
		//the other accounts panel
		JPanel scrollpanel = new JPanel();
		scrollpanel.setBackground(Color.DARK_GRAY);
		scrollpanel.setAutoscrolls(true);
		scrollpanel.setLayout(new BoxLayout(scrollpanel, BoxLayout.Y_AXIS));
		
		JScrollPane accPanel = new JScrollPane(scrollpanel);
		accPanel.setViewportBorder(null);
		accPanel.setVerifyInputWhenFocusTarget(false);
		accPanel.setOpaque(false);
		accPanel.setForeground(Color.DARK_GRAY);
		accPanel.setBorder(null);
		accPanel.setBackground(Color.DARK_GRAY);
		accPanel.setBounds(10, 315, 478, 285);
		accPanel.getVerticalScrollBar().setUnitIncrement(100);
		mainPanel.add(accPanel);
		
		//example panel
		JPanel exPanel = new JPanel();
		exPanel.setMinimumSize(new Dimension(460, 25));
		exPanel.setMaximumSize(new Dimension(460, 125));
		exPanel.setPreferredSize(new Dimension(460, 125));
		exPanel.setSize(new Dimension(460, 125));
		scrollpanel.add(exPanel);
		exPanel.setBorder(null);
		exPanel.setBackground(Color.DARK_GRAY);
		exPanel.setLayout(null);
		
		//example icon
		JLabel exIcon = new JLabel();
		exIcon.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_blue.png")));
		exIcon.setBorder(null);
		exIcon.setBounds(10, 3, 93, 93);
		exPanel.add(exIcon);
		
		//example user change pin
		JButton chngPin = new JButton("Change Pin");
		chngPin.setForeground(Color.WHITE);
		chngPin.setFont(new Font("Dialog", Font.PLAIN, 11));
		chngPin.setBorder(null);
		chngPin.setBackground(Color.GRAY);
		chngPin.setBounds(205, 30, 119, 25);
		exPanel.add(chngPin);
		
		//example user change profile pic button
		JButton chngPic = new JButton("Change Profile Pic");
		chngPic.setForeground(Color.WHITE);
		chngPic.setFont(new Font("Dialog", Font.PLAIN, 11));
		chngPic.setBorder(null);
		chngPic.setBackground(Color.GRAY);
		chngPic.setBounds(113, 85, 138, 25);
		exPanel.add(chngPic);
		
		//example user manage restrictions
		JButton btnManageRestrictions = new JButton("Manage Restrictions");
		btnManageRestrictions.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnManageRestrictions.setForeground(Color.WHITE);
		btnManageRestrictions.setBorder(null);
		btnManageRestrictions.setBackground(Color.GRAY);
		btnManageRestrictions.setBounds(261, 85, 138, 25);
		exPanel.add(btnManageRestrictions);
		
		//example user change pin
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(113, 32, 86, 22);
		exPanel.add(passwordField_1);
		
		//example user name
		txtTempUser = new JTextField();
		txtTempUser.setText("Temp User");
		txtTempUser.setBounds(113, 4, 86, 20);
		exPanel.add(txtTempUser);
		txtTempUser.setColumns(10);
		
		//example user change name button
		JButton changeName = new JButton("Change Name");
		changeName.setFont(new Font("Dialog", Font.PLAIN, 11));
		changeName.setForeground(Color.WHITE);
		changeName.setBackground(Color.GRAY);
		changeName.setBounds(205, 3, 119, 23);
		exPanel.add(changeName);
		
		JButton deleteacc = new JButton("");
		deleteacc.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/red_x_icon.png")));
		deleteacc.setBorder(null);
		deleteacc.setBackground(Color.DARK_GRAY);
		deleteacc.setBounds(428, 3, 30, 30);
		exPanel.add(deleteacc);
		scrollpanel.add(exPanel);
		
		JRadioButton userRadio = new JRadioButton("User");
		userRadio.setSelected(true);
		userRadio.setBackground(Color.DARK_GRAY);
		userRadio.setBorder(null);
		userRadio.setForeground(Color.WHITE);
		userRadio.setBounds(111, 58, 56, 20);
		exPanel.add(userRadio);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBorder(null);
		rdbtnAdmin.setBackground(Color.DARK_GRAY);
		rdbtnAdmin.setForeground(Color.WHITE);
		rdbtnAdmin.setBounds(173, 58, 56, 23);
		exPanel.add(rdbtnAdmin);
		
		//start of the second example panel
		JPanel exPanel2 = new JPanel();
		exPanel2.setLayout(null);
		exPanel2.setSize(new Dimension(460, 120));
		exPanel2.setPreferredSize(new Dimension(460, 120));
		exPanel2.setMinimumSize(new Dimension(460, 120));
		exPanel2.setMaximumSize(new Dimension(460, 120));
		exPanel2.setBorder(null);
		exPanel2.setBackground(Color.DARK_GRAY);
		scrollpanel.add(exPanel2);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/smile_green.png")));
		label.setBorder(null);
		label.setBounds(10, 3, 93, 93);
		exPanel2.add(label);
		
		JButton button = new JButton("Change Pin");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.PLAIN, 11));
		button.setBorder(null);
		button.setBackground(Color.GRAY);
		button.setBounds(205, 30, 119, 25);
		exPanel2.add(button);
		
		JButton button_1 = new JButton("Change Profile Pic");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_1.setBorder(null);
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(113, 68, 138, 25);
		exPanel2.add(button_1);
		
		JButton button_2 = new JButton("Manage Restrictions");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_2.setBorder(null);
		button_2.setBackground(Color.GRAY);
		button_2.setBounds(261, 68, 138, 25);
		exPanel2.add(button_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setEchoChar('*');
		passwordField_2.setBounds(113, 32, 86, 22);
		exPanel2.add(passwordField_2);
		
		textField_1 = new JTextField();
		textField_1.setText("Temp User");
		textField_1.setColumns(10);
		textField_1.setBounds(113, 4, 86, 20);
		exPanel2.add(textField_1);
		
		JButton button_3 = new JButton("Change Name");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_3.setBackground(Color.GRAY);
		button_3.setBounds(205, 3, 119, 23);
		exPanel2.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/red_x_icon.png")));
		button_4.setBorder(null);
		button_4.setBackground(Color.DARK_GRAY);
		button_4.setBounds(428, 3, 30, 30);
		exPanel2.add(button_4);
		addUserPanel.setMaximumSize(new Dimension(460, 75));
		addUserPanel.setMinimumSize(new Dimension(460, 75));
		addUserPanel.setSize(new Dimension(460, 75));
		addUserPanel.setPreferredSize(new Dimension(460, 75));
		
		//new user panel
		addUserPanel.setBackground(Color.DARK_GRAY);
		addUserPanel.setLayout(null);
		
		//add user button
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddUser.setBackground(Color.GRAY);
		btnAddUser.setBorder(null);
		btnAddUser.setBounds(146, 12, 156, 42);
		btnAddUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		addUserPanel.add(btnAddUser);
		scrollpanel.add(addUserPanel);
	}
}
