package gui;

import java.awt.*;
import javax.swing.*;

public class LoginGUI {
	private static JFrame frame;
	
	public static JFrame init() {
		frame = new JFrame("Login");
    	frame.setSize(500, 600);
    	frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel logo = new JPanel(new GridBagLayout());
		logo.setSize(500, 300);
		logo.setBackground(Color.DARK_GRAY);
		JLabel thatsmyjam = new JLabel("That's my jam!");
		thatsmyjam.setMinimumSize(new Dimension(500, 300));
		thatsmyjam.setForeground(Color.WHITE);
		logo.add(thatsmyjam);
		
		JPanel accounts = listAccounts();
		
		final JPanel windowPane = new JPanel(new BorderLayout());
		
		windowPane.add(logo);
		windowPane.add(accounts);
		
		frame.setBackground(Color.DARK_GRAY);
		
		frame.setContentPane(windowPane);
		return frame;
	}
	
	private static JPanel listAccounts() {
		JPanel acc = new JPanel();
		acc.setSize(500, 300);
		acc.setBackground(Color.DARK_GRAY);
		return acc;
	}
}
