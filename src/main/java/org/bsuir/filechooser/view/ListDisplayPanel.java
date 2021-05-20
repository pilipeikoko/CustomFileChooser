package org.bsuir.filechooser.view;

import org.bsuir.filechooser.controller.ListSelectedListener;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

public class ListDisplayPanel extends DisplayPanel {
    DefaultListModel<String> listModel;

    public ListDisplayPanel(ConsistDirectoryPanel consistDirectoryPanel, String directoryName, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, directoryName, chooseFilePanel);
    }

    public void changedConsist() {
        listModel.clear();
        int count = listOfFiles.length;
        for (File listOfFile : listOfFiles) {
            String name;
            if (listOfFile.getName().equals("")) {
                name = listOfFile.getAbsolutePath();
            } else {
                name = listOfFile.getAbsolutePath();
            }
            listModel.addElement(name);
        }
    }

    public void setProperty() {
        listModel = new DefaultListModel<>();
        JList<String> listVisibly = new JList<>(listModel);
        listVisibly.setVisibleRowCount(19);
        listVisibly.setLayoutOrientation(JList.VERTICAL_WRAP);
        listVisibly.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listVisibly.setCellRenderer(new CustomCellRenderer());
        listVisibly.addMouseListener(new ListSelectedListener(listVisibly, consistDirectoryPanel));
        //listVisibly.addListSelectionListener(new ListSelectedListener(listVisibly,consistDirectoryPanel));
        JScrollPane scroll = new JScrollPane(listVisibly);
        scroll.setPreferredSize(new Dimension(getWidth(), getHeight()));
        add(scroll, BorderLayout.CENTER);
    }

    private static class CustomCellRenderer extends JLabel implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof String) {
                String name = (String) value;
                File file = new File(name);
                if (file.getName().equals("")) {
                    name = file.getAbsolutePath();
                } else {
                    name = file.getName();
                }
                setText(name);
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(Color.lightGray);
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setFont(list.getFont());
                setOpaque(true);
            }
            return this;
        }
    }
}
