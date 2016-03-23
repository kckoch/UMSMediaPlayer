package main.gui;

import javax.media.CannotRealizeException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

//import com.sun.glass.events.MouseEvent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import main.controller.BrowseFavoritesController;
import main.controller.BrowseServerController;
import main.controller.PlayTrackController;
import main.model.Container;
import main.model.LibraryModel;
import main.model.SOAP;
import main.model.Setting;
import main.model.User;
import main.model.*;

import java.awt.Color;
import java.awt.Dimension;


public class MainFrame {
	private static JFrame frame;
	private static JPanel mainPanel;
	private static JTextField txtSearch;
	private static JTable favoritesTable;
	private static JTable libraryTable;
	private static JPanel playPanel;
	private static JLabel placeHolderForImage;
	private static JFrame playFrame;
	private static String duration;
	private static String elapsed;
	private static int total = 0;
	private static int elapsedTime;
	private static DefaultTableModel notDisplayed;
	private static DefaultTableModel displayed;
	private static int favsAlbumsOrTracks = 0;
	private static JPanel buttonPanel;
	private static JButton removeFavsBut;
	private static JTextPane trackTitleText;
	private static Timer timer;
	private static JTextField trackArtistText;
	private static LibraryModel libraryModel;
	private static ArrayList<Container> list;
	private static ListSelectionModel librarySelectionModel;
	private static int previousid;
	
	/**
	 * @wbp.parser.entryPoint
	 */

	//The Main Frame layout and view
	@SuppressWarnings("rawtypes")
	public static JFrame init(final User user, final ArrayList<User> users, final Setting settings) {
		frame = new JFrame("That's My Jam!");
		frame.setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		timer = new Timer(0, null);
		
		
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setMaximumSize(new Dimension(500, 600));
		mainPanel.setName("");
		mainPanel.setBorder(null);
	
		JLayeredPane listPane = new JLayeredPane();
		listPane.setOpaque(true);
		listPane.setBorder(null);
		listPane.setBackground(Color.DARK_GRAY);
		listPane.setBounds(10, 0, 474, 381);
		
		Vector<Comparable> back = new Vector<Comparable>();//the back row data
		back.addElement("Back");
		
		final DefaultTableModel favoritesModelAlbums = new DefaultTableModel() {//Favorites Album table model
			public boolean isCellEditable(int row, int column){
				return false;
			};
			
		};// favorites list data
		favoritesModelAlbums.addColumn("Album Name");
		int i;
		for(i = 0; i < user.getFavorites().size(); i++){//adds all the rows for the user's favorites
			Vector<Comparable> newAlbum = new Vector<Comparable>();
			newAlbum.addElement(user.getFavorites().get(i).getName());
			favoritesModelAlbums.addRow(newAlbum);
		}
		
		displayed = favoritesModelAlbums;
		
		final DefaultTableModel favoritesModelTracks = new DefaultTableModel() {//Favorites Track table model
			public boolean isCellEditable(int row, int column){
				return false;
			};
		};// favorites list data
		favoritesModelTracks.addColumn("Title");
		favoritesModelTracks.addColumn("Duration");
		favoritesModelTracks.addColumn("Artist");
		favoritesModelTracks.addRow(back);//back option
		notDisplayed = favoritesModelTracks;

		try {
			SOAP.sendRequest("0");
		}  catch(Exception e) {
			//
		}
		list  = SOAP.getList();
		for(int u = 0; u < list.size(); u++) {
			System.out.println(list.get(u).getId() + "\t" + list.get(u).getName());
		}
		libraryModel = new LibraryModel(list);
		libraryTable = new JTable(libraryModel);//where you put albums from library, tab for library
		libraryTable.setBackground(Color.LIGHT_GRAY);
		libraryTable.setRowSelectionAllowed(true);
		libraryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		librarySelectionModel = libraryTable.getSelectionModel();
		libraryModel.fireTableDataChanged();
		previousid = 0;
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(204, 0, 260, 30);
		listPane.add(buttonPanel);
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setLayout(null);
		
		if(user.getAdmin()) {//settings button only available to an admin
			JButton btnSettings = new JButton("");
			btnSettings.setBorder(null);
			btnSettings.setBackground(Color.DARK_GRAY);
			btnSettings.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/settingicon.png")));
			btnSettings.setBounds(195, 3, 35, 25);
			btnSettings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SettingGUI.init(mainPanel, frame, user, libraryTable, users, settings);
					//frame.setContentPane(SettingGUI.init(mainPanel, frame, user));
				}
			});
			buttonPanel.add(btnSettings);
		}
		
		JButton btnLogOut = new JButton("");// logout button
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/initlogout.png")));
		btnLogOut.setBounds(231, 3, 35, 25);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				user.setLoggedin(false);
			}
		});
		buttonPanel.add(btnLogOut);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(null);
		searchPanel.setBackground(Color.DARK_GRAY);
		searchPanel.setBounds(45, 3, 158, 30);
		buttonPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
	
		txtSearch = new JTextField();// search text field
		txtSearch.setBorder(null);
		txtSearch.setBounds(12, 3, 114, 19);
		searchPanel.add(txtSearch);
		txtSearch.setText("Search");
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");// search button
		btnSearch.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/searchicon.png")));
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setBorder(null);
		btnSearch.setBounds(127, 2, 25, 25);
		searchPanel.add(btnSearch);
		
		removeFavsBut = new JButton();//Remove From Favorites Button looks like a trash can
		removeFavsBut.setBackground(Color.WHITE);
		removeFavsBut.setBounds(25, 8, 20, 20);
		removeFavsBut.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/trash.png")));
		buttonPanel.add(removeFavsBut);
		
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);//Favorites and Library Tabs
		mainTab.setBackground(Color.LIGHT_GRAY);
		mainTab.setBounds(0, 12, 484, 369);
		listPane.add(mainTab);
		favoritesTable = new JTable(favoritesModelAlbums);//where you put albums from the favorites, default tab for favorites
		favoritesTable.setBackground(Color.LIGHT_GRAY);
		favoritesTable.setRowSelectionAllowed(true);
		favoritesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel favoritesSelectionModel = favoritesTable.getSelectionModel();
		JScrollPane favoritesScroll = new JScrollPane(favoritesTable);
		mainTab.addTab("Favorites", null, favoritesScroll, null);
		
		JScrollPane libraryScroll = new JScrollPane(libraryTable);
		mainTab.addTab("Library", null, libraryScroll, null);
		
		//tries to make remove favorites button invisible when the library tab is selected, doesnt work
		libraryScroll.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
		        buttonPanel.remove(removeFavsBut);
		        buttonPanel.revalidate();
		        buttonPanel.repaint();
		    }

		    public void focusLost(FocusEvent e) {
		    	buttonPanel.add(removeFavsBut);
		    	buttonPanel.revalidate();
		    	buttonPanel.repaint();
		    }
		});
		if(mainTab.getSelectedComponent() == favoritesScroll){
			removeFavsBut.setVisible(true);
		}else{
			removeFavsBut.setVisible(false);
		}
	
		//play panel
		playFrame = new JFrame("That's My JAM");
		playFrame.setSize(500, 600);
		playFrame.setLocationRelativeTo(null);
		playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playFrame.getContentPane().setLayout(null);
	
		playPanel = new JPanel();
		playPanel.setBackground(Color.GRAY);
		playPanel.setBounds(10, 393, 476, 169);
		playPanel.setLayout(null);
		
		placeHolderForImage = new JLabel(new ImageIcon(MainFrame.class.getResource("/main/gui/note.png")));// album art
		placeHolderForImage.setBounds(8, 38, 111, 111);
		playPanel.add(placeHolderForImage);
	
		//Displays the track title
		trackTitleText = new JTextPane();
		trackTitleText.setText("Title");
		trackTitleText.setBounds(129, 38, 111, 20);
		playPanel.add(trackTitleText);
		
		//Displays the track artist
		trackArtistText = new JTextField();
		trackArtistText.setText("Artist");
		trackArtistText.setBounds(250, 38, 111, 20);
		playPanel.add(trackArtistText);
		trackArtistText.setColumns(10);
	
		//the navigation slider
		final JSlider songSlider = new JSlider();//slider
		songSlider.setForeground(Color.WHITE);
		songSlider.setBackground(Color.GRAY);
		songSlider.setBounds(129, 62, 313, 26);
		songSlider.setValue(0);//sets the initial value to 0
		playPanel.add(songSlider);
		
		//sets the initial value of the elapsed time 
	    elapsedTime = (total * songSlider.getValue() / 100);//elapsed time
	    if(elapsedTime%60 < 10){
			elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
		}else{
			elapsed = elapsedTime/60 + ":" + elapsedTime%60;
		}
	    //Displays the elapsed time the track has played
		final JTextPane elapsedText = new JTextPane();
		elapsedText.setForeground(Color.WHITE);
		elapsedText.setBorder(null);
		elapsedText.setBackground(Color.GRAY);
		elapsedText.setText(elapsed);
		elapsedText.setBounds(129, 87, 38, 20);
		playPanel.add(elapsedText);
	
		//calculates total time
		if(total%60 < 10){
			duration = total/60 + ":0" + total%60;
		}else{
			duration = total/60 + ":" + total%60;
		}
		//Displays the total time of the track
		final JTextPane totalText = new JTextPane();
		totalText.setBackground(Color.GRAY);
		totalText.setForeground(Color.WHITE);
		totalText.setText(duration);
		totalText.setBounds(411, 87, 38, 20);
		playPanel.add(totalText);
	
		//The play and pause button initially looks like play button
		final JButton playButton = new JButton("");
		playButton.setBackground(Color.GRAY);
		playButton.setBorder(null);
		playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));
		playButton.setBounds(176, 99, 50, 50);
		playPanel.add(playButton);
		
		//The stop button
		JButton stopButton = new JButton("");
		stopButton.setBorder(null);
		stopButton.setBackground(Color.GRAY);
		stopButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/stop_button.png")));
		stopButton.setBounds(236, 109, 38, 33);
		playPanel.add(stopButton);
		
		mainPanel.setLayout(null);

		mainPanel.add(listPane);
		mainPanel.add(playPanel);
		frame.setContentPane(mainPanel);
		
		final PlayTrackController playTrackCntl = new PlayTrackController(songSlider);
		
		final BrowseFavoritesController browseFavCntl = new BrowseFavoritesController(favoritesTable, user);
		final BrowseServerController servCntl = new BrowseServerController(list, user, settings);
		
		removeFavsBut.addActionListener(new ActionListener() {//remove album from favorites
			public void actionPerformed(ActionEvent e){
				
				if(favsAlbumsOrTracks== 1){
					if(browseFavCntl.removeFavorites(favsAlbumsOrTracks, notDisplayed, displayed, users) == 1){
						notDisplayed = displayed;
						displayed = (DefaultTableModel) favoritesTable.getModel();
						favsAlbumsOrTracks++;
						favsAlbumsOrTracks = favsAlbumsOrTracks%2;
					}
				}else{
					browseFavCntl.removeFavorites(favsAlbumsOrTracks, displayed, notDisplayed, users);
				}
			}
		});

		librarySelectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int row = libraryTable.getSelectedRow();
                    if(row == -1)
                        return;
					String tempstr = (String)libraryModel.getValueAt(row, 0);
					list = servCntl.getNewContainer(tempstr);
					
					libraryModel = new LibraryModel(list);

					libraryModel.fireTableDataChanged();
					libraryTable.setModel(libraryModel);
					libraryTable.repaint();
					libraryTable.clearSelection();
				}
			}
		});
		
		favoritesSelectionModel.addListSelectionListener(new ListSelectionListener(){//determines what object is selected on the favorites table
			public void valueChanged(ListSelectionEvent e){
				if(favoritesTable.getSelectedRow() >= 0){
					if(favsAlbumsOrTracks == 1 && favoritesTable.getSelectedRow() == 0){
						browseFavCntl.setSelectedObject(favoritesTable, favsAlbumsOrTracks, notDisplayed, displayed);
						notDisplayed = displayed;
						displayed = (DefaultTableModel) favoritesTable.getModel();
						favsAlbumsOrTracks++;
						favsAlbumsOrTracks = favsAlbumsOrTracks%2;
					}else{
						if(favsAlbumsOrTracks == 0){
							browseFavCntl.setSelectedObject(favoritesTable, favsAlbumsOrTracks, displayed, notDisplayed);
							notDisplayed = displayed;
							displayed = (DefaultTableModel) favoritesTable.getModel();
							favsAlbumsOrTracks++;
							favsAlbumsOrTracks = favsAlbumsOrTracks%2;
						}
					}
					if(favsAlbumsOrTracks == 1){
						browseFavCntl.setSelectedObject(favoritesTable, favsAlbumsOrTracks, notDisplayed, displayed);
						if(browseFavCntl.getSelectedTrack() != null){
							playTrackCntl.setTrack(browseFavCntl.getSelectedTrack());
							trackTitleText.setText(playTrackCntl.getTrack().getTitle());
							trackArtistText.setText(playTrackCntl.getTrack().getArtist());
							total = (int) playTrackCntl.getTrack().getTotalTime();
							elapsedTime = (total * songSlider.getValue() / 100);//elapsed time
						    if(elapsedTime%60 < 10){
								elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
							}else{
								elapsed = elapsedTime/60 + ":" + elapsedTime%60;						
							}
							elapsedText.setText(elapsed);
						
							//total time
							if(total%60 < 10){	
								duration = total/60 + ":0" + total%60;
							}else{
								duration = total/60 + ":" + total%60;
							}
							totalText.setText(duration);
						}
					}
				}
			}
			
		});
		
		
		
		playButton.addActionListener(new ActionListener() {//plays track if a track is selected or pauses it
			public void actionPerformed(ActionEvent e){
				if(playTrackCntl.getPlayerStatus() == playerStatus.STOPPED){//if the track has been stopped or not started
					try {
						timer.restart();//resets the elapsed time and slider to 0
						playTrackCntl.startTrack();
						playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/pause_button.png")));//changes the play/pause button to the pause icon
					} catch (NoPlayerException | CannotRealizeException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(playTrackCntl.getPlayerStatus() == playerStatus.PAUSED){//if the track has been paused
					timer.start();//starts up the timer again
					playTrackCntl.playTrack();
					playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/pause_button.png")));//changes the play/pause button to the pause icon
				}else if(playTrackCntl.getPlayerStatus() == playerStatus.PLAYING){//if the track is playing
					timer.stop();//stops the timer
					playTrackCntl.pauseTrack();
					playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));//changes the play/pause button to the play icon
				}
			}
		});
		
	
		stopButton.addActionListener(new ActionListener() {//stops the track from playing and sets the play pause button to the play icon
			public void actionPerformed(ActionEvent e){
				if(playTrackCntl.getPlayerStatus() == playerStatus.PLAYING){//if the track is playing
					timer.stop();//stops the timer
					playTrackCntl.stopTrack();
					playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));//changes the play pause button icon
				}else if(playTrackCntl.getPlayerStatus() == playerStatus.PAUSED){//if the track is paused
					timer.stop();//stops the timer
					playTrackCntl.stopTrack();
					playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));//changes the play pause button icon
				}else if(playTrackCntl.getPlayerStatus() == playerStatus.STOPPED){//if the track is stopped or not started
					timer.stop();//stops the timer
					playTrackCntl.stopTrack();
					playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));//changes the play pause button icon
				}
			}
		});
		
		
		//links the sliders and elapsed time text together with the timer
		timer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(playTrackCntl.getPlayerStatus() == playerStatus.PLAYING){//if the track is playing
					//sets the values of the slider and the elapsed time displayed in the play panel
					songSlider.setValue((int) (playTrackCntl.getTrackPlayer().getMediaTime().getSeconds()/playTrackCntl.getTrackPlayer().getDuration().getSeconds()*100));
					elapsedTime = (total * songSlider.getValue() / 100);
					if(elapsedTime%60 < 10){
						elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
					}else{
						elapsed = elapsedTime/60 + ":" + elapsedTime%60;
					}
					elapsedText.setText(elapsed);//sets the elapsed time displayed in the play panel
				}if(playTrackCntl.getTrackPlayer().getMediaTime() == playTrackCntl.getTrackPlayer().getDuration()){//if the track has ended
					playTrackCntl.setPlayerStatus(playerStatus.STOPPED);//sets the playerStat value to stopped
					//sets the slider value to 0 and the elapsed time value to 0
					songSlider.setValue(0);
					elapsedTime = (total * songSlider.getValue() / 100);
					if(elapsedTime%60 < 10){
						elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
					}else{
						elapsed = elapsedTime/60 + ":" + elapsedTime%60;
					}
					elapsedText.setText(elapsed);
				}
			}
		});

		return frame;
	}
}
