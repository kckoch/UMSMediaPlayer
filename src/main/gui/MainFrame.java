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
	private static Boolean myLoggedOut;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame init(User user) {
		if(true/*user.getLoggedIn()*/){
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
			btnLogOut.setBounds(413, 0, 71, 23);
			listPane.add(btnLogOut);
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					myLoggedOut = true;
					//user.setLoggedIn(false);
				}
			});
			
		
			txtSearch = new JTextField();
			txtSearch.setBounds(136, 0, 143, 22);
			listPane.add(txtSearch);
			txtSearch.setText("Search");
			txtSearch.setColumns(10);
			
			JButton btnSearch = new JButton("p");
			btnSearch.setBounds(275, 0, 66, 23);
			listPane.add(btnSearch);
		
			JButton btnSettings = new JButton("{|}");
			btnSettings.setBounds(341, 0, 72, 23);
			listPane.add(btnSettings);
		
			JTabbedPane mainTab = new JTabbedPane(JTabbedPane.TOP);
			mainTab.setBounds(0, -1, 484, 250);
			listPane.add(mainTab);
			favoritesTable = new JTable(favoritesModel);//where you put albums from the favorites
			mainTab.addTab("Favorites", null, favoritesTable, null);
			libraryTable = new JTable(libraryModel);//where you put albums from the library
			mainTab.addTab("Library", null, libraryTable, null);
		
			
			
		
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
		
			maximizeButton = new JButton("Maximize");
			maximizeButton.setBounds(0, 0, 91, 23);
			playPanel.add(maximizeButton);
		
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
		    System.out.println("\nIm here");
			return frame;
		
		}
		
		return null;
	}
}
