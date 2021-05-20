package org.bsuir.filechooser.entity;

import org.bsuir.filechooser.util.ChooserConst;
import org.bsuir.filechooser.view.CustomMenuBar;
import org.bsuir.filechooser.view.MainPanel;

import javax.swing.*;
import java.io.File;

public class FileChooser {
    private final String homeDirectory;

    private JDialog dialog;
    private File selectedFile;

    private boolean isSelected;
    private int mode;

    public FileChooser() {
        homeDirectory = ChooserConst.NAME_TREE_ROOT;
    }

    public FileChooser(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public void showOpenDialog(JFrame mainWindow) {
        setMode(ChooserConst.OPEN_MODE);
        createFileChooserDialog(mainWindow);
    }

    public void showSaveDialog(JFrame mainWindow) {
        setMode(ChooserConst.SAVE_MODE);
        createFileChooserDialog(mainWindow);
    }

    private void createFileChooserDialog(JFrame mainWindow) {
        setSelectedFile(null);
        isFileSelected(false);
        dialog = new JDialog(mainWindow, "Choose a file", true);
        dialog.setSize(750, 500);
        dialog.setLocationRelativeTo(null);
        MainPanel mainPanel = new MainPanel(homeDirectory, this);
        dialog.add(mainPanel);
        dialog.setJMenuBar(new CustomMenuBar(mainPanel.getConsistDirectoryPanel(),mainPanel.getChangeConsist(),mainPanel.getChooseFilePanel()));

        dialog.setVisible(true);
    }

    public void closeDialog() {
        dialog.dispose();
        dialog = null;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void isFileSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
