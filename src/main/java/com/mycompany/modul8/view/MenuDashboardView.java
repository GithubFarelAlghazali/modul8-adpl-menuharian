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
public class MenuDashboardView {

    public MenuDashboardView() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new FlowLayout());

            // header halaman
            JLabel titel = new JLabel("Dahboard Menu Harian");
            JButton addMenu = new JButton("Tambah Jadwal Menu");

            // tabel
            DefaultTableModel modelTabel = new DefaultTableModel(new String[]{"No", "Menu", "Tujuan"}, 0);
            JTable tabelMenu = new JTable(modelTabel);
            JScrollPane kotakTabel = new JScrollPane(tabelMenu);

            // dialog form tambah menu
            JDialog formTambahMenu = new JDialog(frame, "Tambah Jadwal Menu", true);
            formTambahMenu.setSize(250, 100);
            formTambahMenu.setLocationRelativeTo(frame);
            formTambahMenu.setVisible(false);

            // klik button buat nampilin form
            addMenu.addActionListener(e -> formTambahMenu.setVisible(true));

            frame.add(titel);
            frame.add(addMenu);
            frame.add(kotakTabel);
            frame.setVisible(true);
        });
    }
}
