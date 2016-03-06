/*
 * A controller for browsing the server.  This class interacts with SOAP, and is called by MainFrame.
 */
package main.controller;

import java.util.*;

import main.model.Album;
import main.model.Container;
import main.model.SOAP;
import main.model.Track;
import main.model.User;

public class BrowseServerController {
	private static ArrayList<Container> list;
	private static User user;
	private static int previousid;
	private static String previousname;
	
	/*
	 * Contructor for the controller. Called only once!
	 * Internal ArrayList shows current container.  User will never change until he/she logs out
	 */
	public BrowseServerController(ArrayList<Container> listin, User userin) {
		list = listin;
		user = userin;
		previousid = 0;
	}
	
	/*
	 * Sets the internal ArrayList to a new passed in list
	 */
	public void setList(ArrayList<Container> listin) {
		list = listin;
	}
	
	/*
	 * Returns current ArrayList
	 */
	public ArrayList<Container> getList() {
		return list;
	}
	
	/*
	 * This is how you traverse containers.  Keeps track of old Container, and updates internal
	 * list with a new ArrayList.
	 */
	public ArrayList<Container> getNewContainer(String name) {
		final String fav = "Add Album to Favorites";
		String id = "";
		if(name.compareTo(fav) == 0) {
			System.out.println("in fav");
			ArrayList<Track> tracks = new ArrayList<Track>();
			for(int i = 0; i < list.size(); i++) {
				tracks.add(new Track(list.get(i).getDuration(), list.get(i).getName(), list.get(i).getUrl(), ""));
			}
			Album album = new Album("Album x", tracks, "");
		}
		for(int p = 0; p < list.size(); p++){
			if(list.get(p).getName().compareTo(name) == 0) {
				id = Integer.toString(list.get(p).getId());
				p = list.size();
			}
		}
		try {
			SOAP.sendRequest(id);
		} catch (Exception x) {
			//
		}
		list = SOAP.getList();
		list.add(0, new Container(previousid, 0, 0, "", "Back"));
		previousid = Integer.parseInt(id);
		previousname = name;
		
		/*
		if(list.get(1).getUrl().compareTo("") != 0) {
			list.add(new Container(Integer.parseInt(id), previousid, 0, "", fav));
		}*/
		
		for(int j = 0; j < SOAP.getList().size(); j++) {
			System.out.println(SOAP.getList().get(j).getId() + "\t" + SOAP.getList().get(j).getName());
			System.out.flush();
		}
		
		return list;
	}
}
