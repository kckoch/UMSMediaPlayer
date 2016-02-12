package main.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI {
	private static JFrame frame;
	private static JPanel pinFrame;
	private static JPanel windowPane;
	private static User user;
	private static User tempUser;
	private static ArrayList<User> users;
	private static JPasswordField passwordField;
	private static String numberString = "";
	private static final JButton b1 = new JButton("1");
	private static final JButton b2 = new JButton("2");
	private static final JButton b3 = new JButton("3");
	private static final JButton b4 = new JButton("4");
	private static final JButton b5 = new JButton("5");
	private static final JButton b6 = new JButton("6");
	private static final JButton b7 = new JButton("7");
	private static final JButton b8 = new JButton("8");
	private static final JButton b9 = new JButton("9");
	private static final JButton ba = new JButton("*");
	private static final JButton b0 = new JButton("0");
	private static final JButton bp = new JButton("#");
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame init(User userIn) {
		user = userIn;
		
		frame = new JFrame("Login");
    	frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		//Gets the window set up
		windowPane = new JPanel();
		windowPane.setBackground(Color.DARK_GRAY);
		
		//Logo panel
		JPanel logo = new JPanel();
		logo.setLocation(0, 0);
		logo.setSize(500, 149);
		logo.setBackground(Color.DARK_GRAY);
		logo.setLayout(null);
		windowPane.add(BorderLayout.PAGE_START, logo);
		
		//Start of the middle section
		JPanel middle = new JPanel();
		middle.setBounds(0, 184, 498, 357);
		middle.setBackground(Color.DARK_GRAY);
		
		//login button
		JButton loginbutton = new JButton("Login!");
		loginbutton.setLocation(151, 311);
		loginbutton.setSize(new Dimension(192, 34));
		loginbutton.setBorder(null);
		loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				pinFrame = pinFrame();
				frame.setContentPane(pinFrame);
			}
		});
		middle.setLayout(null);
		middle.add(loginbutton);
		
		//The logo label
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
		adminPic.setBorder(null);
		adminPic.setBackground(Color.DARK_GRAY);
		adminPic.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/person-icon.png")));
		adminPic.setBounds(12, 12, 93, 93);
		adminPic.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				adminPic.setBackground(Color.WHITE);
				tempUser = new User("Admin", true, 1234);	//WILL NEED TO FIX THIS!!!!!!
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
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
		addAccIcon.setBorder(null);
		addAccIcon.setBackground(Color.DARK_GRAY);
		addAccIcon.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/person-icon.png")));
		addAccIcon.setBounds(12, 12, 93, 93);
		addAcc.add(addAccIcon);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		
		//Copyright
		JLabel copyright = new JLabel("© Team 14");
		copyright.setForeground(Color.WHITE);
		copyright.setBounds(204, 547, 86, 15);
		windowPane.add(copyright);*/
		
		pinFrame = new JPanel();
		pinFrame.setSize(500, 600);
		pinFrame.setBackground(Color.DARK_GRAY);
		
		
		frame.setContentPane(pinFrame);
		pinFrame.setLayout(null);
		
		JButton backbutton = new JButton("Back");
		backbutton.setBorder(null);
		backbutton.setBackground(Color.DARK_GRAY);
		backbutton.setForeground(Color.DARK_GRAY);
		backbutton.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/left_round.png")));
		backbutton.setBounds(35, 76, 75, 67);
		pinFrame.add(backbutton);
		
		passwordField = new JPasswordField();
		passwordField.setActionCommand("");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 27));
		passwordField.setEchoChar('*');
		passwordField.setBounds(148, 223, 176, 39);
		pinFrame.add(passwordField);
		
		JButton icon = new JButton();
		icon.setBorder(null);
		icon.setActionCommand("");
		icon.setBackground(Color.DARK_GRAY);
		icon.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/person-icon.png")));
		icon.setBounds(172, 95, 129, 124);
		pinFrame.add(icon);
		
		b1.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "1";
	            passwordField.setText(numberString);
		    }
	    });
		b2.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "2";
	            passwordField.setText(numberString);
		    }
	    });
		b3.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "3";
	            passwordField.setText(numberString);
		    }
	    });
		b4.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "4";
	            passwordField.setText(numberString);
		    }
	    });
		b5.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "5";
	            passwordField.setText(numberString);
		    }
	    });
		b6.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "6";
	            passwordField.setText(numberString);
		    }
	    });
		b7.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "7";
	            passwordField.setText(numberString);
		    }
	    });
		b8.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "8";
	            passwordField.setText(numberString);
		    }
	    });
		b9.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "9";
	            passwordField.setText(numberString);
		    }
	    });
		b0.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "0";
	            passwordField.setText(numberString);
		    }
	    });
		ba.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "*";
	            passwordField.setText(numberString);
		    }
	    });
		bp.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "#";
	            passwordField.setText(numberString);
		    }
	    });
		
		JPanel numPad = new JPanel();
		numPad.setBounds(117, 286, 231, 262);
		pinFrame.add(numPad);
		numPad.setLayout(new GridLayout(4,3));
		
		numPad.add(b1);
		numPad.add(b2);
		numPad.add(b3);
		numPad.add(b4);
		numPad.add(b5);
		numPad.add(b6);
		numPad.add(b7);
		numPad.add(b8);
		numPad.add(b9);
		numPad.add(ba);
		numPad.add(b0);
		numPad.add(bp);
		
		return frame;
	}
	
	private static JPanel pinFrame() {
		JPanel login = new JPanel();
		login.setSize(500, 600);
		login.setBackground(Color.DARK_GRAY);
		
		
		return login;
	}
}