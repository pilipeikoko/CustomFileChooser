package org.bsuir.filechooser.model;

import org.bsuir.filechooser.tree.NodeDirectoryTree;
import org.bsuir.filechooser.util.ChooserConst;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class DirectoryTreeModel implements TreeModel {

    private final NodeDirectoryTree rootTree;

    public DirectoryTreeModel() {
        rootTree = new NodeDirectoryTree(ChooserConst.NAME_TREE_ROOT);
    }

    @Override
    public Object getRoot() {
        return rootTree;
    }

    @Override
    public Object getChild(Object parent, int index) {
        NodeDirectoryTree parentTrue = (NodeDirectoryTree) parent;
        return parentTrue.getChild(index);
    }

    @Override
    public int getChildCount(Object parent) {
        NodeDirectoryTree parentTrue = (NodeDirectoryTree) parent;
        return parentTrue.getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        NodeDirectoryTree parentTrue = (NodeDirectoryTree) node;
        return parentTrue.isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        NodeDirectoryTree parentTrue = (NodeDirectoryTree) parent;
        return parentTrue.getIndexOfChild(child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}