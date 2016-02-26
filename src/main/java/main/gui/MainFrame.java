package main.java.main.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


//import com.sun.glass.events.MouseEvent;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;


public class MainFrame {
	private static JFrame frame;
	private static JPanel mainPanel;
	private static JTextField txtSearch;
	private static JTable favoritesTable;
	private static JTable libraryTable;
	private static JPanel playPanel;
	private static JButton maximizeButton;
	private static JLabel placeHolderForImage;
	private static JFrame playFrame;
	private static String duration;
	private static String elapsed;
	private static int total = 300;
	private static int elapsedTime;
	/**
	 * @wbp.parser.entryPoint
	 */

	@SuppressWarnings("rawtypes")
	public static JFrame init(final User user) {
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
		//vectors for all the album datas to be put into the favorites and library lists
		Vector<Comparable> sampleAlbum0 = new Vector<Comparable>();
		sampleAlbum0.addElement(user.getFavorites().get(0).name);
		Vector<Comparable> sampleAlbum1 = new Vector<Comparable>();
		sampleAlbum1.addElement(user.getFavorites().get(1).name);
		Vector<Comparable> sampleAlbum2 = new Vector<Comparable>();
		sampleAlbum2.addElement(user.getFavorites().get(2).name);
		Vector<Comparable> sampleAlbum3 = new Vector<Comparable>();
		sampleAlbum3.addElement(user.getFavorites().get(3).name);
		Vector<Comparable> sampleAlbum4 = new Vector<Comparable>();
		sampleAlbum4.addElement(user.getFavorites().get(4).name);
		Vector<Comparable> sampleAlbum5 = new Vector<Comparable>();
		sampleAlbum5.addElement(user.getFavorites().get(5).name);
		Vector<Comparable> sampleAlbum6 = new Vector<Comparable>();
		sampleAlbum6.addElement(user.getFavorites().get(6).name);
		Vector<Comparable> sampleAlbum7 = new Vector<Comparable>();
		sampleAlbum7.addElement(user.getFavorites().get(7).name);
		Vector<Comparable> sampleAlbum8 = new Vector<Comparable>();
		sampleAlbum8.addElement(user.getFavorites().get(8).name);
		Vector<Comparable> sampleAlbum9 = new Vector<Comparable>();
		sampleAlbum9.addElement(user.getFavorites().get(9).name);
		
		DefaultTableModel favoritesModel = new DefaultTableModel();// favorites list data
		favoritesModel.addColumn("Album Name");
		favoritesModel.addRow(sampleAlbum0);
		favoritesModel.addRow(sampleAlbum1);
		favoritesModel.addRow(sampleAlbum2);
		favoritesModel.addRow(sampleAlbum3);
		favoritesModel.addRow(sampleAlbum4);
		favoritesModel.addRow(sampleAlbum5);
		favoritesModel.addRow(sampleAlbum6);
		favoritesModel.addRow(sampleAlbum7);
		favoritesModel.addRow(sampleAlbum8);
		favoritesModel.addRow(sampleAlbum9);
		
	
	
		DefaultTableModel libraryModel = new DefaultTableModel();// library list data
		libraryModel.addColumn("Album Name");
		libraryModel.addRow(sampleAlbum0);
		libraryModel.addRow(sampleAlbum1);
		libraryModel.addRow(sampleAlbum2);
		libraryModel.addRow(sampleAlbum3);
		libraryModel.addRow(sampleAlbum4);
		libraryModel.addRow(sampleAlbum5);
		libraryModel.addRow(sampleAlbum6);
		libraryModel.addRow(sampleAlbum7);
		libraryModel.addRow(sampleAlbum8);
		libraryModel.addRow(sampleAlbum9);
		
		JPanel buttonPanel = new JPanel();
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
					SettingGUI.init(mainPanel, frame, user, libraryTable);
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
		
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
		mainTab.setBackground(Color.LIGHT_GRAY);
		mainTab.setBounds(0, 12, 484, 369);
		listPane.add(mainTab);
		favoritesTable = new JTable(favoritesModel);//where you put albums from the favorites, default tab for favorites
		favoritesTable.setBackground(Color.LIGHT_GRAY);
		JScrollPane favoritesScroll = new JScrollPane(favoritesTable);
		mainTab.addTab("Favorites", null, favoritesScroll, null);
		libraryTable = new JTable(libraryModel);//where you put albums from library, tab for library
		libraryTable.setBackground(Color.LIGHT_GRAY);
		JScrollPane libraryScroll = new JScrollPane(libraryTable);
		mainTab.addTab("Library", null, libraryScroll, null);
		
		
		/*favoritesTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evnt) {
				if(this.getClick() == 1){
					getPropertyFromRow((String)(t_property.getValueAt(favoritesTable.getSelectedRow(),0)));
				}
			}
		});*/
	
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
	
		placeHolderForImage = new JLabel(new ImageIcon(MainFrame.class.getResource(user.getFavorites().get(0).getAlbumArt())));// album art
		placeHolderForImage.setBounds(8, 38, 111, 111);
		playPanel.add(placeHolderForImage);
	
		final JRadioButton favoritesButton = new JRadioButton("");// button to mark album for favorites
		favoritesButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		favoritesButton.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/gold_star.png")));
		favoritesButton.setBackground(Color.GRAY);
		favoritesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/white_star.png")));
		favoritesButton.setBounds(427, 8, 51, 23);
		playPanel.add(favoritesButton);
		
		//track title
		JLabel trackLabel = new JLabel("Track Title:");
		trackLabel.setForeground(Color.WHITE);
		trackLabel.setBounds(129, 35, 70, 23);
		playPanel.add(trackLabel);
	
		JTextPane trackTitleText = new JTextPane();
		trackTitleText.setText("This is the Track Title");
		trackTitleText.setBounds(203, 38, 158, 20);
		playPanel.add(trackTitleText);
	
		final JSlider songSlider = new JSlider();//slider
		songSlider.setForeground(Color.WHITE);
		songSlider.setBackground(Color.GRAY);
		songSlider.setBounds(129, 62, 313, 26);
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
		JTextPane totalText = new JTextPane();
		totalText.setBackground(Color.GRAY);
		totalText.setForeground(Color.WHITE);
		totalText.setText(duration);
		totalText.setBounds(411, 87, 38, 20);
		playPanel.add(totalText);
	
		maximizeButton = new JButton("");//maximize button
		maximizeButton.setPreferredSize(new Dimension(26, 16));
		maximizeButton.setMinimumSize(new Dimension(26, 16));
		maximizeButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		maximizeButton.setBounds(new Rectangle(0, 0, 26, 16));
		maximizeButton.setMargin(new Insets(0, 0, 0, 0));
		maximizeButton.setIconTextGap(0);
		maximizeButton.setHorizontalTextPosition(SwingConstants.LEFT);
		maximizeButton.setBorder(null);
		maximizeButton.setMaximumSize(new Dimension(26, 16));
		maximizeButton.setBackground(Color.GRAY);
		maximizeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/superuparrow.png")));
		maximizeButton.setBounds(8, 8, 45, 23);
		playPanel.add(maximizeButton);
		maximizeButton.addActionListener(new ActionListener() {//change to full screen play panel
			public void actionPerformed(ActionEvent e){
				playFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
	
		JButton playButton = new JButton("");//play button
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
		
		//maximize screen play panel has same buttons, labels, and sliders as smaller play panel
		JPanel playPanelBig = new JPanel();
		playPanelBig.setBorder(null);
		playPanelBig.setBackground(Color.DARK_GRAY);
		playPanelBig.setBounds(0, 0, 500, 600);
		playFrame.getContentPane().add(playPanelBig);
		playPanelBig.setLayout(null);
	
		JLabel placeHolderForImageBig = new JLabel(new ImageIcon(MainFrame.class.getResource(user.getFavorites().get(0).getAlbumArt())));// album art
		placeHolderForImageBig.setBounds(156, 85, 154, 155);
		playPanelBig.add(placeHolderForImageBig);
	
		final JRadioButton favoritesButtonBig = new JRadioButton("");
		favoritesButtonBig.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/gold_star.png")));
		favoritesButtonBig.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/white_star.png")));
		favoritesButtonBig.setBackground(Color.DARK_GRAY);
		favoritesButtonBig.setBounds(441, 0, 31, 31);
		playPanelBig.add(favoritesButtonBig);
	
		final JSlider songSliderBig = new JSlider();
		songSliderBig.setBounds(77, 295, 313, 39);
		playPanelBig.add(songSliderBig);
	
		final JTextPane elapsedTextBig = new JTextPane();
		elapsedTextBig.setText(elapsed);
		elapsedTextBig.setBackground(Color.DARK_GRAY);
		elapsedTextBig.setForeground(Color.WHITE);
		elapsedTextBig.setBounds(55, 346, 128, 20);
		playPanelBig.add(elapsedTextBig);
	
		JTextPane totalTextBig = new JTextPane();
		totalTextBig.setText(duration);
		totalTextBig.setBackground(Color.DARK_GRAY);
		totalTextBig.setForeground(Color.WHITE);
		totalTextBig.setBounds(348, 346, 118, 20);
		playPanelBig.add(totalTextBig);
	
		JButton minimizeButton = new JButton("");//minimize play panel
		minimizeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/downarrow.png")));
		minimizeButton.setBackground(Color.DARK_GRAY);
		minimizeButton.setBounds(0, 0, 41, 23);
		playPanelBig.add(minimizeButton);
		minimizeButton.addActionListener(new ActionListener() {//switch to play panel sharing screen with favorites and library lists
			public void actionPerformed(ActionEvent e){
				frame.setVisible(true);
				playFrame.setVisible(false);
			}
		});
	
		JButton playButtonBig = new JButton("");
		playButtonBig.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button_big.png")));
		playButtonBig.setBackground(Color.DARK_GRAY);
		playButtonBig.setBorder(null);
		playButtonBig.setBounds(195, 398, 71, 72);
		playPanelBig.add(playButtonBig);
	
		JButton pauseButtonBig = new JButton("");
		pauseButtonBig.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/pause_button_big.png")));
		pauseButtonBig.setBackground(Color.DARK_GRAY);
		pauseButtonBig.setBorder(null);
		pauseButtonBig.setBounds(130, 407, 53, 51);
		playPanelBig.add(pauseButtonBig);
		
		JButton stopButtonBig = new JButton("");
		stopButtonBig.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/stop_button_big.png")));
		stopButtonBig.setBackground(Color.DARK_GRAY);
		stopButtonBig.setBorder(null);
		stopButtonBig.setBounds(278, 407, 53, 51);
		playPanelBig.add(stopButtonBig);
	
		JButton previousButtonBig = new JButton("");
		previousButtonBig.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/skipbackwards_button_big.png")));
		previousButtonBig.setBackground(Color.DARK_GRAY);
		previousButtonBig.setBorder(null);
		previousButtonBig.setBounds(55, 407, 53, 51);
		playPanelBig.add(previousButtonBig);
	
		JButton nextButtonBig = new JButton("");
		nextButtonBig.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/skipforward_button_big.png")));
		nextButtonBig.setBackground(Color.DARK_GRAY);
		nextButtonBig.setBorder(null);
		nextButtonBig.setBounds(353, 407, 53, 51);
		playPanelBig.add(nextButtonBig);
		
		JLabel lblTrackTitle = new JLabel("Track Title");
		lblTrackTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackTitle.setForeground(Color.WHITE);
		lblTrackTitle.setBounds(123, 252, 223, 31);
		playPanelBig.add(lblTrackTitle);
		mainPanel.setLayout(null);
		
		mainPanel.add(listPane);
		mainPanel.add(playPanel);
		frame.setContentPane(mainPanel);
		
		//links the sliders and elapsed time text together
		songSliderBig.setBackground(Color.DARK_GRAY);
		songSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				elapsedTime = (total * songSlider.getValue() / 100);
				if(elapsedTime%60 < 10){
					
					elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
				
				}else{
				
					elapsed = elapsedTime/60 + ":" + elapsedTime%60;
				
				}
			    elapsedText.setText(elapsed);
			    elapsedTextBig.setText(elapsed);
			    songSliderBig.setValue(songSlider.getValue());
			}
		});
		
		songSliderBig.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				elapsedTime = (total * songSliderBig.getValue() / 100);
				if(elapsedTime%60 < 10){
					
					elapsed = elapsedTime/60 + ":0" + elapsedTime%60;
				
				}else{
				
					elapsed = elapsedTime/60 + ":" + elapsedTime%60;
				
				}
			    elapsedText.setText(elapsed);
			    elapsedTextBig.setText(elapsed);
			    songSlider.setValue(songSliderBig.getValue());
			}
		});
		
		return frame;
	}
}
