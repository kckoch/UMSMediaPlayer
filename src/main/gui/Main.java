package main.gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	
	public static void main(String[] args) {
		user = new User("Admin", true, 1234);
		while(true) {

			System.out.println("\nMaking login screen!");
			/*login = LoginGUI.init(user);
			login.setVisible(true);
			while(user == null) {
				System.out.print("");
			}
			login.setVisible(false);
			login.dispose();*/
			user.setLoggedin(true);
			
			mainframe = MainFrame.init(user);
			mainframe.setVisible(true);
			while(user.getLoggedin()) {
				System.out.print("");
			}
			
			mainframe.setVisible(false);
			mainframe.dispose();
		}
	}

}
