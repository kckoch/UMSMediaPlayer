package main.gui;

import java.awt.Color;

import javax.swing.*;

public class SettingGUI {
	private static JPanel panel = new JPanel();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel init() {
		panel.setBackground(Color.DARK_GRAY);
		panel.setSize(500, 600);
		panel.setLayout(null);
		
		JButton exitButton = new JButton("");
		exitButton.setBorder(null);
		exitButton.setBackground(Color.DARK_GRAY);
		exitButton.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/x_icon.png")));
		exitButton.setBounds(405, 11, 85, 69);
		panel.add(exitButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SettingGUI.class.getResource("/main/gui/big_setting.png")));
		lblNewLabel.setRequestFocusEnabled(false);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBorder(null);
		lblNewLabel.setBounds(10, 11, 69, 69);
		panel.add(lblNewLabel);
		
		return panel;
	}
}
