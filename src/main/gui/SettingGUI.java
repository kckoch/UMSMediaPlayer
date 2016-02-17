package main.gui;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class SettingGUI {
	private static JPanel mainPanel = new JPanel();
	private static JPanel changePicPanel = new JPanel();
	private static JPanel restrictPanel = new JPanel();
	private static JTextField servURL;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	private static JTextField textField;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void init(final JPanel mainPanelIn, final JFrame frame, final User user, final JTable table) {
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
		JLabel username = new JLabel("");
		username.setFont(new Font("Dialog", Font.BOLD, 18));
		username.setForeground(Color.WHITE);
		username.setBackground(Color.DARK_GRAY);
		username.setText(user.getName());
		username.setBounds(96, 0, 81, 25);
		userPanel.add(username);
		
		//button to confirm change pin for admin
		JButton btnChangePin = new JButton("Change Pin");
		btnChangePin.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnChangePin.setBorder(null);
		btnChangePin.setForeground(Color.WHITE);
		btnChangePin.setBackground(Color.GRAY);
		btnChangePin.setBounds(187, 21, 93, 25);
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
		passwordField.setBounds(96, 24, 76, 22);
		userPanel.add(passwordField);
		
		//the other accounts panel
		JPanel accPanel = new JPanel();
		accPanel.setBorder(null);
		accPanel.setBackground(Color.DARK_GRAY);
		accPanel.setBounds(10, 280, 478, 309);
		mainPanel.add(accPanel);
		accPanel.setLayout(null);
		
		//example panel
		JPanel exPanel = new JPanel();
		exPanel.setBorder(null);
		exPanel.setBackground(Color.DARK_GRAY);
		exPanel.setBounds(10, 45, 458, 101);
		accPanel.add(exPanel);
		exPanel.setLayout(null);
		
		//example icon
		JLabel exIcon = new JLabel();
		exIcon.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_blue.png")));
		exIcon.setBorder(null);
		exIcon.setBounds(10, 3, 93, 93);
		exPanel.add(exIcon);
		
		//example user name
		JLabel lblTempUser = new JLabel("Temp User");
		lblTempUser.setBackground(Color.DARK_GRAY);
		lblTempUser.setForeground(Color.WHITE);
		lblTempUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTempUser.setBounds(116, 3, 103, 32);
		exPanel.add(lblTempUser);
		
		//example user change pin
		JButton button = new JButton("Change Pin");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.PLAIN, 11));
		button.setBorder(null);
		button.setBackground(Color.GRAY);
		button.setBounds(205, 32, 93, 25);
		exPanel.add(button);
		
		//example user change profile pic button
		JButton button_1 = new JButton("Change Profile Pic");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_1.setBorder(null);
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(113, 68, 138, 25);
		exPanel.add(button_1);
		
		//example user manage restrictions
		JButton btnManageRestrictions = new JButton("Manage Restrictions");
		btnManageRestrictions.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnManageRestrictions.setForeground(Color.WHITE);
		btnManageRestrictions.setBorder(null);
		btnManageRestrictions.setBackground(Color.GRAY);
		btnManageRestrictions.setBounds(261, 68, 138, 25);
		exPanel.add(btnManageRestrictions);
		
		//example user change pin
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(113, 35, 76, 22);
		exPanel.add(passwordField_1);
		
		//users label
		JLabel lblUsers = new JLabel("");
		lblUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsers.setBounds(0, 0, 110, 34);
		accPanel.add(lblUsers);
		lblUsers.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/user.png")));
		lblUsers.setBackground(Color.DARK_GRAY);
		
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
		lblServer.setFont(new Font("Lobster Two", Font.BOLD, 30));
		lblServer.setForeground(Color.WHITE);
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
	}
}
