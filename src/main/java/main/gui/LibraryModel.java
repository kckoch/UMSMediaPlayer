package main.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class LibraryModel extends AbstractTableModel {
	private static final String[] columnHeaders = {"Name"};
	private ArrayList<Container> myData;
	
	public LibraryModel(ArrayList<Container> data) {
		myData = data;
	}
	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return myData.size();
	}
	
	@Override
    public String getColumnName(int column) {
        return columnHeaders[column];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return myData.get(rowIndex).getName();
	}

}
