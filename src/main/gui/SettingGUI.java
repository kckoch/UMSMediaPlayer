package main.gui;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class SettingGUI {
	private static JPanel mainPanel = new JPanel();
	private static JTextField servURL;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel init(final JPanel mainPanelIn, final JFrame frame, final User user) {
		mainPanel.setPreferredSize(new Dimension(500, 600));
		mainPanel.setMaximumSize(new Dimension(500, 600));
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setSize(500, 600);
		mainPanel.setLayout(null);
		frame.setContentPane(mainPanel);
		
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
		lblSettings.setForeground(Color.WHITE);
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
		
		//current account panel, will be visible to any account type
		JPanel userPanel = new JPanel();
		userPanel.setBorder(null);
		userPanel.setBackground(Color.DARK_GRAY);
		userPanel.setBounds(12, 71, 476, 149);
		mainPanel.add(userPanel);
		userPanel.setLayout(null);
		
		JLabel usericon = new JLabel("");
		usericon.setBackground(Color.DARK_GRAY);
		usericon.setBounds(12, 36, 93, 93);
		userPanel.add(usericon);
		usericon.setIcon(new ImageIcon(LoginGUI.class.getResource(user.getSetting().getIcon())));
		
		JLabel username = new JLabel("");
		username.setFont(new Font("Dialog", Font.BOLD, 21));
		username.setForeground(Color.WHITE);
		username.setBackground(Color.DARK_GRAY);
		username.setText(user.getName());
		username.setBounds(123, 21, 118, 40);
		userPanel.add(username);
		
		JButton btnChangePin = new JButton("Change Pin");
		btnChangePin.setFont(new Font("Droid Sans", Font.BOLD, 13));
		btnChangePin.setBorder(null);
		btnChangePin.setForeground(Color.WHITE);
		btnChangePin.setBackground(Color.GRAY);
		btnChangePin.setBounds(123, 63, 138, 25);
		userPanel.add(btnChangePin);
		
		JButton btnChangeProfilePic = new JButton("Change Profile Pic");
		btnChangeProfilePic.setFont(new Font("Droid Sans", Font.BOLD, 13));
		btnChangeProfilePic.setBorder(null);
		btnChangeProfilePic.setForeground(Color.WHITE);
		btnChangeProfilePic.setBackground(Color.GRAY);
		btnChangeProfilePic.setBounds(123, 100, 138, 25);
		userPanel.add(btnChangeProfilePic);
		
		JPanel accPanel = new JPanel();
		accPanel.setBorder(null);
		accPanel.setBackground(Color.DARK_GRAY);
		accPanel.setBounds(10, 371, 478, 218);
		mainPanel.add(accPanel);
		accPanel.setLayout(null);
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Dialog", Font.BOLD, 26));
		lblUsers.setBackground(Color.DARK_GRAY);
		lblUsers.setBounds(0, 0, 110, 34);
		accPanel.add(lblUsers);
		
		JPanel exPanel = new JPanel();
		exPanel.setBorder(null);
		exPanel.setBackground(Color.DARK_GRAY);
		exPanel.setBounds(10, 45, 458, 122);
		accPanel.add(exPanel);
		exPanel.setLayout(null);
		
		JLabel exIcon = new JLabel("New label");
		exIcon.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/giraffe_blue.png")));
		exIcon.setBorder(null);
		exIcon.setBounds(10, 11, 93, 93);
		exPanel.add(exIcon);
		
		JLabel lblTempUser = new JLabel("Temp User");
		lblTempUser.setBackground(Color.DARK_GRAY);
		lblTempUser.setForeground(Color.WHITE);
		lblTempUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTempUser.setBounds(114, 11, 121, 32);
		exPanel.add(lblTempUser);
		
		JButton button = new JButton("Change Pin");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 13));
		button.setBorder(null);
		button.setBackground(Color.GRAY);
		button.setBounds(113, 46, 138, 25);
		exPanel.add(button);
		
		JButton button_1 = new JButton("Change Profile Pic");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 13));
		button_1.setBorder(null);
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(113, 79, 138, 25);
		exPanel.add(button_1);
		
		JButton btnManageRestrictions = new JButton("Manage Restrictions");
		btnManageRestrictions.setFont(new Font("Dialog", Font.BOLD, 13));
		btnManageRestrictions.setForeground(Color.WHITE);
		btnManageRestrictions.setBorder(null);
		btnManageRestrictions.setBackground(Color.GRAY);
		btnManageRestrictions.setBounds(261, 46, 138, 25);
		exPanel.add(btnManageRestrictions);
		
		JPanel servPanel = new JPanel();
		servPanel.setBackground(Color.DARK_GRAY);
		servPanel.setBounds(10, 227, 478, 133);
		mainPanel.add(servPanel);
		servPanel.setLayout(null);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setFont(new Font("Dialog", Font.BOLD, 26));
		lblServer.setForeground(Color.WHITE);
		lblServer.setBackground(Color.DARK_GRAY);
		lblServer.setBounds(0, 0, 115, 39);
		servPanel.add(lblServer);
		
		servURL = new JTextField();
		servURL.setBounds(22, 52, 205, 28);
		servPanel.add(servURL);
		servURL.setColumns(10);
		
		JButton btnChangeServerUrl = new JButton("Change Server URL");
		btnChangeServerUrl.setForeground(Color.WHITE);
		btnChangeServerUrl.setFont(new Font("Dialog", Font.BOLD, 13));
		btnChangeServerUrl.setBorder(null);
		btnChangeServerUrl.setBackground(Color.GRAY);
		btnChangeServerUrl.setBounds(243, 53, 138, 25);
		servPanel.add(btnChangeServerUrl);
		
		JButton btnManageRestrictionLevels = new JButton("Manage Restriction Levels");
		btnManageRestrictionLevels.setForeground(Color.WHITE);
		btnManageRestrictionLevels.setFont(new Font("Dialog", Font.BOLD, 13));
		btnManageRestrictionLevels.setBorder(null);
		btnManageRestrictionLevels.setBackground(Color.GRAY);
		btnManageRestrictionLevels.setBounds(22, 99, 205, 25);
		servPanel.add(btnManageRestrictionLevels);
		
		return mainPanel;
	}
}
