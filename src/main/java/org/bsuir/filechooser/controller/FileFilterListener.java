package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileFilterListener implements ActionListener {
    private final ConsistDirectoryPanel consistDirectoryPanel;
    private final JTextField enterFileName;

    public FileFilterListener(final ConsistDirectoryPanel consistDirectoryPanel, final JTextField enterFileName){
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.enterFileName = enterFileName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        consistDirectoryPanel.changeConsist();
        enterFileName.setText("");
    }
}
