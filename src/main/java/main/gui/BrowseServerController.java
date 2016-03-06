package main.gui;

import java.util.*;

public class BrowseServerController {
	private static ArrayList<Container> list;
	private static User user;
	private static int previousid;
	private static String previousname;
	
	public BrowseServerController(ArrayList<Container> listin, User userin) {
		list = listin;
		user = userin;
		previousid = 0;
	}
	
	public void setList(ArrayList<Container> listin) {
		list = listin;
	}
	
	public ArrayList<Container> getList() {
		return list;
	}
	
	public ArrayList<Container> getNewContainer(String name) {
		final String fav = "Add Album to Favorites";
		String id = "";
		if(name.compareTo(fav) == 0) {
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
