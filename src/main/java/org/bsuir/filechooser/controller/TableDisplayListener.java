package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ChooseFilePanel;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;
import org.bsuir.filechooser.view.TableDisplayPanel;

import javax.swing.*;

public class TableDisplayListener extends ModeListener {
    public TableDisplayListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, changeConsist, chooseFilePanel);
    }

    protected void changeMode() {
        TableDisplayPanel newTable = new TableDisplayPanel(consistDirectoryPanel,
                consistDirectoryPanel.getCurrentDirectory(), chooseFilePanel);
        consistDirectoryPanel.setDisplayPanel(newTable);
    }
}