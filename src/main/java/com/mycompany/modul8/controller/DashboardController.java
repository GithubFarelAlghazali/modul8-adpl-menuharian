/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.controller;

import com.mycompany.modul8.view.MenuDashboardView;
import com.mycompany.modul8.model.MenuManager;
import com.mycompany.modul8.model.MenuModel;
import com.mycompany.modul8.view.FormAddMenu;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DashboardController {

    private final MenuDashboardView view;
    private final MenuManager manager;

    public DashboardController(MenuDashboardView view, MenuManager manager) {
        this.view = view;
        this.manager = manager;

        this.view.getHeader().getMenuBtn().addActionListener(e -> bukaFormMenu());
        muatTabel();
    }

    private void bukaFormMenu() {
        FormAddMenu form = new FormAddMenu(view);

        form.getBtnSave().addActionListener(e -> simpanMenu(form));
        form.getBtnCancel().addActionListener(e -> form.dispose());

        form.setVisible(true);
    }

    private void simpanMenu(FormAddMenu form) {
        try {
            manager.tambahMenu(form.getInMenu().getText(), form.getInTujuan().getText());
            form.dispose();
            muatTabel();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Input tidak valid!", JOptionPane.WARNING_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void muatTabel() {
        try {
            tampilkan(manager.ambilMenu());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Gagal memuat data", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkan(List<MenuModel> daftar) {
        DefaultTableModel model = view.getMenuTable().getModelTabel();
        model.setRowCount(0);
        int no = 1;
        for (MenuModel m : daftar) {
            model.addRow(new Object[]{no++, m.getMenu(), m.getTujuan()});
        }
    }
}
