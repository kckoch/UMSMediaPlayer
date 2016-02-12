package main.gui;

import java.util.*;

public class User {
	private Setting setting;
	private List<Object> favorites;
	private boolean admin;			//if admin, will be true
	private String name;
	private boolean loggedin;
	

	public User(String name, boolean admin, int pin) {
		this.name = name;
		this.admin = admin;
		setting = new Setting(pin);
		loggedin = false;
	}
	
	public void setLoggedin(boolean bool) {
		loggedin = bool;
	}
	
	public boolean getLoggedin() {
		return loggedin;
	}
}
