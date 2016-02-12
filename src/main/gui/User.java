package main.gui;

public class User {
	
	boolean loggedIn;
	
	public User(){
		loggedIn = false;
	}
	
	public boolean getLoggedIn(){
		return loggedIn;
	}
	
	public void setLoggedIn(boolean newValue){
		loggedIn = newValue;
	}
	
}
