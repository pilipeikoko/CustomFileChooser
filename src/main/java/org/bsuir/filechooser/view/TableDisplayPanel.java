package org.bsuir.filechooser.view;


import org.bsuir.filechooser.model.CustomTableModel;
import org.bsuir.filechooser.controller.TableSelectedListener;

import javax.swing.*;
import java.awt.*;

public class TableDisplayPanel extends DisplayPanel {
    private JTable table;

    public TableDisplayPanel(ConsistDirectoryPanel consistDirectoryPanel, String directoryName, ChooseFilePanel chooseFilePanel) {
        super(consistDirectoryPanel, directoryName, chooseFilePanel);
    }

    public void changedConsist() {
        table.setModel(new CustomTableModel(listOfFiles));
    }

    public void setProperty() {
        table = new JTable();
        table.addMouseListener(new TableSelectedListener(table, consistDirectoryPanel));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(getWidth(), getHeight()));
        add(scroll, BorderLayout.CENTER);
    }
}
