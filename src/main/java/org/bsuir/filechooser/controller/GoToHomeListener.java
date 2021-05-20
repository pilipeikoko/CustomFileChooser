package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToHomeListener implements ActionListener {
    private final ConsistDirectoryPanel consistDirectoryPanel;
    private final String homeDirectory;

    public GoToHomeListener(ConsistDirectoryPanel consistDirectoryPanel, String homeDirectory) {
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.homeDirectory = homeDirectory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        consistDirectoryPanel.setCurrentDirectory(homeDirectory);
    }
}

