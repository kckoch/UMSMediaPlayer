package main.gui;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	
	public static void main(String[] args) {
		while(true) {
			login = LoginGUI.init(user);
			login.setVisible(true);
			while(user == null) {
				System.out.print("");
			}
			login.setVisible(false);
			login.dispose();
			
			/*
			mainframe = MainFrame.init();
			mainframe.setVisible(true);
			while(user.getLoggedin()) {
				System.out.print("");
			}*/
		}
	}

}
