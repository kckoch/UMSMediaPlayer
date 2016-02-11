package main.gui;

import java.awt.*;
import java.awt.event.*;
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
		
		//Gets the window set up
		final JPanel windowPane = new JPanel();
		windowPane.setBackground(Color.DARK_GRAY);
		windowPane.add(BorderLayout.PAGE_START, logo);
		logo.setLayout(null);
		
		JLabel logoLabel = new JLabel("That's my jam!");
		logoLabel.setMaximumSize(new Dimension(500, 300));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setFont(new Font("Lobster Two", Font.ITALIC, 69));
		logoLabel.setBorder(new EmptyBorder(50, 0, 50, 0));
		logoLabel.setBounds(51, 12, 406, 159);
		logo.add(logoLabel);
		windowPane.setLayout(null);
		windowPane.add(middle);
		
		//The admin user panel
		JPanel admin = new JPanel();
		admin.setBackground(Color.DARK_GRAY);
		admin.setBounds(22, 0, 117, 163);
		middle.add(admin);
		admin.setLayout(null);
		
		//The name
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setBounds(35, 117, 49, 15);
		admin.add(lblAdmin);
		
		//The icon/button
		final JButton adminPic = new JButton("");
		adminPic.setBackground(Color.DARK_GRAY);
		adminPic.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/person-icon.png")));
		adminPic.setBounds(12, 12, 93, 93);
		adminPic.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				adminPic.setBackground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		admin.add(adminPic);
		
		//The add account panel
		JPanel addAcc = new JPanel();
		addAcc.setBackground(Color.DARK_GRAY);
		addAcc.setBounds(151, 0, 117, 163);
		middle.add(addAcc);
		addAcc.setLayout(null);
		
		//The add account label
		JLabel lblAddAccount = new JLabel("Add Account");
		lblAddAccount.setForeground(Color.WHITE);
		lblAddAccount.setBounds(12, 117, 93, 15);
		addAcc.add(lblAddAccount);
		
		//The icon/button
		JButton addAccIcon = new JButton("");
		addAccIcon.setBackground(Color.DARK_GRAY);
		addAccIcon.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/person-icon.png")));
		addAccIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		addAccIcon.setBounds(12, 12, 93, 93);
		addAcc.add(addAccIcon);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		
		JLabel copyright = new JLabel("© Team 14");
		copyright.setForeground(Color.WHITE);
		copyright.setBounds(204, 547, 86, 15);
		windowPane.add(copyright);
		return frame;
	}
}
