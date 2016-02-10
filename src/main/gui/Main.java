package main.gui;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	private static Boolean loggedout;
	
	public static void main(String[] args) {
		loggedout = false;
		while(true) {
			login = LoginGUI.init(user);
			login.setVisible(true);
			while(user == null) {
				System.out.print("");
			}
			login.setVisible(false);
			login.dispose();
			
			/*mainframe = MainFrame.init(loggedout);
			while(!loggedout.booleanValue()) {
				System.out.print("");
			}*/
		}
	}

}
