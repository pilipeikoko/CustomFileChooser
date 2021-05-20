package org.bsuir.filechooser.view;

import org.bsuir.filechooser.controller.ListSelectedListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectoryDisplayPanel extends DisplayPanel {
    private DefaultListModel<String> listModel;

    public DirectoryDisplayPanel(ConsistDirectoryPanel consistDirectoryPanel, String directoryName, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, directoryName, chooseFilePanel);
    }

    public void changedConsist() {
        listModel.clear();
        int count = listOfFiles.length;
        for (File listOfFile : listOfFiles) {
            String name = listOfFile.getAbsolutePath();
            listModel.addElement(name);
        }
    }

    public void setProperty() {
        listModel = new DefaultListModel<>();
        JList<String> listVisibly = new JList<>(listModel);
        listVisibly.setVisibleRowCount(11);
        listVisibly.setLayoutOrientation(JList.VERTICAL_WRAP);
        listVisibly.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listVisibly.setCellRenderer(new DirectoryDisplayPanel.MyCellRenderer());
        listVisibly.addMouseListener(new ListSelectedListener(listVisibly, consistDirectoryPanel));
        JScrollPane scroll = new JScrollPane(listVisibly);
        scroll.setPreferredSize(new Dimension(getWidth(), getHeight()));
        add(scroll, BorderLayout.CENTER);
    }

    private static class MyCellRenderer extends JLabel implements ListCellRenderer {

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
                if (file.isDirectory()) {
                    setIcon(new ImageIcon(ClassLoader.getSystemResource("image/folder1.png").getPath()));
                } else {
                    setIcon(new ImageIcon(ClassLoader.getSystemResource("image/file.png").getPath()));
                }
                setText(name);

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