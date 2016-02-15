package main.gui;

import java.awt.*;

public class Setting {
	private int PIN;
	private int profilePicID; 
	private int configureN; //only admin can modify
	private String serverURL; //only admin can modify
	
	public Setting(int pin) {
		PIN = pin;
	}
	
	public boolean checkpin(int pin) {
		if(PIN == pin)
			return true;
		else
			return false;
	}
}
