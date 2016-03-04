package main.gui;

import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


//import com.sun.glass.events.MouseEvent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Insets;
//import java.awt.Rectangle;
//import java.awt.ComponentOrientation;


public class MainFrame {
	private static JFrame frame;
	private static JPanel mainPanel;
	private static JTextField txtSearch;
	private static JTable favoritesTable;
	private static JTable libraryTable;
	private static JScrollPane libraryPanel;
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
	private static LibraryModel libraryModel;
	private static ArrayList<Container> list;
	
	/**
	 * @wbp.parser.entryPoint
	 */

	@SuppressWarnings("rawtypes")
	public static JFrame init(final User user, final ArrayList<User> users) {
		frame = new JFrame("That's My Jam!");
		frame.setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		Vector<Comparable> back = new Vector<Comparable>();
		back.addElement("Back");
		
		final DefaultTableModel favoritesModelAlbums = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column){
				return false;
			};
			
		};// favorites list data
		favoritesModelAlbums.addColumn("Album Name");
		int i;
		for(i = 0; i < user.getFavorites().size(); i++){
			Vector<Comparable> newAlbum = new Vector<Comparable>();
			newAlbum.addElement(user.getFavorites().get(i).name);
			favoritesModelAlbums.addRow(newAlbum);
		}
		
		displayed = favoritesModelAlbums;
		
		final DefaultTableModel favoritesModelTracks = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column){
				return false;
			};
		};// favorites list data
		favoritesModelTracks.addColumn("Title");
		favoritesModelTracks.addColumn("Duration");
		favoritesModelTracks.addColumn("Artist");
		favoritesModelTracks.addRow(back);
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
		ListSelectionModel librarySelectionModel = libraryTable.getSelectionModel();
		libraryModel.fireTableDataChanged();
		
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
					SettingGUI.init(mainPanel, frame, user, libraryTable, users);
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
		
		removeFavsBut = new JButton("TRASH");
		removeFavsBut.setBounds(-14, 3, 70, 23);
		buttonPanel.add(removeFavsBut);
		
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
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
		
		libraryScroll.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
		        buttonPanel.remove(removeFavsBut);
		        buttonPanel.repaint();
		    }

		    public void focusLost(FocusEvent e) {
		    	buttonPanel.add(removeFavsBut);
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
	
		/*final JRadioButton favoritesButton = new JRadioButton("");// button to mark album for favorites
		favoritesButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		favoritesButton.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/gold_star.png")));
		favoritesButton.setBackground(Color.GRAY);
		favoritesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/white_star.png")));
		favoritesButton.setBounds(427, 8, 51, 23);
		playPanel.add(favoritesButton);*/
		
		//track title
		JLabel trackLabel = new JLabel("Track Title:");
		trackLabel.setForeground(Color.WHITE);
		trackLabel.setBounds(129, 35, 70, 23);
		playPanel.add(trackLabel);
	
		trackTitleText = new JTextPane();
		trackTitleText.setText("This is the Track Title");
		trackTitleText.setBounds(203, 38, 158, 20);
		playPanel.add(trackTitleText);
	
		final JSlider songSlider = new JSlider();//slider
		songSlider.setForeground(Color.WHITE);
		songSlider.setBackground(Color.GRAY);
		songSlider.setBounds(129, 62, 313, 26);
		songSlider.setValue(0);
		playPanel.add(songSlider);
		
	    elapsedTime = (total * songSlider.getValue() / 100);//elapsed time
	    if(elapsedTime%60 < 10){
			elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
		}else{
			elapsed = elapsedTime/60 + ":" + elapsedTime%60;
		}
		final JTextPane elapsedText = new JTextPane();
		elapsedText.setForeground(Color.WHITE);
		elapsedText.setBorder(null);
		elapsedText.setBackground(Color.GRAY);
		elapsedText.setText(elapsed);
		elapsedText.setBounds(129, 87, 38, 20);
		playPanel.add(elapsedText);
	
		//total time
		if(total%60 < 10){
			duration = total/60 + ":0" + total%60;
		}else{
			duration = total/60 + ":" + total%60;
		}
		final JTextPane totalText = new JTextPane();
		totalText.setBackground(Color.GRAY);
		totalText.setForeground(Color.WHITE);
		totalText.setText(duration);
		totalText.setBounds(411, 87, 38, 20);
		playPanel.add(totalText);
	
		final JButton playButton = new JButton("");//play button/ pause button
		playButton.setBackground(Color.GRAY);
		playButton.setBorder(null);
		playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));
		playButton.setBounds(270, 99, 50, 50);
		playPanel.add(playButton);
	
		JButton pauseButton = new JButton("");//pause button
		pauseButton.setBorder(null);
		pauseButton.setBackground(Color.GRAY);
		pauseButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/pause_button.png")));
		pauseButton.setBounds(209, 109, 35, 35);
		playPanel.add(pauseButton);
		
		JButton stopButton = new JButton("");//stop button
		stopButton.setBorder(null);
		stopButton.setBackground(Color.GRAY);
		stopButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/stop_button.png")));
		stopButton.setBounds(335, 109, 38, 33);
		playPanel.add(stopButton);
	
		JButton previousButton = new JButton("");//previous button
		previousButton.setBackground(Color.GRAY);
		previousButton.setBorder(null);
		previousButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/skipbackwards_button.png")));
		previousButton.setBounds(146, 109, 35, 35);
		playPanel.add(previousButton);
	
		JButton nextButton = new JButton("");//next button
		nextButton.setBackground(Color.GRAY);
		nextButton.setBorder(null);
		nextButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/skipforward_button.png")));
		nextButton.setActionCommand("");
		nextButton.setBounds(400, 108, 35, 35);
		playPanel.add(nextButton);
		
		mainPanel.setLayout(null);

		mainPanel.add(listPane);
		mainPanel.add(playPanel);
		frame.setContentPane(mainPanel);
		
		//links the sliders and elapsed time text together
		//songSliderBig.setBackground(Color.DARK_GRAY);
		songSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				elapsedTime = (total * songSlider.getValue() / 100);
				if(elapsedTime%60 < 10){
					elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
				}else{
					elapsed = elapsedTime/60 + ":" + elapsedTime%60;
				}
			    elapsedText.setText(elapsed);
			    //elapsedTextBig.setText(elapsed);
			    //songSliderBig.setValue(songSlider.getValue());
			}
		});
		
		final PlayTrackController playTrackCntl = new PlayTrackController();
		
		final BrowseFavoritesController browseFavCntl = new BrowseFavoritesController(favoritesTable, user);
		final BrowseServerController servCntl = new BrowseServerController(libraryTable);
		
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
				if (e.getValueIsAdjusting()) 
					return;
				int row = libraryTable.getSelectedRow();
				String tempstr = (String)libraryModel.getValueAt(row, 0);
				String id = "";
				for(int p = 0; p < list.size(); p++){
					if(list.get(p).getName().compareTo(tempstr) == 0) {
						id = Integer.toString(list.get(p).getId());
						System.out.println(id);
					}
				}
				try {
					SOAP.sendRequest(id);
					list = SOAP.getList();
				} catch (Exception x) {
					//
				}
				libraryModel = new LibraryModel(list);
				for(int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j).getId() + "\t" + list.get(j).getName());
				}
				libraryModel.fireTableDataChanged();
				libraryTable.repaint();
			}
		});
		
		favoritesSelectionModel.addListSelectionListener(new ListSelectionListener(){
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
						if(browseFavCntl.selectedTrack != null){
							playTrackCntl.track = browseFavCntl.selectedTrack;
							trackTitleText.setText(playTrackCntl.track.title);
							total = (int) playTrackCntl.track.totalTime;
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
		
		
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(playTrackCntl.playerStat == playerStatus.STOPPED){
					try {
						playTrackCntl.startTrack(browseFavCntl.selectedTrack);
					} catch (NoPlayerException | CannotRealizeException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					playTrackCntl.playTrack();
				}
			}
		});
		
		return frame;
	}
}
