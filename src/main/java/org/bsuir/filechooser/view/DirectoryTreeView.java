package org.bsuir.filechooser.view;

import org.bsuir.filechooser.model.DirectoryTreeModel;

import javax.swing.*;

public class DirectoryTreeView extends JTree {
    private final DirectoryTreeModel directoryTreeModel;

    public DirectoryTreeView(DirectoryTreeModel directoryTreeModel) {
        super(directoryTreeModel);
        this.directoryTreeModel = directoryTreeModel;
    }
}