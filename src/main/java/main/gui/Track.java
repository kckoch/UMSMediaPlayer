package main.gui;

import java.sql.Time;

public class Track {
	
	long totalTime;
	String title;
	int objectId;
	String MediaURL;
	Album album;
	String artist;
	
	public Track(long duration, String trackTitle, String trackURL, String newArtist){
		totalTime = duration;
		title = trackTitle;
		objectId = 0;
		MediaURL = trackURL;
		album = null;
		artist = newArtist;
	}
	
	public void setAlbum(Album newAlbum){
		album = newAlbum;
	}

}
