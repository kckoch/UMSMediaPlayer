package main.gui;

import java.util.ArrayList;
import java.util.List;

public class Album {

	String name;
	ArrayList<Track> tracks;
	int objectId;
	String mediaURL;
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
	
	public String getAlbumArt(){
		return AlbumArt;
	}
	
	public void setAlbumArt(String newArt){
		AlbumArt = newArt;
	}

	public void setObjectId(int id){
		objectId = id;
	}
	
	public int getObjectId()
	{
		return objectId;
	}
}
