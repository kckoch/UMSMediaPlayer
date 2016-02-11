package main.gui;

import java.util.*;

public class User {
	private Setting setting;
	private List<Object> favorites;
	private boolean admin;			//if admin, will be true
	private String name;
	
	public User(String name, boolean admin, int pin) {
		this.name = name;
		this.admin = admin;
		setting = new Setting(pin);
	}
}
