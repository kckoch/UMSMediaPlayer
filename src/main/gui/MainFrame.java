package main.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.glass.events.MouseEvent;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Time;
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
	private static JTextField txtSearch;
	private static JTabbedPane library;
	private static JScrollPane libraryList;
	private static JTable favoritesTable;
	private static JTable libraryTable;
	private static JPanel playPanel;
	private static JButton maximizeButton;
	private static JPanel placeHolderForImage;
	private static JFrame playFrame;
	private static String duration;
	private static String elapsed;
	private static int total = 300;
	private static int elapsedTime;
	private static Time timer;
	
	/**
	 * @wbp.parser.entryPoint
	 */

	public static JFrame init(final User user) {
		frame = new JFrame("That's My Jam!");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLayeredPane listPane = new JLayeredPane();
		listPane.setBounds(10, 0, 474, 381);
		frame.getContentPane().add(listPane);
		Vector sampleSong = new Vector();
		sampleSong.addElement(user.getFavorites().get(0).tracks.get(0));
		//sampleSong.

		DefaultTableModel favoritesModel = new DefaultTableModel();
		favoritesModel.addColumn("Song");
		favoritesModel.addRow(sampleSong);
	
	
		DefaultTableModel libraryModel = new DefaultTableModel();
		libraryModel.addColumn("Song");
		libraryModel.addRow(sampleSong);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(204, 0, 260, 30);
		listPane.add(buttonPanel);
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setLayout(null);
		
		JButton btnSettings = new JButton("");
		btnSettings.setBorder(null);
		btnSettings.setBackground(Color.DARK_GRAY);
		btnSettings.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/settingicon.png")));
		btnSettings.setBounds(195, 3, 35, 25);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(SettingGUI.init());
			}
		});
		buttonPanel.add(btnSettings);
		
		
		JButton btnLogOut = new JButton("");
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
		searchPanel.setBackground(Color.DARK_GRAY);
		searchPanel.setBounds(45, 3, 158, 30);
		buttonPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
	
		txtSearch = new JTextField();
		txtSearch.setBorder(null);
		txtSearch.setBounds(12, 3, 114, 19);
		searchPanel.add(txtSearch);
		txtSearch.setText("Search");
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/searchicon.png")));
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setBorder(null);
		btnSearch.setBounds(120, 2, 32, 25);
		searchPanel.add(btnSearch);
		
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
		mainTab.setBackground(Color.LIGHT_GRAY);
		mainTab.setBounds(0, 12, 484, 369);
		listPane.add(mainTab);
		favoritesTable = new JTable(favoritesModel);//where you put albums from the favorites
		favoritesTable.setBackground(Color.LIGHT_GRAY);
		mainTab.addTab("Favorites", null, favoritesTable, null);
		libraryTable = new JTable(libraryModel);//where you put albums from the library
		libraryTable.setBackground(Color.LIGHT_GRAY);
		mainTab.addTab("Library", null, libraryTable, null);
		
		/*favoritesTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evnt) {
				if(this.getClick() == 1){
					getPropertyFromRow((String)(t_property.getValueAt(favoritesTable.getSelectedRow(),0)));
				}
			}
		});*/
	
		playFrame = new JFrame("That's My JAM");
		playFrame.setSize(500, 600);
		playFrame.setLocationRelativeTo(null);
		playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playFrame.getContentPane().setLayout(null);
	
		playPanel = new JPanel();
		playPanel.setBackground(Color.GRAY);
		playPanel.setBounds(10, 393, 476, 169);
		frame.getContentPane().add(playPanel);
		playPanel.setLayout(null);
	
		placeHolderForImage = new JPanel();
		placeHolderForImage.setBounds(8, 38, 111, 111);
		playPanel.add(placeHolderForImage);
	
		JRadioButton favoritesButton = new JRadioButton("");
		favoritesButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		favoritesButton.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/gold_star.png")));
		favoritesButton.setBackground(Color.GRAY);
		favoritesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/white_star.png")));
		favoritesButton.setBounds(427, 8, 51, 23);
		playPanel.add(favoritesButton);
	
		JLabel trackLabel = new JLabel("Track Title:");
		trackLabel.setForeground(Color.WHITE);
		trackLabel.setBounds(129, 35, 70, 23);
		playPanel.add(trackLabel);
	
		JTextPane trackTitleText = new JTextPane();
		trackTitleText.setText("This is the Track Title");
		trackTitleText.setBounds(203, 38, 158, 20);
		playPanel.add(trackTitleText);
	
		final JSlider songSlider = new JSlider();
		songSlider.setForeground(Color.WHITE);
		songSlider.setBackground(Color.GRAY);
		songSlider.setBounds(129, 62, 313, 26);
		playPanel.add(songSlider);
		
	    elapsedTime = (total * songSlider.getValue() / 100);
	    elapsed = "" + elapsedTime;
		final JTextPane elapsedText = new JTextPane();
		elapsedText.setForeground(Color.WHITE);
		elapsedText.setBorder(null);
		elapsedText.setBackground(Color.GRAY);
		elapsedText.setText(elapsed);
		elapsedText.setBounds(129, 87, 38, 20);
		playPanel.add(elapsedText);
		
		songSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				//System.out.println("song slider: " + songSlider.getValue());
				elapsedTime = (total * songSlider.getValue() / 100);
			    elapsed = "" + elapsedTime;
			    elapsedText.setText(elapsed);
			}
		});
	
		duration = "" + total;
		JTextPane totalText = new JTextPane();
		totalText.setBackground(Color.GRAY);
		totalText.setForeground(Color.WHITE);
		totalText.setText(duration);
		totalText.setBounds(411, 87, 38, 20);
		playPanel.add(totalText);
		
		
	
		maximizeButton = new JButton("");
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
		maximizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				playFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
	
		JButton playButton = new JButton("");
		playButton.setBackground(Color.GRAY);
		playButton.setBorder(null);
		playButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/play_button.png")));
		playButton.setBounds(270, 99, 50, 50);
		playPanel.add(playButton);
	
		JButton pauseButton = new JButton("");
		pauseButton.setBorder(null);
		pauseButton.setBackground(Color.GRAY);
		pauseButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/pause_button.png")));
		pauseButton.setBounds(209, 109, 38, 33);
		playPanel.add(pauseButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(335, 109, 38, 33);
		playPanel.add(stopButton);
	
		JButton previousButton = new JButton("");
		previousButton.setBackground(Color.GRAY);
		previousButton.setBorder(null);
		previousButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/skipbackwards_button.png")));
		previousButton.setBounds(146, 109, 38, 33);
		playPanel.add(previousButton);
	
		JButton nextButton = new JButton("");
		nextButton.setBackground(Color.GRAY);
		nextButton.setBorder(null);
		nextButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/skipforward_button.png")));
		nextButton.setActionCommand("");
		nextButton.setBounds(400, 108, 35, 35);
		playPanel.add(nextButton);
	    //System.out.println("\nIm here");
		
		JPanel playPanelBig = new JPanel();
		playPanelBig.setBounds(0, 0, 484, 564);
		playFrame.getContentPane().add(playPanelBig);
		playPanelBig.setLayout(null);
	
		JPanel placeHolderForImageBig = new JPanel();
		placeHolderForImageBig.setBounds(10, 79, 141, 141);
		playPanelBig.add(placeHolderForImageBig);
	
		JRadioButton favoritesButtonBig = new JRadioButton("StarFavorites");
		favoritesButtonBig.setBounds(337, 4, 141, 14);
		playPanelBig.add(favoritesButtonBig);
	
		JLabel trackLabelBig = new JLabel("Track Title:");
		trackLabelBig.setBounds(161, 75, 70, 23);
		playPanelBig.add(trackLabelBig);
	
		JTextPane trackTitleTextBig = new JTextPane();
		trackTitleTextBig.setText("This is the Track Title");
		trackTitleTextBig.setBounds(231, 75, 247, 20);
		playPanelBig.add(trackTitleTextBig);
	
		JSlider songSliderBig = new JSlider();
		songSliderBig.setBounds(161, 109, 313, 26);
		playPanelBig.add(songSliderBig);
	
		JTextPane elapsedTextBig = new JTextPane();
		elapsedTextBig.setText("This is the elapsed time.");
		elapsedTextBig.setBounds(171, 146, 128, 20);
		playPanelBig.add(elapsedTextBig);
	
		JTextPane totalTextBig = new JTextPane();
		totalTextBig.setText("This is the total time.");
		totalTextBig.setBounds(360, 146, 118, 20);
		playPanelBig.add(totalTextBig);
	
		JButton minimizeButton = new JButton("v");
		minimizeButton.setBounds(0, 0, 41, 23);
		playPanelBig.add(minimizeButton);
		minimizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.setVisible(true);
				playFrame.setVisible(false);
			}
		});
	
		JButton playButtonBig = new JButton("Play");
		playButtonBig.setBounds(290, 197, 53, 23);
		playPanelBig.add(playButtonBig);
	
		JButton pauseButtonBig = new JButton("||");
		pauseButtonBig.setBounds(227, 197, 53, 23);
		playPanelBig.add(pauseButtonBig);
		
		JButton stopButtonBig = new JButton("Stop");
		stopButtonBig.setBounds(356, 197, 55, 23);
		playPanelBig.add(stopButtonBig);
	
		JButton previousButtonBig = new JButton("<<");
		previousButtonBig.setBounds(164, 197, 53, 23);
		playPanelBig.add(previousButtonBig);
	
		JButton nextButtonBig = new JButton(">>");
		nextButtonBig.setBounds(425, 197, 53, 23);
		playPanelBig.add(nextButtonBig);
	    //System.out.println("\nIm here");
		
		return frame;
		
	}
}
