package main.gui;

import javax.swing.JTable;

public class BrowseFavoritesController {
	
	Album selectedAlbum;
	Track selectedTrack;
	JTable favoritesTable;
	User user;
	
	public BrowseFavoritesController(JTable table, User newUser){
		selectedAlbum = null;
		selectedTrack = null;
		favoritesTable = table;
		user = newUser;
	}
	
	public void setSelectedAlbum(){
		
		int rowIndex = favoritesTable.getSelectedRow();
		int i;
		for(i = 0; i < user.getFavorites().size(); i++){
			if(favoritesTable.getModel().getValueAt(rowIndex, 0) == user.getFavorites().get(i).name){
				selectedAlbum = user.getFavorites().get(i);
				break;
			}
		}
		
	}
	
	public Album getSelectedAlbum(){
		
		return selectedAlbum;
		
	}
	
	public void setSelectedTrack(Track newTrack){
		
		selectedTrack = newTrack;
		
	}
	
	public Track getSelectedTrack(){
		
		return selectedTrack;
		
	}

}
