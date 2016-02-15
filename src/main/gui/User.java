package main.gui;

import java.util.*;

public class User {
	private Setting setting;
	private boolean admin;			//if admin, will be true
	private String name;
	private boolean loggedin;
	private boolean correct;
	private ArrayList<Album> favorites;
	

	public User(String name, boolean admin, int pin) {
		this.name = name;
		this.admin = admin;
		setting = new Setting(pin);
		loggedin = false;
		favorites = new ArrayList<Album>();
	}
	
	public void setLoggedin(boolean bool) {
		loggedin = bool;
	}
	
	public boolean getLoggedin() {
		return loggedin;
	}
	
	public boolean checkPassword(int password) {
		System.out.println("In check password");
		return setting.checkpin(password);
	}
	
	public boolean getCorrect() {
		return correct;
	}
	
	public void setCorrect(boolean bool) {
		correct = bool;
	}
	
	public List<Album> getFavorites(){
		return favorites;
	}
	
	public void addFavorites(Album album){
		favorites.add(album);
	}
	
	public Setting getSetting() {
		return setting;
	}
	
}
