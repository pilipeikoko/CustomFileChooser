package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.entity.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogCancelListener implements ActionListener {
    private final FileChooser fileChooser;

    public DialogCancelListener(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileChooser.setSelectedFile(null);
        fileChooser.isFileSelected(false);
        fileChooser.closeDialog();
    }
}
