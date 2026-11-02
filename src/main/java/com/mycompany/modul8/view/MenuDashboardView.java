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

    public MenuDashboardView() {
        SwingUtilities.invokeLater(() -> {
            setTitle("Menu Dashboard");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 400);
            setLayout(new BorderLayout());

            header = new DashboardHeader();
            tabel = new MenuTable();

            add(tabel, BorderLayout.CENTER);
            add(header, BorderLayout.NORTH);
            setVisible(true);
        });
    }
}
