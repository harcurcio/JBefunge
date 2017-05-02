package com.laboon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class MainWindow extends JFrame {

    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    private MainPanel _mainPanel;

    private ButtonPanel _buttonPanel;

    public void setProgramArea(String p) {
	_mainPanel.setTextArea(p);
    }

    public String getProgramArea() {
	return _mainPanel.getTextArea();
    }
    
    public JMenuBar createMenuBar() {
	
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription(
                "File options");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("Open file");
        menuItem.setMnemonic(KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Open Befunge file");
	menuItem.addActionListener(new OpenListener());
        menu.add(menuItem);

        menuItem = new JMenuItem("Save file");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Save Befunge file");
	menuItem.addActionListener(new SaveListener());
        menu.add(menuItem);

        menuItem = new JMenuItem("Save As...");
        menuItem.setMnemonic(KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Save Befunge file as");
	menuItem.addActionListener(new SaveAsListener());
        menu.add(menuItem);
	
	menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Quit IDE");
	menuItem.addActionListener(new QuitListener());
        menu.add(menuItem);	
	
        // Build "Run" menu in the menu bar.
        menu = new JMenu("Run");
        menu.setMnemonic(KeyEvent.VK_R);
        menu.getAccessibleContext().setAccessibleDescription(
                "Run options");
        menuBar.add(menu);

	menuItem = new JMenuItem("Run program");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Run Program");
        menu.add(menuItem);

	menuItem = new JMenuItem("Step program");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_5, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Step Program");
        menu.add(menuItem);

	// Separator
        menu.addSeparator();
	
        //a group of check box menu items for different options
        cbMenuItem = new JCheckBoxMenuItem("Time program");
        cbMenuItem.setMnemonic(KeyEvent.VK_T);
	cbMenuItem.addItemListener(new TimerListener());
        menu.add(cbMenuItem);
 
        cbMenuItem = new JCheckBoxMenuItem("Check for end opcode");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
	cbMenuItem.addItemListener(new CheckEndOpcodeListener());
        menu.add(cbMenuItem);
 
        return menuBar;
    }
     
    
    public MainWindow() {

	//Create and set up the window.
        JFrame frame = new JFrame("MenuLookDemo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        this.setJMenuBar(createMenuBar());

        //Display the window.
	
	this.setSize(WIDTH, HEIGHT);
	// Close program when window is closed
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.setTitle("UNTITLED");
	
	// Add Main Panel and Button Panel
	
	_mainPanel = new MainPanel();

	_buttonPanel = new ButtonPanel(_mainPanel);

	// Provide static ref to main GUI elements
	SystemSettings.setMainWindow(this);
	SystemSettings.setMainPanel(_mainPanel);
	
	this.add(_mainPanel, BorderLayout.NORTH);
	this.add(_buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
	
		
    }
    
    
}
