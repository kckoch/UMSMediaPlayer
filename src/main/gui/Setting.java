package main.gui;

import java.awt.*;

import javax.swing.ImageIcon;

public class Setting {
	private int PIN;
	private ImageIcon profilePic; 
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
	
	public void setIcon(ImageIcon icon) {
		this.profilePic = icon;
	}
	
	public ImageIcon getIcon() {
		return profilePic;
	}
}
