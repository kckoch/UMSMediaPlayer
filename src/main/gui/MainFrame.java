package main.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	
	/**
	 * @wbp.parser.entryPoint
	 */

	public static JFrame init(final User user) {
		frame = new JFrame("That's My Jam!");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLayeredPane listPane = new JLayeredPane();
		listPane.setBounds(10, 0, 474, 381);
		frame.getContentPane().add(listPane);

		DefaultTableModel favoritesModel = new DefaultTableModel();
		favoritesModel.addColumn("Track ID");
		favoritesModel.addColumn("Title");
		favoritesModel.addColumn("Artist");
		favoritesModel.addColumn("Total Time");
		/*favoritesModel.addRow(rowData);this is where you would add the data for each track*/
	
	
		DefaultTableModel libraryModel = new DefaultTableModel();
		libraryModel.addColumn("Track ID");
		libraryModel.addColumn("Title");
		libraryModel.addColumn("Artist");
		libraryModel.addColumn("Total Time");
		/*do the same thing for library row data;*/
	
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
		mainTab.setBackground(Color.LIGHT_GRAY);
		mainTab.setBounds(0, 12, 484, 369);
		listPane.add(mainTab);
		favoritesTable = new JTable(favoritesModel);//where you put albums from the favorites
		favoritesTable.setBackground(Color.LIGHT_GRAY);
		mainTab.addTab("Favorites", null, favoritesTable, null);
		libraryTable = new JTable(libraryModel);//where you put albums from the library
		mainTab.addTab("Library", null, libraryTable, null);
			
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 0, 457, 30);
		listPane.add(buttonPanel);
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setLayout(null);
		
		JButton btnSettings = new JButton("");
		btnSettings.setBorder(null);
		btnSettings.setBackground(Color.DARK_GRAY);
		btnSettings.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/settingicon.png")));
		btnSettings.setBounds(379, 5, 35, 25);
		buttonPanel.add(btnSettings);
		
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/initlogout.png")));
		btnLogOut.setBounds(416, 5, 46, 25);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				user.setLoggedin(false);
			}
		});
		buttonPanel.add(btnLogOut);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.DARK_GRAY);
		searchPanel.setBounds(228, 3, 176, 30);
		buttonPanel.add(searchPanel);
		searchPanel.setLayout(null);
			
	
		txtSearch = new JTextField();
		txtSearch.setBorder(null);
		txtSearch.setBounds(12, 8, 114, 19);
		searchPanel.add(txtSearch);
		txtSearch.setText("Search");
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/searchicon.png")));
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setBorder(null);
		btnSearch.setBounds(120, 4, 32, 25);
		searchPanel.add(btnSearch);
	
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
		placeHolderForImage.setBounds(25, 38, 111, 111);
		playPanel.add(placeHolderForImage);
	
		JRadioButton favoritesButton = new JRadioButton("");
		favoritesButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		favoritesButton.setSelectedIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/goldstar.png")));
		favoritesButton.setBackground(Color.GRAY);
		favoritesButton.setIcon(new ImageIcon(MainFrame.class.getResource("/main/gui/blackstar.png")));
		favoritesButton.setBounds(427, 8, 51, 23);
		playPanel.add(favoritesButton);
	
		JLabel trackLabel = new JLabel("Track Title:");
		trackLabel.setBounds(165, 38, 70, 23);
		playPanel.add(trackLabel);
	
		JTextPane trackTitleText = new JTextPane();
		trackTitleText.setText("This is the Track Title");
		trackTitleText.setBounds(231, 38, 247, 20);
		playPanel.add(trackTitleText);
	
		JSlider songSlider = new JSlider();
		songSlider.setForeground(Color.WHITE);
		songSlider.setBackground(Color.GRAY);
		songSlider.setBounds(165, 62, 313, 26);
		playPanel.add(songSlider);
	
		JTextPane elapsedText = new JTextPane();
		elapsedText.setText("This is the elapsed time.");
		elapsedText.setBounds(165, 87, 128, 20);
		playPanel.add(elapsedText);
	
		JTextPane totalText = new JTextPane();
		totalText.setText("This is the total time.");
		totalText.setBounds(360, 87, 118, 20);
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
	
		JButton playButton = new JButton("Play");
		playButton.setBounds(296, 119, 53, 23);
		playPanel.add(playButton);
	
		JButton pauseButton = new JButton("||");
		pauseButton.setBounds(231, 119, 53, 23);
		playPanel.add(pauseButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(360, 119, 55, 23);
		playPanel.add(stopButton);
	
		JButton previousButton = new JButton("<<");
		previousButton.setBounds(164, 119, 53, 23);
		playPanel.add(previousButton);
	
		JButton nextButton = new JButton(">>");
		nextButton.setBounds(425, 119, 53, 23);
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
