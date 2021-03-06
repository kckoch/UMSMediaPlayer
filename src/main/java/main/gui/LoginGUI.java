package main.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import main.controller.AuthenticateUserController;
import main.model.User;

public class LoginGUI {
	private static JFrame frame;
	private static JPanel windowPane;
	private static JPanel pinpanel;
	private static User tempUser;
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
	private static final JButton bback = new JButton("");
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame init(final ArrayList<User> users) {
		
		frame = new JFrame("Login");
    	frame.setSize(500, 600);
    	frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		middle.setBounds(0, 184, 498, 307);
		middle.setBackground(Color.DARK_GRAY);
		
		//The logo label
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/logo.png")));
		logoLabel.setMaximumSize(new Dimension(500, 300));
		logoLabel.setBorder(null);
		logoLabel.setBounds(10, 12, 447, 159);
		logo.add(logoLabel);
		windowPane.setLayout(null);
		windowPane.add(middle);
		middle.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		for(int i = 0; i < users.size(); i++) {
			middle.add(userPanel(users.get(i)));
		}
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		
		//Copyright
		String copy = "\u00A9 Team 14";
		JLabel copyright = new JLabel();
		copyright.setText(copy);
		copyright.setBackground(Color.DARK_GRAY);
		copyright.setOpaque(true);
		copyright.setForeground(Color.WHITE);
		copyright.setBounds(204, 547, 86, 15);
		windowPane.add(copyright);
		
		//login button
		
		JButton loginbutton = new JButton("Login!");
		loginbutton.setBounds(134, 502, 192, 34);
		windowPane.add(loginbutton);
		loginbutton.setBorder(null);
		loginbutton.setBackground(new Color(99, 99, 99));
		loginbutton.setForeground(Color.WHITE);
		loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				if(pinpanel == null)
					pinpanel = pinpanel();
				frame.setContentPane(pinpanel);
			}
		});
		
		return frame;
	}
	
	private static JPanel userPanel(final User user) {
		//The user panel
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(115, 140));
		panel.setMinimumSize(new Dimension(100, 150));
		panel.setMaximumSize(new Dimension(100, 150));
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		//The name
		JLabel lbl = new JLabel(user.getName());
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(35, 117, 49, 15);
		panel.add(lbl);
		
		//The icon/button
		final JButton pic = new JButton();
		pic.setBorder(null);
		pic.setBackground(Color.DARK_GRAY);
		pic.setIcon(new ImageIcon(LoginGUI.class.getResource(user.getIcon())));
		pic.setBounds(12, 12, 93, 93);
		pic.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				pic.setBackground(Color.WHITE);
				tempUser = user;
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
		panel.add(pic);
		return panel;
	}
	
	private static JPanel pinpanel() {
		//The new panel
		JPanel panel = new JPanel();
		panel.setSize(500, 600);
		panel.setBackground(Color.DARK_GRAY);
		
		panel.setLayout(null);
		
		//back button
		JButton backbutton = new JButton();
		backbutton.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
	    		frame.setContentPane(windowPane);
	    		numberString = "";
	    		passwordField.setText("");
		    }
		});
		backbutton.setBorder(null);
		backbutton.setBackground(Color.DARK_GRAY);
		backbutton.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/left_round.png")));
		backbutton.setBounds(35, 76, 75, 67);
		panel.add(backbutton);
		
		//password field
		passwordField = new JPasswordField();
		passwordField.setBorder(new EmptyBorder(10, 0, 0, 0));
		passwordField.setActionCommand("");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 40));
		passwordField.setEchoChar('*');
		passwordField.setBounds(152, 156, 176, 39);
		panel.add(passwordField);
		
		//person icon
		JButton icon = new JButton();
		icon.setBorder(null);
		icon.setBackground(Color.DARK_GRAY);
		icon.setIcon(new ImageIcon(LoginGUI.class.getResource(tempUser.getIcon())));
		icon.setBounds(176, 19, 129, 124);
		panel.add(icon);
		
		//num pad buttons
		b1.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "1";
	            passwordField.setText(numberString);
		    }
	    });
		b1.setBackground(new Color(99, 99, 99));
		b1.setForeground(Color.WHITE);
		b1.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		b2.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "2";
	            passwordField.setText(numberString);
		    }
	    });
		b2.setBackground(new Color(99, 99, 99));
		b2.setForeground(Color.WHITE);
		b2.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b3.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "3";
	            passwordField.setText(numberString);
		    }
	    });
		b3.setBackground(new Color(99, 99, 99));
		b3.setForeground(Color.WHITE);
		b3.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b4.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "4";
	            passwordField.setText(numberString);
		    }
	    });
		b4.setBackground(new Color(99, 99, 99));
		b4.setForeground(Color.WHITE);
		b4.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b5.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "5";
	            passwordField.setText(numberString);
		    }
	    });
		b5.setBackground(new Color(99, 99, 99));
		b5.setForeground(Color.WHITE);
		b5.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b6.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "6";
	            passwordField.setText(numberString);
		    }
	    });
		b6.setBackground(new Color(99, 99, 99));
		b6.setForeground(Color.WHITE);
		b6.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b7.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "7";
	            passwordField.setText(numberString);
		    }
	    });
		b7.setBackground(new Color(99, 99, 99));
		b7.setForeground(Color.WHITE);
		b7.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b8.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "8";
	            passwordField.setText(numberString);
		    }
	    });
		b8.setBackground(new Color(99, 99, 99));
		b8.setForeground(Color.WHITE);
		b8.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b9.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "9";
	            passwordField.setText(numberString);
		    }
	    });
		b9.setBackground(new Color(99, 99, 99));
		b9.setForeground(Color.WHITE);
		b9.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		b0.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "0";
	            passwordField.setText(numberString);
		    }
	    });
		b0.setBackground(new Color(99, 99, 99));
		b0.setForeground(Color.WHITE);
		b0.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		ba.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		numberString += "*";
	            passwordField.setText(numberString);
		    }
	    });
		ba.setBackground(new Color(99, 99, 99));
		ba.setForeground(Color.WHITE);
		ba.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		bback.addActionListener(new ActionListener(){
	    	@Override
		    public void actionPerformed(ActionEvent e) {
	    		if(numberString != "") {
	    			numberString = numberString.substring(0, numberString.length()-1);
	    			passwordField.setText(numberString);
	    		}
		    }
	    });
		bback.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/back_button_3.png")));
		bback.setBackground(new Color(99, 99, 99));
		bback.setForeground(Color.WHITE);
		bback.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		
		//actual num pad
		JPanel numPad = new JPanel();
		numPad.setBackground(Color.DARK_GRAY);
		numPad.setBorder(new EmptyBorder(15, 15, 15, 15));
		numPad.setBounds(127, 219, 231, 262);
		panel.add(numPad);
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
		numPad.add(bback);
		
		//login button
		JButton Login = new JButton("Login");
		Login.setForeground(Color.WHITE);
		Login.setBorder(null);
		Login.setBackground(new Color(99, 99, 99));
		Login.setBounds(188, 493, 117, 25);
		Login.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				AuthenticateUserController auth = new AuthenticateUserController(tempUser);
	    		if(!auth.authenticate(new String(passwordField.getPassword()))) {
	    			passwordField.setForeground(UIManager.getColor("OptionPane.errorDialog.border.background"));
	    		}
	    		numberString = "";
	    		passwordField.setText("");
		    }
		});
		panel.add(Login);
		return panel;
	}
}