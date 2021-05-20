package org.bsuir.filechooser.view;

import org.bsuir.filechooser.model.DirectoryTreeModel;
import org.bsuir.filechooser.controller.DirectorySelectedListener;

import javax.swing.*;
import java.awt.*;

public class DirectoryTreePanel extends JPanel {

    private final DirectoryTreeView directoryTreeView;

    public DirectoryTreePanel(ConsistDirectoryPanel consistDirectoryPanel) {
        directoryTreeView = new DirectoryTreeView(new DirectoryTreeModel());
        directoryTreeView.addTreeSelectionListener(new DirectorySelectedListener(consistDirectoryPanel));

        setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JScrollPane scrollPane = new JScrollPane(directoryTreeView);
        scrollPane.setPreferredSize(new Dimension(150, 400));

        add(scrollPane, BorderLayout.CENTER);
    }

    public DirectoryTreeView getDirectoryTreeView() {
        return directoryTreeView;
    }
}