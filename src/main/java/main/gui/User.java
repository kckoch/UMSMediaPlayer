package main.gui;

import java.util.*;

public class User {
	//private Setting setting;
	private boolean admin;			//if admin, will be true
	private String name;
	private int PIN;
	private int filter;
	private boolean loggedin;
	private boolean correct;
	private String iconpath;
	private ArrayList<Album> favorites;
	private ArrayList<Integer> favoritesIDs;
	

	public User(String name, boolean admin, int pin, int filterValue) {
		this.name = name;
		this.admin = admin;
		PIN = pin;
		filter = filterValue; 
		loggedin = false;
		favorites = new ArrayList<Album>();
		favoritesIDs = new ArrayList<Integer>();
	}
	
	public void setLoggedin(boolean bool) {
		loggedin = bool;
	}
	
	public boolean getLoggedin() {
		return loggedin;
	}
	
	public boolean checkPassword(int password) {
		if( PIN==password)
		{
			return true;
		}
		else return false;
		//return setting.checkpin(password);
	}
	
	public boolean getCorrect() {
		return correct;
	}
	
	public void setCorrect(boolean bool) {
		correct = bool;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public int getPIN() {
		return PIN;
	}
	
	public void setPIN(int PIN) {
		this.PIN = PIN;
	}
	
	public int getFilter() {
		return filter;
	}
	
	public void setFilter(int filterValue) {
		filter = filterValue;
	}
	
	public void setIcon(String path) {
		iconpath = path;
	}
	
	public String getIcon() {
		return iconpath;
	}
	
	public List<Album> getFavorites() {
		return favorites;
	}
	
	public List<Integer> getFavoritesIDs() {
		return favoritesIDs;
	}
	
	public void addFavorite(Album album) {
		favorites.add(album);
		favoritesIDs.add(album.getObjectId());
	}
}
