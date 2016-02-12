package main.gui;

import java.awt.*;

public class Setting {
	private int pin;
	private Image image;
	
	public Setting(int pin) {
		this.pin = pin;
	}
	
	public boolean checkpin(int pin) {
		if(this.pin == pin)
			return true;
		else
			return false;
	}
}
