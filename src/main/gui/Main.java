package main.gui;

import java.util.*;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	private static ArrayList<User> users;
	private static ArrayList<Track> tracks;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		//initialize and declare sample tracks and albums for the admin user to use as an example
		Track sampleTrack = new Track(300, "Track 1", "Track 1 URL");
		tracks = new ArrayList<Track>();
		tracks.add(sampleTrack);
		Album album0 = new Album("Test Album 0", tracks, "Test Album 0 URL");
		Album album1 = new Album("Test Album 1", tracks, "Test Album 1 URL");
		album1.setObjectId(1);
		Album album2 = new Album("Test Album 2", tracks, "Test Album 2 URL");
		album2.setObjectId(2);
		Album album3 = new Album("Test Album 3", tracks, "Test Album 3 URL");
		album3.setObjectId(3);
		Album album4 = new Album("Test Album 4", tracks, "Test Album 4 URL");
		album4.setObjectId(4);
		Album album5 = new Album("Test Album 5", tracks, "Test Album 5 URL");
		album5.setObjectId(5);
		Album album6 = new Album("Test Album 6", tracks, "Test Album 6 URL");
		album6.setObjectId(6);
		Album album7 = new Album("Test Album 7", tracks, "Test Album 7 URL");
		album7.setObjectId(7);
		Album album8 = new Album("Test Album 8", tracks, "Test Album 8 URL");
		album8.setObjectId(8);
		Album album9 = new Album("Test Album 9", tracks, "Test Album 9 URL");
		album9.setObjectId(9);
		//initialize admin account info and list of albums
		users = new ArrayList<User>();
		users.add(new User("Admin", true, 1234));
		users.get(0).addFavorites(album0);
		users.get(0).addFavorites(album1);
		users.get(0).addFavorites(album2);
		users.get(0).addFavorites(album3);
		users.get(0).addFavorites(album4);
		users.get(0).addFavorites(album5);
		users.get(0).addFavorites(album6);
		users.get(0).addFavorites(album7);
		users.get(0).addFavorites(album8);
		users.get(0).addFavorites(album9);
		users.get(0).getSetting().setIcon("/main/gui/panda_orange_2.png");
		boolean logged = false;
		while(true) {//loop forever
			login = LoginGUI.init(users);//login screen
			login.setVisible(true);
			while(!logged) {
				for(int i = 0; i< users.size(); i++){//determines if entered pin is correct for chosen profile
					if(users.get(i).getCorrect()) {
						user = users.get(i);
						logged = true;
					}
				}
				System.out.print("");
			}
			logged = false;
			user.setCorrect(false);
			login.setVisible(false);
			login.dispose();
			
			mainframe = MainFrame.init(user);//displays the main screen
			mainframe.setVisible(true);
			while(user.getLoggedin()) {//loops until user logs out
				System.out.print("");
			}
			mainframe.setVisible(false);
			mainframe.dispose();
			//returns to login screen
		}
	}

}
