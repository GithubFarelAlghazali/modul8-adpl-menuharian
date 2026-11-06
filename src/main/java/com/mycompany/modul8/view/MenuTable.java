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

    public MenuTable() {
        setLayout(new BorderLayout());
        modelTabel = new DefaultTableModel(new String[]{"No", "Menu", "Tujuan"}, 0);
        tabelMenu = new JTable(modelTabel);
        kotakTabel = new JScrollPane(tabelMenu);
        add(kotakTabel, BorderLayout.CENTER);
    }

    public DefaultTableModel getModelTabel() {
        return modelTabel;
    }
}
