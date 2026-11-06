/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author User
 */
public class MenuTable extends JPanel {

    private JTable tabelMenu;
    private JScrollPane kotakTabel;
    private DefaultTableModel modelTabel;
    private String[] columNames = {"No", "Menu", "Tujuan", "Aksi"};

    public MenuTable() {
        setLayout(new BorderLayout());
        modelTabel = new DefaultTableModel(null, columNames) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 4;
            }

            public Class<?> GetColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Object.class;
                }
                return String.class;
            }
        };
        tabelMenu = new JTable(modelTabel);
        kotakTabel = new JScrollPane(tabelMenu);
        add(kotakTabel, BorderLayout.CENTER);
    }

    public DefaultTableModel getModelTabel() {
        return modelTabel;
    }
}
