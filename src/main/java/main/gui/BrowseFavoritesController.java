package main.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BrowseFavoritesController {
	
	Album selectedAlbum;
	Track selectedTrack;
	JTable favoritesTable;
	User user;
	
	//BrowseFavoritesController constructor
	public BrowseFavoritesController(JTable table, User newUser){
		selectedAlbum = null;
		selectedTrack = null;
		favoritesTable = table;
		user = newUser;
	}
	
	//sets the selected album or selected track object for the controller
	@SuppressWarnings("rawtypes")
	public void setSelectedObject(JTable favoritesTable, int view, DefaultTableModel albumView, DefaultTableModel trackView){
		if(favoritesTable.getSelectedRow() >= 0){	
			if(view == 1 && favoritesTable.getSelectedRow() == 0){//in trackView and if the back option is selected
				favoritesTable.setModel(albumView);//switches to albumView
				int i;
				for(i = selectedAlbum.tracks.size(); i > 0; i--){//clears the trackView
					trackView.removeRow(i);
				}
			}else{
				int rowIndex = favoritesTable.getSelectedRow();
				if(view == 0){//in albumView
					setSelectedAlbum(rowIndex);
					int i;
					for(i = 0; i < user.getFavorites().get(rowIndex).tracks.size(); i++){//builds the rows with tracks information from the selected album
						Vector<Comparable> newTrack = new Vector<Comparable>();
						newTrack.addElement(user.getFavorites().get(rowIndex).tracks.get(i).title);
						newTrack.addElement(user.getFavorites().get(rowIndex).tracks.get(i).totalTime);
						newTrack.addElement(user.getFavorites().get(rowIndex).tracks.get(i).artist);
						trackView.addRow(newTrack);
					}
					favoritesTable.setModel(trackView);//switches to trackView
				}
				if(view == 1){//trackView and row slected other than back option
					if(rowIndex >= 0){		
						setSelectedTrack(rowIndex);
					}
				}
			}
		}
		
	}
	
	//sets the selectedAlbum object for the controller
	public void setSelectedAlbum(int row){
		int i;
		for(i = 0; i < user.getFavorites().size(); i++){
			if(favoritesTable.getModel().getValueAt(row, 0) == user.getFavorites().get(i).name){//makes sure the correct album is selected
				selectedAlbum = user.getFavorites().get(i);
				break;
			}
		}
	}
	
	//returns the selectedAlbum object for the controller
	public Album getSelectedAlbum(){
		
		return selectedAlbum;
		
	}
	
	//sets the selectedTrack object for the controller
	public void setSelectedTrack(int row){
		 
		int i;
		for(i = 0; i < selectedAlbum.tracks.size(); i++){	
			if(favoritesTable.getModel().getValueAt(row, 0) == selectedAlbum.tracks.get(i).title){//makes sure the correct track is selected
					selectedTrack = selectedAlbum.tracks.get(i);
					break;
			}
		}
	}
		
	//returns the selectedTrack object for the controller
	public Track getSelectedTrack(){
		
		return selectedTrack;
		
	}
	
	//removes the Album from the users list of favorites
	public void removeAlbum(int view, DefaultTableModel albumView, DefaultTableModel trackView, int row){
		if(view == 1){//if in trackView
			albumView.removeRow(row);//removes the row from favorites
			favoritesTable.setModel(albumView);//switches to albumView
			int j;
			for(j = selectedAlbum.tracks.size(); j > 0; j--){//clears trackView
				trackView.removeRow(j);
			}
		}else if(view == 0){//if in albumView
			albumView.removeRow(row);//removes the row from favorites
		}
	}
	
	//removes the album from the audio file if no users have it as a favorite
	public int removeFavorites(int view, DefaultTableModel albumView, DefaultTableModel trackView, ArrayList<User> users){
		int retVal = 0;
		if(selectedAlbum != null){//selectedAlbum has to be set
			
			int i;
			for(i = 0; i < user.getFavorites().size(); i++){//cycles through users
				
				if(selectedAlbum == user.getFavorites().get(i)){//checks to see if the particular user has the album as a favorite
					removeAlbum(view, albumView, trackView, i);
					user.getFavorites().remove(i);//removes the album from the user's favorites
					//removeFavoritesFromLocal(users); doesn't work yet
					selectedAlbum = null;
					retVal = 1;
					break;
					
				}
				
			}
			
		}
		
		return retVal;
		
	}
	/* not working Supposed to check to see if the album is in another user's favorites and deletes it from audio
	public void removeFavoritesFromLocal(ArrayList<User> users){
		int i;
		int foundOtherInstance = 0;
		for(i = 0; i < users.size(); i++){
			int j;
			for(j = 0; j < users.get(i).getFavorites().size(); j++){
				if(selectedAlbum.name == users.get(i).getFavorites().get(j).name){
					foundOtherInstance = 1;
					break;
				}
			}
				
		}
		if(foundOtherInstance != 1){
			File file = new File(selectedAlbum.mediaURL);
			if(file.isDirectory()){
				file.delete();
			}
		}
	}*/

}
