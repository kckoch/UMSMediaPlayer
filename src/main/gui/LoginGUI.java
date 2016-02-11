package main.gui;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI {
	private static JFrame frame;
	private static User user;
	private static ArrayList<User> users;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame init(User userIn) {
		user = userIn;
		
		frame = new JFrame("Login");
    	frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Logo panel
		Font font = new Font("That's my jam!", Font.ITALIC, 50);
		JPanel logo = new JPanel();
		logo.setLocation(0, 0);
		logo.setSize(500, 149);
		logo.setBackground(Color.DARK_GRAY);
		
		JPanel middle = new JPanel();
		middle.setBounds(0, 184, 498, 357);
		middle.setBackground(Color.DARK_GRAY);
		
		//login button
		JButton loginbutton = new JButton("Login!");
		loginbutton.setLocation(151, 311);
		loginbutton.setSize(new Dimension(192, 34));
		loginbutton.setBorder(null);
		middle.setLayout(null);
		middle.add(loginbutton);
		
		final JPanel windowPane = new JPanel();
		windowPane.setBackground(Color.DARK_GRAY);
		
		windowPane.add(BorderLayout.PAGE_START, logo);
		logo.setLayout(null);
		
		JLabel label_1 = new JLabel("That's my jam!");
		label_1.setMaximumSize(new Dimension(500, 300));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lobster Two", Font.ITALIC, 69));
		label_1.setBorder(new EmptyBorder(50, 0, 50, 0));
		label_1.setBounds(51, 12, 406, 159);
		logo.add(label_1);
		windowPane.setLayout(null);
		windowPane.add(middle);
		
		JPanel admin = new JPanel();
		admin.setBackground(Color.DARK_GRAY);
		admin.setBounds(0, 0, 131, 163);
		middle.add(admin);
		admin.setBorder(null);
		admin.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 107, 93);
		admin.add(panel);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		
		JLabel label = new JLabel("© Team 14");
		label.setForeground(Color.WHITE);
		label.setBounds(204, 547, 86, 15);
		windowPane.add(label);
		return frame;
	}
}
