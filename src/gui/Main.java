package gui;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	private static boolean loggedout;	//This is was a variable that I used to check when the user logged out
										//Not sure what we'll do because we are separating all of the classes
										//So we need to find out if we can check when a frame is set to invisible
	
	public static void main(String[] args) {
		while(true) {
			login = LoginGUI.init();
			login.setVisible(true);
			while(user == null) {
				System.out.print("");
			}
			/*loggedout = false;
			login.setVisible(false);
			login.dispose();
			
			mainframe = MainFrame.init();*/
		}
	}

}
