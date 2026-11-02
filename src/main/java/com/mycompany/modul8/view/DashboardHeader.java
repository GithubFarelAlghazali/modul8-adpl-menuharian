/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author User
 */
public class DashboardHeader extends JPanel {

    private JLabel titel;
    private JButton addMenuBtn;

    public DashboardHeader() {
        setLayout(new BorderLayout());

        titel = new JLabel("Dahboard Menu Harian");
        addMenuBtn = new JButton("Tambah Jadwal Menu");

        add(titel, BorderLayout.WEST);
        add(addMenuBtn, BorderLayout.EAST);
    }

    public JButton getMenuBtn() {
        return this.addMenuBtn;
    }
}
