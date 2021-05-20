package org.bsuir.filechooser.view;

import org.bsuir.filechooser.controller.DirectoryDisplayListener;
import org.bsuir.filechooser.controller.ListDisplayListener;
import org.bsuir.filechooser.controller.TableDisplayListener;

import javax.swing.*;

public class CustomMenuBar extends JMenuBar {
    private final JMenuItem toTable;
    private final JMenuItem toList;
    private final JMenuItem toDirectory;

    public CustomMenuBar(ConsistDirectoryPanel consistDirectoryPanel,JToolBar toolBar,ChooseFilePanel chooseFilePanel){
        JMenu menu = new JMenu("change type");
        toTable = new JMenuItem("to table");
        toList = new JMenuItem("to list");
        toDirectory = new JMenuItem("to directory");

        menu.add(toTable);
        menu.add(toList);
        menu.add(toDirectory);

        toTable.addActionListener(new TableDisplayListener(consistDirectoryPanel,toolBar,chooseFilePanel));
        toList.addActionListener(new ListDisplayListener(consistDirectoryPanel,toolBar,chooseFilePanel));
        toDirectory.addActionListener(new DirectoryDisplayListener(consistDirectoryPanel,toolBar,chooseFilePanel));

        add(menu);
    }

    public JMenuItem getToDirectory() {
        return toDirectory;
    }

    public JMenuItem getToList() {
        return toList;
    }

    public JMenuItem getToTable() {
        return toTable;
    }
}
