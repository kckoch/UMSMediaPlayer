package gui;

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
		JPanel accounts = listAccounts();
		JPanel loginbutton = loginButton();
		
		final JPanel windowPane = new JPanel(new BorderLayout());
		
		windowPane.add(logo);
		windowPane.add(accounts);
		windowPane.add(BorderLayout.SOUTH, loginbutton);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		return frame;
	}
	
	private static JPanel logo() {
		Font font = new Font("That's my jam!", Font.ITALIC, 50);
		
		JPanel logo = new JPanel(new GridBagLayout());
		logo.setSize(500, 200);
		logo.setBackground(Color.DARK_GRAY);
		JLabel thatsmyjam = new JLabel("That's my jam!");
		thatsmyjam.setMinimumSize(new Dimension(500, 300));
		thatsmyjam.setForeground(Color.WHITE);
		thatsmyjam.setFont(font);
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
		loginbutton.setMaximumSize(new Dimension(50, 25));
		loginbutton.setBorder(new EmptyBorder(50, 225, 50, 225));
		panel.add(loginbutton);
		return panel;
	}
}
