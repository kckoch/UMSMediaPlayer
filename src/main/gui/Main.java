package main.gui;

import java.util.*;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	private static ArrayList<User> users;
	
	public static void main(String[] args) {
		users = new ArrayList<User>();
		users.add(new User("Admin", true, 1234));
		boolean logged = false;
		while(true) {
			login = LoginGUI.init(users);
			login.setVisible(true);
			while(!logged) {
				for(int i = 0; i< users.size(); i++){
					if(users.get(i).getCorrect())
						logged = true;
				}
				System.out.print("");
			}
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getCorrect()) {
					user = users.get(i);
				}
			}
			login.setVisible(false);
			login.dispose();
			
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
