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
	
	public int setSelectedObject(int objectCheck){
		int rowIndex = favoritesTable.getSelectedRow();
		if(objectCheck == 0){
			setSelectedAlbum(rowIndex);
		}
		if(objectCheck == 1){
			setSelectedTrack(rowIndex);
		}
		return rowIndex;
	}
	
	public void setSelectedAlbum(int row){
		int i;
		for(i = 0; i < user.getFavorites().size(); i++){
			if(favoritesTable.getModel().getValueAt(row, 0) == user.getFavorites().get(i).name){
				selectedAlbum = user.getFavorites().get(i);
				break;
			}
		}
	}
	
	public Album getSelectedAlbum(){
		
		return selectedAlbum;
		
	}
	
	public void setSelectedTrack(int row){
		 
		int i;
		for(i = 0; i < selectedAlbum.tracks.size(); i++){
			
			if(favoritesTable.getModel().getValueAt(row, 0) == selectedAlbum.tracks.get(i)){
					selectedTrack = selectedAlbum.tracks.get(i);
					break;
			}
				
		}
	}
		
	
	public Track getSelectedTrack(){
		
		return selectedTrack;
		
	}

}
