package main.controller;

import main.model.User;

//Authenticate User checks the pin number provided after the user selects a profile
public class AuthenticateUserController {
	
	private User testUser;
	
	public AuthenticateUserController(User user) {
		this.testUser = user;
	}

	public void setUser(User user) {
		this.testUser = user;
	}
	
	//checks the pin number against the one stored
	public boolean authenticate(String str) {
		int pin = Integer.parseInt(str);
		if(testUser.checkPassword(pin)) {
			testUser.setLoggedin(true);
			testUser.setCorrect(true);
			return true;
		} else {
			return false;
		}
	}
}
