package main.gui;

import java.awt.*;

import javax.swing.ImageIcon;

public class Setting {
	private int PIN;
	private String profilePicPath; 
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
	
	public void setIcon(String icon) {
		this.profilePicPath = icon;
	}
	
	public String getIcon() {
		return profilePicPath;
	}
}
