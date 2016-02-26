package main.java.main.gui;

import java.sql.Time;

public class Track {
	
	long totalTime;
	String title;
	int objectId;
	String MediaURL;
	Album album;
	
	public Track(long duration, String trackTitle, String trackURL){
		totalTime = duration;
		title = trackTitle;
		objectId = 0;
		MediaURL = trackURL;
		album = null;
	}
	
	public void setAlbum(Album newAlbum){
		album = newAlbum;
	}

}
