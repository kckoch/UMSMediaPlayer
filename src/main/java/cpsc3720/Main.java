package cpsc3720;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
	private JList<String> list;
	private JTextField txtSearch;
	private static JFrame frame;
	private JTextArea urlText;
	private JTextArea objectIdText;
	
	
	private DefaultListModel<String> listModel;
	
	Vector<String> ObjectIDs;
	Vector<String> URLs;
	
	static String soapString = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>"+
"<s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"" +
"	xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
"	<s:Body>" +
"		<u:Browse xmlns:u=\"urn:schemas-upnp-org:service:ContentDirectory:1\">" +
"			<ObjectID>{OBJECT_ID}</ObjectID>" +
"			<BrowseFlag>BrowseDirectChildren</BrowseFlag>" +
"			<Filter></Filter>" +
"			<StartingIndex>0</StartingIndex>" +
"			<RequestedCount>999</RequestedCount>" +
"			<SortCriteria></SortCriteria>" +
"		</u:Browse>" +
"	</s:Body>" +
"</s:Envelope>";

    
	
	public Main() throws IOException {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		list.setBounds(30, 71, 554, 152);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					onListElementSelect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(list);
		
		
		
		JLabel ServerLabel = new JLabel("Server URL:");
		ServerLabel.setBounds(304, 351, 84, 15);
		getContentPane().add(ServerLabel);
		
		urlText = new JTextArea();
		urlText.setText("http://127.0.0.1:5001/upnp/control/content_directory");
		urlText.setBounds(398, 345, 214, 20);
		getContentPane().add(urlText);
		
		JLabel objIDLabel = new JLabel("Object ID:");
		objIDLabel.setBounds(314, 377, 74, 15);
		getContentPane().add(objIDLabel);
		
		objectIdText = new JTextArea();
		objectIdText.setText("0");
		objectIdText.setBounds(395, 377, 90, 15);
		getContentPane().add(objectIdText);
		
		JButton retrieveButton = new JButton("Retrieve");
		retrieveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					onRetrieveClick();
				} catch (IOException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		});
		retrieveButton.setBounds(495, 377, 117, 25);
		getContentPane().add(retrieveButton);
		
		txtSearch = new JTextField();
		txtSearch.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
		});
		txtSearch.setText("search");
		txtSearch.setBounds(30, 31, 114, 19);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(156, 31, 84, 15);
		getContentPane().add(btnSearch);
		
		playPanel pPanel = new playPanel("", "");
		pPanel.setLocation(10, 234);
		pPanel.setSize(230, 200);
		getContentPane().add(pPanel);
	}
	
	private void onRetrieveClick() throws IOException
	{
		list.setSelectedIndex(-1);
		listModel.removeAllElements();
		list.removeAll();
		URLs.removeAllElements();
		ObjectIDs.removeAllElements();
		
		String objectID = objectIdText.getText();
		if(objectID == null || objectID.length() == 0)
		{
			objectID = "0";
		}
		String soapMsg = soapString.replace("{OBJECT_ID}", objectID);
		
		ArrayList<Object> items = (ArrayList<Object>) SOAP.getItems(soapMsg, urlText.getText());
		
		for(Iterator<Object> i = items.iterator(); i.hasNext();)
		{
			String[] next = (String[]) i.next();
			
			addElementToList(next[0], next[1], next[2]);
			
		}
	}
	
	private void onListElementSelect() throws IOException
	{
		int index = list.getSelectedIndex();
		
		if(index >= 0)
		{
			urlText.setText(URLs.elementAt(index));
			objectIdText.setText(ObjectIDs.elementAt(index));
			if(getContentPane().getComponents().length > 8){
				getContentPane().remove(8);
			}
			playPanel pPanel = new playPanel(urlText.getText(), objectIdText.getText());
			getContentPane().add(pPanel);
		}
	}
	
	private void addElementToList(String element, String ObjectID, String URL)
	{
		listModel.addElement(ObjectID + " | " + element);
		ObjectIDs.add(ObjectID);
		URLs.add(URL);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}



