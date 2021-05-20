package org.bsuir.filechooser.view;

import org.bsuir.filechooser.entity.FileChooser;

import javax.swing.*;

public class MainPanel extends JPanel {
    private ChooseFilePanel chooseFilePanel;
    private DirectoryTreePanel directoryTreePanel;
    private ConsistDirectoryPanel consistDirectoryPanel;

    public MainPanel(String homeDirectory, FileChooser fileChooser) {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        chooseFilePanel = new ChooseFilePanel(fileChooser);
        consistDirectoryPanel = new ConsistDirectoryPanel(homeDirectory, chooseFilePanel);
        directoryTreePanel = new DirectoryTreePanel(consistDirectoryPanel);

        chooseFilePanel.setConsistDirectoryPanel(consistDirectoryPanel);

        //do not hardcode.
        directoryTreePanel.setBounds(0, 0, 200, 400);
        consistDirectoryPanel.setBounds(200, 0, 500, 400);
        chooseFilePanel.setBounds(0, 400, 700, 100);

        layout.setHorizontalGroup(layout.createParallelGroup().
                addGroup(layout.createSequentialGroup()
                        .addComponent(directoryTreePanel)
                        .addComponent(consistDirectoryPanel))
                .addComponent(chooseFilePanel)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(directoryTreePanel)
                        .addComponent(consistDirectoryPanel))
                .addComponent(chooseFilePanel)
        );
    }

    public ChooseFilePanel getChooseFilePanel() {
        return chooseFilePanel;
    }

    public void setChooseFilePanel(ChooseFilePanel chooseFilePanel) {
        this.chooseFilePanel = chooseFilePanel;
    }

    public DirectoryTreePanel getTreeDirectoryPanel() {
        return directoryTreePanel;
    }

    public void setTreeDirectoryPanel(DirectoryTreePanel directoryTreePanel) {
        this.directoryTreePanel = directoryTreePanel;
    }

    public ConsistDirectoryPanel getConsistDirectoryPanel() {
        return consistDirectoryPanel;
    }

    public void setConsistDirectoryPanel(ConsistDirectoryPanel consistDirectoryPanel) {
        this.consistDirectoryPanel = consistDirectoryPanel;
    }

    public JToolBar getChangeConsist(){
        return consistDirectoryPanel.getChangeConsist();
    }

}
