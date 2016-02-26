package main.java.main.gui;

import java.util.*;

public class User {
	//private Setting setting;
	private boolean admin;			//if admin, will be true
	private String name;
	private int PIN;
	private int filterN;
	private boolean loggedin;
	private boolean correct;
	private String iconpath;
	private ArrayList<Album> favorites;
	

	public User(String name, boolean admin, int pin, int filterValue) {
		this.name = name;
		this.admin = admin;
		PIN = pin;
		filterN = filterValue; 
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
	
	public void setFilterN(int filterValue){
		filterN = filterValue;
	}
	
	public List<Album> getFavorites(){
		return favorites;
	}
	
	public void addFavorites(Album album){
		favorites.add(album);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public int getFilterN(){
		return filterN;
	}
	
	public void setIcon(String path) {
		iconpath = path;
	}
	
	public String getIcon() {
		return iconpath;
	}
}
