package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ChooseFilePanel;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;
import org.bsuir.filechooser.view.DirectoryDisplayPanel;

import javax.swing.*;

public class DirectoryDisplayListener extends ModeListener {
    public DirectoryDisplayListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, changeConsist, chooseFilePanel);
    }

    protected void changeMode() {
        consistDirectoryPanel.setDisplayPanel(new DirectoryDisplayPanel(consistDirectoryPanel,
                consistDirectoryPanel.getCurrentDirectory(), chooseFilePanel));
    }
}
