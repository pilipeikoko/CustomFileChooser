package org.bsuir.filechooser.model;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.text.SimpleDateFormat;

public class CustomTableModel extends AbstractTableModel {

    private final File[] files;

    public CustomTableModel(File[] newFiles) {
        files = newFiles;
    }

    @Override
    public int getRowCount() {
        return files.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            if (files[rowIndex].getName().equals("")) {
                return files[rowIndex].getAbsolutePath();
            } else {
                if (files[rowIndex].isDirectory()) {
                    return files[rowIndex].getName();
                } else {
                    String name = files[rowIndex].getName();

                    int left = -1;
                    int count = name.length();

                    for (int i = 0; i < count; i++) {
                        if (name.charAt(i) == '.') {
                            left = i;
                            break;
                        }
                    }
                    if (left == -1) {
                        return name;
                    }

                    StringBuilder newName = new StringBuilder();
                    for (int i = 0; i < left; i++) {
                        newName.append(name.charAt(i));
                    }

                    return newName.toString();
                }

            }
        } else if (columnIndex == 1) {
            if (files[rowIndex].isDirectory()) {
                return "";
            } else {
                String name = files[rowIndex].getName();
                int left = -1, count = name.length();
                for (int i = 0; i < count; i++) {
                    if (name.charAt(i) == '.') {
                        left = i;
                        break;
                    }
                }
                if (left == -1) {
                    return "Unknown file";
                }

                String newName = "";
                for (int i = left + 1; i < count; i++) {
                    newName = newName + name.charAt(i);
                }
                newName += "File";
                return newName;
            }
        } else if (columnIndex == 2) {
            if (files[rowIndex].isDirectory()) {
                return "<Folder>";
            } else {
                String name = Integer.toString((int) files[rowIndex].length());
                return name + "Byte";
            }
        } else {
            long time = files[rowIndex].lastModified();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.format(time);
        }
    }

    @Override
    public String getColumnName(int column) {
        final String[] columnName = {
                "имя",
                "тип",
                "размер",
                "дата изменения",
        };
        return columnName[column];
    }

    public File getFileByIndex(int index) {
        return files[index];
    }
}
