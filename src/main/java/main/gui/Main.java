package main.gui;

import java.util.*;

import javax.swing.*;

public class Main {
	private static JFrame login;
	private static JFrame mainframe;
	private static Setting settings;
	private static User user;
	//private static ArrayList<User> users;
	private static ArrayList<Track> tracksA;
	private static ArrayList<Track> tracksB;
	private static ArrayList<Track> tracksC;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		settings = new Setting(3, null);
		settings.loadXML("saveData.xml");
		//initialize and declare sample tracks and albums for the admin user to use as an example
		
		Track track0 = new Track(30, "Allegro ma non troppo", System.getProperty("user.dir") + "/audio/Album A/Track 1.mp3", "European Archive");
		Track track1 = new Track(30, "Larghetto", System.getProperty("user.dir") + "/audio/Album A/Track 2.mp3", "European Archive");
		Track track2 = new Track(31, "Rondo (Allegro)", System.getProperty("user.dir") + "/audio/Album A/Track 3.mp3", "European Archive");
		Track track3 = new Track(9, "Movement 1", System.getProperty("user.dir") + "/audio/Album B/mendelssohn1.mp3", "Claremont Trio");
		Track track4 = new Track(13, "Movement 2", System.getProperty("user.dir") + "/audio/Album B/mendelssohn2.mp3", "Claremont Trio");
		Track track5 = new Track(10, "Movement 3", System.getProperty("user.dir") + "/audio/Album B/mendelssohn3.mp3", "Claremont Trio");
		Track track6 = new Track(14, "Sample Track", System.getProperty("user.dir") + "/audio/Album C/octet.mp3", "Musicians from Marlboro");
		tracksA = new ArrayList<Track>();
		tracksA.add(track0);
		tracksA.add(track1);
		tracksA.add(track2);
		tracksB = new ArrayList<Track>();
		tracksB.add(track3);
		tracksB.add(track4);
		tracksB.add(track5);
		tracksC = new ArrayList<Track>();
		tracksC.add(track6);
		Album albumA = new Album("Album A", tracksA, System.getProperty("user.dir") + "audio/Album A");
		albumA.setObjectId(1);
		Album albumB = new Album("Album B", tracksB, System.getProperty("user.dir") + "audio/Album B");
		albumB.setObjectId(2);
		Album albumC = new Album("Album C", tracksC, System.getProperty("user.dir") + "audio/Album C");
		albumB.setObjectId(3);
		//initialize admin account info and list of albums
		//users = new ArrayList<User>();
/*
		settings.addUser(new User("Admin", true, 9999, 0));
		settings.getUser(0).setIcon("/main/gui/panda_orange_2.png");
		
		settings.addUser(new User("Child 1", false, 1111, 1));
		settings.getUser(1).addFavorite(albumA);
		settings.getUser(1).setIcon("/main/gui/giraffe_green.png");
		
		settings.addUser(new User("Child 2", false, 2222, 3));
		settings.getUser(2).addFavorite(albumA);
		settings.getUser(2).addFavorite(albumB);
		settings.getUser(2).setIcon("/main/gui/smile_blue.png");
		
		settings.saveXML("saveData.xml");
*/
		boolean logged = false;
		while(true) {//loop forever
			login = LoginGUI.init(settings.getUsers());//login screen
			login.setVisible(true);
			while(!logged) {
				for(int i = 0; i< settings.getUsers().size(); i++){//determines if entered pin is correct for chosen profile
					if(settings.getUser(i).getCorrect()) {
						user = settings.getUser(i);
						logged = true;
					}
				}
				System.out.print("");
			}
			logged = false;
			user.setCorrect(false);
			login.setVisible(false);
			login.dispose();
			
			mainframe = MainFrame.init(user, settings.getUsers(), settings);//displays the main screen
			mainframe.setVisible(true);
			while(user.getLoggedin()) {//loops until user logs out
				System.out.print("");
			}
			mainframe.setVisible(false);
			mainframe.dispose();
			settings.saveXML("saveData.xml");
			//returns to login screen
		}
	}
		
}
