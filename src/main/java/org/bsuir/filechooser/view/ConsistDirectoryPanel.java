package org.bsuir.filechooser.view;


import org.bsuir.filechooser.controller.*;

import javax.swing.*;
import java.awt.*;

public class ConsistDirectoryPanel extends JPanel {
    private final ChooseFilePanel chooseFilePanel;

    private String currentDirectory;
    private DisplayPanel displayPanel;
    private final JToolBar changeConsist;

    public ConsistDirectoryPanel(String homeDirectory, ChooseFilePanel chooseFilePanel) {
        setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        setLayout(new BorderLayout());
        changeConsist = new JToolBar("", JToolBar.HORIZONTAL);
        changeConsist.setFloatable(false);

        JButton atHome = new JButton("home");
        atHome.addActionListener(new GoToHomeListener(this, homeDirectory));
        JButton toPrevious = new JButton("prev");
        toPrevious.addActionListener(new GoToPreviousListener(this));
        JToggleButton toTable = new JToggleButton("as table", true);
        toTable.addActionListener(new TableDisplayListener(this, changeConsist, chooseFilePanel));
        JToggleButton toList = new JToggleButton("as list", false);
        toList.addActionListener(new ListDisplayListener(this, changeConsist, chooseFilePanel));
        JToggleButton toDirectory = new JToggleButton("directories", false);
        toDirectory.addActionListener(new DirectoryDisplayListener(this, changeConsist, chooseFilePanel));

        atHome.setBorder(new RoundedBorder(5));
        atHome.setBackground(Color.white);
        atHome.setForeground(Color.black);

        toPrevious.setBorder(new RoundedBorder(5));
        toPrevious.setBackground(Color.white);
        toPrevious.setForeground(Color.black);

        toTable.setBorder(new RoundedBorder(5));
        toTable.setBackground(Color.white);
        toTable.setForeground(Color.black);

        toList.setBorder(new RoundedBorder(5));
        toList.setBackground(Color.white);
        toList.setForeground(Color.black);

        toDirectory.setBorder(new RoundedBorder(5));
        toDirectory.setBackground(Color.white);
        toDirectory .setForeground(Color.black);



        changeConsist.add(atHome);
        changeConsist.add(toPrevious);
        changeConsist.add(toTable);
        changeConsist.add(toList);
        changeConsist.add(toDirectory);
        add(changeConsist, BorderLayout.NORTH);

        currentDirectory = homeDirectory;
        this.chooseFilePanel = chooseFilePanel;
        displayPanel = new TableDisplayPanel(this, currentDirectory, chooseFilePanel);
        add(displayPanel, BorderLayout.CENTER);
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
        changeConsist();
    }

    public void changeConsist() {
        displayPanel.setConsist(currentDirectory);
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(DisplayPanel displayPanel1) {
        remove(displayPanel);
        this.displayPanel = displayPanel1;
        add(this.displayPanel, BorderLayout.CENTER);
        this.displayPanel.updateUI();
    }

    public ChooseFilePanel getChooseFilePanel() {
        return chooseFilePanel;
    }

    public JToolBar getChangeConsist() {
        return changeConsist;
    }
}
