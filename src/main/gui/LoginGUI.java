package main.gui;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI {
	private static JFrame frame;
	private static User user;
	private static ArrayList<User> users;
	
	public static JFrame init(User userIn) {
		user = userIn;
		
		frame = new JFrame("Login");
    	frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel logo = logo();
		
		JPanel middle = new JPanel(new BorderLayout());
		middle.setBackground(Color.DARK_GRAY);
		middle.add(BorderLayout.PAGE_START, listAccounts());
		middle.add(BorderLayout.PAGE_END, loginButton());
		
		JPanel copyright = copyright();
		
		final JPanel windowPane = new JPanel(new BorderLayout());
		windowPane.setBackground(Color.DARK_GRAY);
		
		windowPane.add(BorderLayout.PAGE_START, logo);
		windowPane.add(BorderLayout.CENTER, middle);
		windowPane.add(BorderLayout.PAGE_END, copyright);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		return frame;
	}
	
	private static JPanel logo() {
		Font font = new Font("That's my jam!", Font.ITALIC, 50);
		
		JPanel logo = new JPanel(new GridBagLayout());
		logo.setSize(500, 300);
		logo.setBackground(Color.DARK_GRAY);
		JLabel thatsmyjam = new JLabel("That's my jam!");
		thatsmyjam.setMaximumSize(new Dimension(500, 300));
		thatsmyjam.setForeground(Color.WHITE);
		thatsmyjam.setFont(font);
		thatsmyjam.setBorder(new EmptyBorder(50, 0, 50, 0));
		logo.add(thatsmyjam);
		return logo;
	}
	
	private static JPanel listAccounts() {
		JPanel acc = new JPanel(new BorderLayout());
		acc.setSize(500, 200);
		acc.setBackground(Color.DARK_GRAY);
		return acc;
	}
	
	private static JPanel loginButton() {
		JPanel panel = new JPanel();
		panel.setSize(500, 150);
		panel.setBackground(Color.DARK_GRAY);
		JButton loginbutton = new JButton("Login!");
		loginbutton.setSize(new Dimension(100, 50));
		loginbutton.setBorder(new EmptyBorder(50, 200, 50, 200));
		panel.add(loginbutton);
		return panel;
	}
	
	private static JPanel copyright() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setSize(500, 50);
		JLabel label = new JLabel("\u00a9 Team 14");
		label.setForeground(Color.WHITE);
		panel.add(label);
		return panel;
	}
}
