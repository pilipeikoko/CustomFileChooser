package org.bsuir.filechooser.view;

import org.bsuir.filechooser.util.ChooserConst;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public abstract class DisplayPanel extends JPanel {

    protected File[] listOfFiles;
    protected ConsistDirectoryPanel consistDirectoryPanel;
    protected ChooseFilePanel chooseFilePanel;

    public DisplayPanel(ConsistDirectoryPanel consistDirectoryPanel, String directoryName, ChooseFilePanel chooseFilePanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.chooseFilePanel = chooseFilePanel;
        setLayout(new BorderLayout());
        setProperty();
        setConsist(directoryName);
    }

    public abstract void changedConsist();

    public abstract void setProperty();

    public void setConsist(String directoryName) {
        if (directoryName.equals(ChooserConst.NAME_TREE_ROOT)) {
            listOfFiles = File.listRoots();
        } else {
            File folder = new File(directoryName);
            listOfFiles = folder.listFiles();
        }

        listOfFiles = sortFile(listOfFiles);
        changedConsist();
    }

    protected File[] sortFile(File[] oldList) {
        File[] bufferList = new File[oldList.length];
        int index = 0;
        for (File file : oldList) {
            if (file.isDirectory()) {
                bufferList[index] = file;
                index++;
            }
        }

        for (File file : oldList) {
            if (file.isFile() && chooseFilePanel.checkFile(file.getAbsolutePath())) {
                bufferList[index] = file;
                index++;
            }
        }

        File[] newList = new File[index];
        if (index >= 0) System.arraycopy(bufferList, 0, newList, 0, index);
        return newList;
    }
}
