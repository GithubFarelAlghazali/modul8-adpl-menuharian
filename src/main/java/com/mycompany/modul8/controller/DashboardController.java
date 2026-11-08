/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.controller;

import com.mycompany.modul8.view.MenuDashboardView;
import com.mycompany.modul8.model.MenuManager;
import com.mycompany.modul8.model.MenuModel;
import com.mycompany.modul8.view.form.FormAddMenu;
import com.mycompany.modul8.view.actioncell.RowActionListener;
import com.mycompany.modul8.view.form.FormBase;
import com.mycompany.modul8.view.form.FormEditMenu;
import java.util.ArrayList;
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
    private List<MenuModel> latestList = new ArrayList<>();

    public DashboardController(MenuDashboardView view, MenuManager manager) {
        this.view = view;
        this.manager = manager;

        this.view.getMenuTable().setRowActionListener(new RowActionListener() {
            @Override
            public void onEdit(int row) {
                MenuModel selected = latestList.get(row);
                editMenu(selected);
            }

            @Override
            public void onDelete(int row) {
                MenuModel selected = latestList.get(row);
                deleteMenu(selected);
            }

        });

        this.view.getHeader().getMenuBtn().addActionListener(e -> formTambah());
        muatTabel();
    }

    private void formTambah() {
        FormAddMenu form = new FormAddMenu(view);
        tampilkanForm(form, () -> {
            manager.tambahMenu(form.getInMenu().getText(), form.getInTujuan().getText());
        });
    }

    private void tampilkanForm(FormBase form, Runnable aksiSimpan) {
        form.getBtnSave().addActionListener(e -> simpanMenu(form, aksiSimpan));
        form.getBtnCancel().addActionListener(e -> form.dispose());
        form.setVisible(true);

    }

    private void simpanMenu(FormBase form, Runnable aksiSimpan) {
        try {
            aksiSimpan.run();
            form.dispose();
            muatTabel();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Input tidak valid!", JOptionPane.WARNING_MESSAGE);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Terjadi kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editMenu(MenuModel selected) {
        FormEditMenu form = new FormEditMenu(view, selected);

        tampilkanForm(form, () -> {
            manager.ubahMenu(selected.getId(), form.getInMenu().getText(), form.getInTujuan().getText());
        });

    }

    private void deleteMenu(MenuModel row) {
        int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus " + row.getMenu() + " dengan tujuan " + row.getTujuan() + " ?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                manager.hapusMenu(row.getId());
                muatTabel();
                JOptionPane.showMessageDialog(view, "Menu berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(view, e.getMessage(), "Terjadi kesalahan saat menghapus menu", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void muatTabel() {
        try {
            latestList = manager.ambilMenu();
            view.getMenuTable().tampilkan(latestList);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Gagal memuat data", JOptionPane.ERROR_MESSAGE);
        }
    }

}
