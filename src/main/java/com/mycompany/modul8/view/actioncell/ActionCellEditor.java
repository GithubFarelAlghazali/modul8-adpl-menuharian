/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view.actioncell;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author User
 */
public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {

    private final ActionCellPanel panel = new ActionCellPanel();
    private int row;

    public ActionCellEditor(RowActionListener listener) {
        panel.btnEdit.addActionListener(e -> {
            fireEditingStopped();      // akhiri mode edit sel dulu
            listener.onEdit(row);
        });
        panel.btnDelete.addActionListener(e -> {
            fireEditingStopped();
            listener.onDelete(row);
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.row = row;                // simpan baris mana yang sedang aktif
        panel.setBackground(table.getSelectionBackground());
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
