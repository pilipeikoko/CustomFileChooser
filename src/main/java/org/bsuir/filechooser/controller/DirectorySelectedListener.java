package org.bsuir.filechooser.controller;

import org.bsuir.filechooser.tree.NodeDirectoryTree;
import org.bsuir.filechooser.view.ConsistDirectoryPanel;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class DirectorySelectedListener implements TreeSelectionListener {
    private final ConsistDirectoryPanel consistDirectoryPanel;

    public DirectorySelectedListener(ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        NodeDirectoryTree node = (NodeDirectoryTree) e.getPath().getLastPathComponent();
        consistDirectoryPanel.setCurrentDirectory(node.getFullDirectoryPath());
    }
}