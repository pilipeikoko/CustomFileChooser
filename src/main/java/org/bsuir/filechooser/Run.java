package org.bsuir.filechooser;

import org.bsuir.filechooser.entity.FileChooser;

import javax.swing.*;
public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                //todo or show open dialog
                new FileChooser().showSaveDialog(null);
            }
        });
    }
}
