package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.view.ChooseFilePanel;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ModeListener implements ActionListener {
    protected ConsistDirectoryPanel consistDirectoryPanel;
    protected JToolBar changeConsist;
    protected ChooseFilePanel chooseFilePanel;

    protected ModeListener(ConsistDirectoryPanel consistDirectoryPanel, JToolBar changeConsist, ChooseFilePanel chooseFilePanel) {
        this.changeConsist = changeConsist;
        this.consistDirectoryPanel = consistDirectoryPanel;
        this.chooseFilePanel = chooseFilePanel;
    }

    protected void changeMode() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton currentButton;
        int count = changeConsist.getComponentCount();
        for (int i = 0; i < count; i++) {
            if (changeConsist.getComponentAtIndex(i) instanceof JToggleButton) {
                currentButton = (JToggleButton) changeConsist.getComponentAtIndex(i);
                if (e.getActionCommand().equals(currentButton.getActionCommand())) {
                    currentButton.setSelected(true);
                } else {
                    currentButton.setSelected(false);
                }
            }
        }
        changeMode();
    }
}