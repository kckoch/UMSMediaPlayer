package main.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class Tree {
	private JTree tree;
	private static ArrayList<Container> list = new ArrayList<Container>();
	
	public Tree() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Library");
        createNodes(top, "0");
        
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        
        tree.addTreeSelectionListener(new TreeSelectionListener(){
        	public void valueChanged(TreeSelectionEvent e) {
                //
            }
        });
	}
	
	private void createNodes(DefaultMutableTreeNode top, String id) {
		try {
			SOAP.sendRequest(id);
		} catch (IOException e) {
			//
		}
		list = SOAP.getList();
		DefaultMutableTreeNode newChild;
		for(int i = 0; i < list.size(); i++) {
			newChild = new DefaultMutableTreeNode(new Container(list.get(i).getId(), list.get(i).getName()));
			top.add(newChild);
			createNodes(newChild, Integer.toString(list.get(i).getId()));
		}
	}
	
	public JTree getTree() {
		return tree;
	}
}
