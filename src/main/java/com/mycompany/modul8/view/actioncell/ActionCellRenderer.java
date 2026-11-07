/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view.actioncell;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author User
 */
public class ActionCellRenderer implements TableCellRenderer {

    private final ActionCellPanel panel = new ActionCellPanel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
}
