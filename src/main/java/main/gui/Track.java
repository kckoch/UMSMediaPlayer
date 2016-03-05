package main.gui;

import java.sql.Time;

public class Track {
	
	long totalTime;
	String title;
	int objectId;
	String mediaURL;
	Album album;
	String artist;
	
	public Track(long duration, String trackTitle, String trackURL, String newArtist){
		totalTime = duration;
		title = trackTitle;
		objectId = 0;
		mediaURL = trackURL;
		album = null;
		artist = newArtist;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}

}
