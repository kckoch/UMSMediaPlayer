package main.gui;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingGUI {
	private static JPanel mainPanel = new JPanel();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel init(final JPanel mainPanelIn, final JFrame frame, final User user) {
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
		exitButton.setBounds(446, 15, 30, 30);
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
		usericon.setIcon(user.getSetting().getIcon());
		
		JLabel username = new JLabel("");
		username.setFont(new Font("Droid Sans", Font.BOLD, 15));
		username.setForeground(Color.WHITE);
		username.setBackground(Color.DARK_GRAY);
		username.setText(user.getName());
		username.setBounds(123, 36, 93, 25);
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
		
		JScrollPane accPanel = new JScrollPane();
		accPanel.setOpaque(false);
		accPanel.setForeground(Color.DARK_GRAY);
		accPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		accPanel.setBorder(null);
		accPanel.setBackground(Color.DARK_GRAY);
		accPanel.setBounds(12, 232, 476, 344);
		mainPanel.add(accPanel);
		
		return mainPanel;
	}
}
