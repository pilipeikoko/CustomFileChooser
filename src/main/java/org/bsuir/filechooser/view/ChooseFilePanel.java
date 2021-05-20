package org.bsuir.filechooser.view;

import org.bsuir.filechooser.controller.FileFilterListener;
import org.bsuir.filechooser.entity.FileChooser;
import org.bsuir.filechooser.controller.DialogCancelListener;
import org.bsuir.filechooser.util.ChooserConst;
import org.bsuir.filechooser.controller.EnterListener;

import javax.swing.*;
import java.awt.*;

public class ChooseFilePanel extends JPanel {
    private final JTextField enterFileName;
    private ConsistDirectoryPanel consistDirectoryPanel;
    private final JComboBox<String> fileFilter;
    private final FileChooser fileChooser;

    public ChooseFilePanel(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
        setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        JLabel fileName = new JLabel("File:");

        enterFileName = new JTextField("", 30);
        fileFilter = new JComboBox<>(ChooserConst.FILTER);

        JButton enterButton = new JButton("Approve");
        enterButton.addActionListener(new EnterListener(fileChooser, this));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new DialogCancelListener(fileChooser));

        enterButton.setBorder(new RoundedBorder(5));
        cancelButton.setBorder(new RoundedBorder(5));

        enterButton.setBackground(Color.white);
        enterButton.setForeground(Color.black);

        cancelButton.setBackground(Color.white);
        cancelButton.setForeground(Color.black);

        add(enterButton);
        add(cancelButton);
        add(fileFilter);
        add(fileName);
        add(enterFileName);
    }

    public String getSelectedFile() {
        return enterFileName.getText();
    }

    public void changeSelectedFile(String name) {
        enterFileName.setText(name);
    }

    public ConsistDirectoryPanel getConsistDirectoryPanel() {
        return consistDirectoryPanel;
    }

    public void setConsistDirectoryPanel(ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
        fileFilter.addActionListener(new FileFilterListener(consistDirectoryPanel, enterFileName));
    }

    public boolean checkFile(String name) {
        int count = ChooserConst.FILTER.length;
        String selected = (String) fileFilter.getSelectedItem();
        if ("ALL".equals(selected)) {
            return true;
        }
        for (int i = 0; i < count; i++) {
            if (ChooserConst.FILTER[i].equals(selected)) {
                if (name.contains(ChooserConst.EXTENSION[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    public String getFormat() {
        int count = ChooserConst.FILTER.length;
        String selected = (String) fileFilter.getSelectedItem();
        if (selected.equals("ALL")) {
            return "";
        }
        for (int i = 0; i < count; i++) {
            if (selected.equals(ChooserConst.FILTER[i])) {
                return ChooserConst.EXTENSION[i];
            }
        }

        return "";
    }
}