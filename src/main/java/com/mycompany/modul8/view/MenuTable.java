/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view;

import com.mycompany.modul8.model.MenuModel;
import com.mycompany.modul8.view.actioncell.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author User
 */
public class MenuTable extends JPanel {

    private JTable tabelMenu;
    private JScrollPane kotakTabel;
    private DefaultTableModel modelTabel;
    private String[] columNames = {"No", "Menu", "Tujuan", "Aksi"};
    private int editCol = 3;

    public MenuTable() {
        setLayout(new BorderLayout());
        modelTabel = new DefaultTableModel(null, columNames) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == editCol;
            }

        };
        tabelMenu = new JTable(modelTabel);
        tabelMenu.setRowHeight(32);
        tabelMenu.getColumnModel().getColumn(0).setMaxWidth(50);
        tabelMenu.getColumnModel().getColumn(editCol).setPreferredWidth(160);
        tabelMenu.getColumnModel().getColumn(editCol).setCellRenderer(new ActionCellRenderer());

        kotakTabel = new JScrollPane(tabelMenu);
        add(kotakTabel, BorderLayout.CENTER);
    }

    public void setRowActionListener(RowActionListener listener) {
        tabelMenu.getColumnModel().getColumn(editCol).setCellEditor(new ActionCellEditor(listener));
    }

    public void tampilkan(List<MenuModel> menus) {
        modelTabel.setRowCount(0);
        int no = 1;
        for (MenuModel m : menus) {
            modelTabel.addRow(new TableMenuRow(no++, m).toArray());
        }
    }

    public DefaultTableModel getModelTabel() {
        return modelTabel;
    }

}
