package main.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginGUI {
	private static JFrame frame;
	private static JPanel pinpanel;
	private static JPanel windowPane;
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
		middle.setBounds(0, 184, 498, 357);
		middle.setBackground(Color.DARK_GRAY);
		
		//login button
		JButton loginbutton = new JButton("Login!");
		loginbutton.setLocation(151, 311);
		loginbutton.setSize(new Dimension(192, 34));
		loginbutton.setBorder(null);
		loginbutton.setBackground(new Color(99, 99, 99));
		loginbutton.setForeground(Color.WHITE);
		loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				//The new panel
				JPanel pinpanel = new JPanel();
				pinpanel.setSize(500, 600);
				pinpanel.setBackground(Color.DARK_GRAY);
				
				pinpanel.setLayout(null);
				
				//back button
				JButton backbutton = new JButton();
				backbutton.addActionListener(new ActionListener() {
					@Override
				    public void actionPerformed(ActionEvent e) {
			    		frame.setContentPane(windowPane);
			    		numberString = "";
				    }
				});
				backbutton.setBorder(null);
				backbutton.setBackground(Color.DARK_GRAY);
				backbutton.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/left_round.png")));
				backbutton.setBounds(35, 76, 75, 67);
				pinpanel.add(backbutton);
				
				//password field
				passwordField = new JPasswordField();
				passwordField.setBorder(new EmptyBorder(10, 0, 0, 0));
				passwordField.setActionCommand("");
				passwordField.setHorizontalAlignment(SwingConstants.CENTER);
				passwordField.setFont(new Font("Dialog", Font.PLAIN, 40));
				passwordField.setEchoChar('*');
				passwordField.setBounds(152, 156, 176, 39);
				pinpanel.add(passwordField);
				
				//person icon
				JButton icon = new JButton();
				icon.setBorder(null);
				icon.setBackground(Color.DARK_GRAY);
				icon.setIcon(tempUser.getSetting().getIcon());
				icon.setBounds(176, 19, 129, 124);
				pinpanel.add(icon);
				
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
				pinpanel.add(numPad);
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
			    		if(tempUser.checkPassword(Integer.parseInt(passwordField.getText()))) {
			    			tempUser.setLoggedin(true);
			    			tempUser.setCorrect(true);
			    			numberString = "";
			    			passwordField.setText(null);
			    		}
				    }
				});
				pinpanel.add(Login);
				frame.setContentPane(pinpanel);
				
			}
		});
		middle.setLayout(null);
		middle.add(loginbutton);
		
		//The logo label
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/logo.png")));
		logoLabel.setMaximumSize(new Dimension(500, 300));
		logoLabel.setBorder(null);
		logoLabel.setBounds(10, 12, 447, 159);
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
		adminPic.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/panda_orange_2.png")));
		adminPic.setBounds(12, 12, 93, 93);
		adminPic.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				adminPic.setBackground(Color.WHITE);
				tempUser = users.get(0);
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
		addAccIcon.setIcon(new ImageIcon(LoginGUI.class.getResource("/main/gui/panda_blue_2.png")));
		addAccIcon.setBounds(12, 12, 93, 93);
		addAcc.add(addAccIcon);
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setContentPane(windowPane);
		
		//Copyright
		JLabel copyright = new JLabel("© Team 14");
		copyright.setForeground(Color.WHITE);
		copyright.setBounds(204, 547, 86, 15);
		windowPane.add(copyright);
		
		return frame;
	}
}