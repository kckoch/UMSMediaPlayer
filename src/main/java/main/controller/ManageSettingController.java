package main.controller;

import java.util.ArrayList;

import main.model.Setting;
import main.model.User;

public class ManageSettingController {
	private Setting settings;
	
	public ManageSettingController(Setting _settings)
	{
		this.settings = _settings;
	}
	
	public int getconfigureN()
	{
		return settings.getconfigureN();
	}

	public void setconfigureN(int configureN) {
		settings.setconfigureN(configureN);
	}

	public String getserverURL() {
		return settings.getserverURL();
	}
	
	public void setserverURL(String serverURL)
	{
		settings.setserverURL(serverURL);
	}
	
	public void addUser(User newUser)
	{
		settings.addUser(newUser);
	}
	
	public User getUser(int n)
	{
		return settings.getUser(n);
	}
	
	public ArrayList<User> getUsers()
	{
		return settings.getUsers();
	}
	
	public void loadXML(String path)
	{
		settings.loadXML(path);
	}
	
	public void saveXML(String path)
	{
		settings.saveXML(path);
	}
	
}
