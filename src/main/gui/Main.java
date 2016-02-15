package main.gui;

import java.util.*;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	private static ArrayList<User> users;
	private static ArrayList<Track> tracks;
	
	public static void main(String[] args) {
		Track sampleTrack = new Track(300, "Track 1", "Track 1 URL");
		tracks = new ArrayList<Track>();
		tracks.add(sampleTrack);
		Album album = new Album("Test Album", tracks, "Test Album URL");
		users = new ArrayList<User>();
		users.add(new User("Admin", true, 1234));
		users.get(0).addFavorites(album);
		users.get(0).getSetting().setIcon(new ImageIcon(Main.class.getResource("/main/gui/panda_orange_2.png")));
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
			logged = false;
			user.setCorrect(false);
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
