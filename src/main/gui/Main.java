package main.gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	static List <User> users;
	
	public static void main(String[] args) {
		users = new ArrayList <User>();
		users.add(new User());
		while(true) {
			System.out.println("\nMaking login screen!");
			/*login = LoginGUI.init(user);
			login.setVisible(true);
			while(user == null) {
				System.out.print("");
			}
			login.setVisible(false);
			login.dispose();*/
			
			users.get(0).setLoggedIn(true);
			mainframe = MainFrame.init(users.get(0));
			mainframe.setVisible(true);
			while(users.get(0).getLoggedIn()) {
				System.out.println("\nIm 'in the mainframe while loop!");
			}
			mainframe.setVisible(false);
			mainframe.dispose();
		}
	}

}
