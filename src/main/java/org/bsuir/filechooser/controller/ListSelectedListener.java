package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class ListSelectedListener implements ListSelectionListener, MouseListener {
    private final JList listVisibly;
    private final ConsistDirectoryPanel consistDirectoryPanel;

    public ListSelectedListener(JList listVisibly, ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.listVisibly = listVisibly;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String name = (String) listVisibly.getSelectedValue();
        if (name != null) {
            File file = new File(name);
            if (file.isDirectory()) {
                consistDirectoryPanel.setCurrentDirectory(name);
            } else {
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile(file.getName());
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String name = (String) listVisibly.getSelectedValue();
        if (name != null) {
            File file = new File(name);
            if (file.isDirectory() && e.getClickCount() == 2) {
                consistDirectoryPanel.setCurrentDirectory(name);
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile("");
            } else if (file.isFile()) {
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile(file.getName());
            } else {
                consistDirectoryPanel.getChooseFilePanel().changeSelectedFile("");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
