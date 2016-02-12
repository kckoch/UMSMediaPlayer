package main.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame = new JFrame("That's My JAM");
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLayeredPane listPane = new JLayeredPane();
		listPane.setBounds(0, 0, 484, 250);
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
		
		
		JButton btnLogOut = new JButton("@");
		btnLogOut.setBounds(413, 0, 71, 22);
		listPane.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				user.setLoggedin(false);
			}
		});
		
	
		txtSearch = new JTextField();
		txtSearch.setBounds(136, 0, 143, 22);
		listPane.add(txtSearch);
		txtSearch.setText("Search");
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("p");
		btnSearch.setBounds(275, 0, 66, 22);
		listPane.add(btnSearch);
	
		JButton btnSettings = new JButton("{|}");
		btnSettings.setBounds(341, 0, 72, 22);
		listPane.add(btnSettings);
	
		JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
		mainTab.setBounds(0, -1, 484, 250);
		listPane.add(mainTab);
		favoritesTable = new JTable(favoritesModel);//where you put albums from the favorites
		mainTab.addTab("Favorites", null, favoritesTable, null);
		libraryTable = new JTable(libraryModel);//where you put albums from the library
		mainTab.addTab("Library", null, libraryTable, null);
	
		playFrame = new JFrame("That's My JAM");
		playFrame.setSize(500, 600);
		playFrame.setLocationRelativeTo(null);
		playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playFrame.getContentPane().setLayout(null);
	
		playPanel = new JPanel();
		playPanel.setBounds(0, 247, 484, 314);
		frame.getContentPane().add(playPanel);
		playPanel.setLayout(null);
	
		placeHolderForImage = new JPanel();
		placeHolderForImage.setBounds(10, 79, 141, 141);
		playPanel.add(placeHolderForImage);
	
		JRadioButton favoritesButton = new JRadioButton("StarFavorites");
		favoritesButton.setBounds(337, 4, 141, 14);
		playPanel.add(favoritesButton);
	
		JLabel trackLabel = new JLabel("Track Title:");
		trackLabel.setBounds(161, 75, 70, 23);
		playPanel.add(trackLabel);
	
		JTextPane trackTitleText = new JTextPane();
		trackTitleText.setText("This is the Track Title");
		trackTitleText.setBounds(231, 75, 247, 20);
		playPanel.add(trackTitleText);
	
		JSlider songSlider = new JSlider();
		songSlider.setBounds(161, 109, 313, 26);
		playPanel.add(songSlider);
	
		JTextPane elapsedText = new JTextPane();
		elapsedText.setText("This is the elapsed time.");
		elapsedText.setBounds(171, 146, 128, 20);
		playPanel.add(elapsedText);
	
		JTextPane totalText = new JTextPane();
		totalText.setText("This is the total time.");
		totalText.setBounds(360, 146, 118, 20);
		playPanel.add(totalText);
	
		maximizeButton = new JButton("^");
		maximizeButton.setBounds(0, 0, 41, 23);
		playPanel.add(maximizeButton);
		maximizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				playFrame.setVisible(true);
				frame.setVisible(false);
			}
		});
	
		JButton playButton = new JButton("Play");
		playButton.setBounds(290, 197, 53, 23);
		playPanel.add(playButton);
	
		JButton pauseButton = new JButton("||");
		pauseButton.setBounds(227, 197, 53, 23);
		playPanel.add(pauseButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(356, 197, 55, 23);
		playPanel.add(stopButton);
	
		JButton previousButton = new JButton("<<");
		previousButton.setBounds(164, 197, 53, 23);
		playPanel.add(previousButton);
	
		JButton nextButton = new JButton(">>");
		nextButton.setBounds(425, 197, 53, 23);
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
