/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MenuDashboardView extends JFrame {

    private DashboardHeader header;
    private MenuTable tabel;
    private FormAddMenu form;

    public MenuDashboardView() {
        SwingUtilities.invokeLater(() -> {
            setTitle("Menu Dashboard");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);
            setLayout(new BorderLayout());

            header = new DashboardHeader();
            tabel = new MenuTable();
            form = new FormAddMenu(this);

            add(tabel, BorderLayout.CENTER);
            add(header, BorderLayout.NORTH);

            header.getMenuBtn().addActionListener(e -> form.setVisible(true));

            setVisible(true);
        });

    }

    public DashboardHeader getHeader() {
        return this.header;
    }

    public MenuTable getMenuTable() {
        return this.tabel;
    }
}
