package main.gui;

public class AuthenticateUserController {
	
	private User testUser;
	
	public AuthenticateUserController(User user) {
		this.testUser = user;
	}

	public void setUser(User user) {
		this.testUser = user;
	}
	
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
