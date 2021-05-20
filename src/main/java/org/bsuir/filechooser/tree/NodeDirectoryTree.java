package org.bsuir.filechooser.tree;

import org.bsuir.filechooser.util.ChooserConst;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NodeDirectoryTree {
    private final String fullDirectoryPath;

    private List<NodeDirectoryTree> listOfChilds;
    private boolean isListOfChildsCreated;

    public NodeDirectoryTree(String fullPath) {
        this.fullDirectoryPath = fullPath;
    }

    public String getFullDirectoryPath() {
        return fullDirectoryPath;
    }

    @Override
    public String toString() {
        StringBuilder name = new StringBuilder();

        int length = fullDirectoryPath.length();

        for (int i = length - 1; i >= 0; i--) {
            if (fullDirectoryPath.charAt(i) == '/' && i != length - 1) {
                break;
            }
            name.insert(0, fullDirectoryPath.charAt(i));
        }
        return name.toString();
    }

    public Object getChild(int index) {
        if (!isListOfChildsCreated) {
            createListOfChilds();
        }
        return listOfChilds.get(index);
    }

    public int getChildCount() {
        if (!isListOfChildsCreated) {
            createListOfChilds();
        }
        return listOfChilds.size();
    }

    public boolean isLeaf() {
        File f = new File(fullDirectoryPath);
        return f.isFile();
    }

    public int getIndexOfChild(Object node) {
        if (!isListOfChildsCreated) {
            createListOfChilds();
        }
        NodeDirectoryTree child = (NodeDirectoryTree) node;
        return listOfChilds.indexOf(child);
    }

    private void createListOfChilds() {
        isListOfChildsCreated = true;

        listOfChilds = new ArrayList<>();
        File[] listOfFiles;
        if (fullDirectoryPath.equals(ChooserConst.NAME_TREE_ROOT)) {
            listOfFiles = File.listRoots();
        } else {
            File folder = new File(fullDirectoryPath);
            listOfFiles = folder.listFiles();
        }

        assert listOfFiles != null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isDirectory()) {
                if (fullDirectoryPath.equals(ChooserConst.NAME_TREE_ROOT)) {
                    StringBuilder name = new StringBuilder();
                    String absolutePath = listOfFile.getAbsolutePath();

                    int lengthOfPath = absolutePath.length();
                    for (int j = 0; j < lengthOfPath - 1; j++) {
                        name.append(absolutePath.charAt(j));
                    }
                    listOfChilds.add(new NodeDirectoryTree("/" + name + "/"));
                } else {
                    listOfChilds.add(new NodeDirectoryTree(fullDirectoryPath + "/" + listOfFile.getName()));
                }
            }
        }
    }
}