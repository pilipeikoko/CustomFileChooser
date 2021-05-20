package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.model.CustomTableModel;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class TableSelectedListener implements MouseListener {
    private final JTable tableFile;
    private final ConsistDirectoryPanel consistDirectoryPanel;

    public TableSelectedListener(JTable tableFile, ConsistDirectoryPanel consistDirectoryPanel) {
        this.tableFile = tableFile;
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int indexRow = tableFile.getSelectedRow();
        if (indexRow != -1) {
            CustomTableModel tableModel = (CustomTableModel) tableFile.getModel();
            File file = tableModel.getFileByIndex(indexRow);
            if (file.isDirectory() && e.getClickCount() == 2) {
                consistDirectoryPanel.setCurrentDirectory(file.getAbsolutePath());
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