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
	JPanel buttonPanel;
	
	public BrowseFavoritesController(JTable table, User newUser){
		selectedAlbum = null;
		selectedTrack = null;
		favoritesTable = table;
		user = newUser;
		buttonPanel = null;
	}
	
	@SuppressWarnings("rawtypes")
	public void setSelectedObject(JTable favoritesTable, int view, DefaultTableModel albumView, DefaultTableModel trackView){
		if(favoritesTable.getSelectedRow() >= 0){	
			if(view == 1 && favoritesTable.getSelectedRow() == 0){
				favoritesTable.setModel(albumView);
				int i;
				for(i = selectedAlbum.tracks.size(); i > 0; i--){
					trackView.removeRow(i);
				}
			}else{
				int rowIndex = favoritesTable.getSelectedRow();
				if(view == 0){
					setSelectedAlbum(rowIndex);
					int i;
					for(i = 0; i < user.getFavorites().get(rowIndex).tracks.size(); i++){
						Vector<Comparable> newTrack = new Vector<Comparable>();
						newTrack.addElement(user.getFavorites().get(rowIndex).tracks.get(i).title);
						newTrack.addElement(user.getFavorites().get(rowIndex).tracks.get(i).totalTime);
						newTrack.addElement(user.getFavorites().get(rowIndex).tracks.get(i).artist);
						trackView.addRow(newTrack);
					}
					favoritesTable.setModel(trackView);
				}
				if(view == 1){
					if(rowIndex >= 0){		
						setSelectedTrack(rowIndex);
					}
				}
			}
		}
		
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
			if(favoritesTable.getModel().getValueAt(row, 0) == selectedAlbum.tracks.get(i).title){
					selectedTrack = selectedAlbum.tracks.get(i);
					break;
			}
		}
	}
		
	
	public Track getSelectedTrack(){
		
		return selectedTrack;
		
	}
	
	public void removeAlbum(int view, DefaultTableModel albumView, DefaultTableModel trackView, int row){
		if(view == 1){
			albumView.removeRow(row);
			favoritesTable.setModel(albumView);
			int j;
			for(j = selectedAlbum.tracks.size(); j > 0; j--){
				trackView.removeRow(j);
			}
		}else if(view == 0){
			albumView.removeRow(row);
		}
	}
	
	public int removeFavorites(int view, DefaultTableModel albumView, DefaultTableModel trackView, ArrayList<User> users){
		int retVal = 0;
		if(selectedAlbum != null){
			
			int i;
			for(i = 0; i < user.getFavorites().size(); i++){
				
				if(selectedAlbum == user.getFavorites().get(i)){
					removeAlbum(view, albumView, trackView, i);
					user.getFavorites().remove(i);
					//removeFavoritesFromLocal(users); doesn't work yet
					selectedAlbum = null;
					retVal = 1;
					break;
					
				}
				
			}
			
		}
		
		return retVal;
		
	}
	
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
	}

}
