package main.gui;

import java.util.ArrayList;
import java.util.List;

public class Album {

	String name;
	ArrayList<Track> tracks;
	String mediaURL;
	int objectId;
	private static String AlbumArt;
	
	public Album (String newName, ArrayList<Track> songs, String albumURL){
		name = newName;
		tracks = new ArrayList<Track>();
		tracks.addAll(songs);
		int i;
		for(i = 0; i < tracks.size(); i++){
			tracks.get(i).setAlbum(this);
		}
		objectId = 0;
		mediaURL = albumURL;
		AlbumArt = "/main/gui/note.png";
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public ArrayList<Track> getTracks()
	{
		return tracks;
	}
	
	public void setTracks(ArrayList<Track> tracks)
	{
		this.tracks = tracks;
	}
	
	public void addTrack(Track newTrack)
	{
		tracks.add(newTrack);
	}
	
	public String getMediaURL()
	{
		return mediaURL;
	}

	public void setMediaURL(String newURL){
		mediaURL = newURL;
	}
	
	public int getObjectId()
	{
		return objectId;
	}

	public void setObjectId(int id){
		objectId = id;
	}
	
	public String getAlbumArt(){
		return AlbumArt;
	}
	
	public void setAlbumArt(String newArt){
		AlbumArt = newArt;
	}
}
