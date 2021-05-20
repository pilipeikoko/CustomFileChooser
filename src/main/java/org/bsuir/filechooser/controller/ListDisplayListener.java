package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ChooseFilePanel;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;
import org.bsuir.filechooser.view.ListDisplayPanel;

import javax.swing.*;

public class ListDisplayListener extends ModeListener {
    public ListDisplayListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, changeConsist, chooseFilePanel);
    }

    protected void changeMode() {
        consistDirectoryPanel.setDisplayPanel(new ListDisplayPanel(consistDirectoryPanel,
                consistDirectoryPanel.getCurrentDirectory(), chooseFilePanel));
    }
}