package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.util.ChooserConst;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToPreviousListener implements ActionListener {
    private final ConsistDirectoryPanel consistDirectoryPanel;

    public GoToPreviousListener(ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = consistDirectoryPanel.getCurrentDirectory();
        if (!name.equals(ChooserConst.NAME_TREE_ROOT)) {
            StringBuilder newName = new StringBuilder();
            int count = name.length();
            int stop = -1;
            for (int i = count - 1; i >= 0; i--) {
                if (name.charAt(i) == '\\') {
                    stop = i;
                    break;
                }
            }
            for (int j = 0; j < stop; j++) {
                newName.append(name.charAt(j));
            }
            if (!newName.toString().contains("\\") && name.charAt(name.length() - 1) == '\\') {
                newName = new StringBuilder(ChooserConst.NAME_TREE_ROOT);
            } else if (!newName.toString().contains("\\")) {
                newName.append('\\');
            }
            consistDirectoryPanel.setCurrentDirectory(newName.toString());
        }
    }
}
