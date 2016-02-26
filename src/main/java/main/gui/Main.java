package main.gui;

import java.util.*;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static User user;
	private static ArrayList<User> users;
	private static ArrayList<Track> tracksA;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		//initialize and declare sample tracks and albums for the admin user to use as an example
		
		Track track0 = new Track(30, "Allegro ma non troppo", System.getProperty("user.dir") + "/audio/Album A/Track 1.mp3");
		tracksA = new ArrayList<Track>();
		tracksA.add(track0);
		Album albumA = new Album("Album A", tracksA, System.getProperty("user.dir") + "audio/Album A");
		albumA.setObjectId(1);
		//initialize admin account info and list of albums
		users = new ArrayList<User>();

		users.add(new User("Admin", true, 1234, 0));
		users.get(0).addFavorites(albumA);
		users.get(0).setIcon("/main/gui/panda_orange_2.png");

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
