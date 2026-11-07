/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.model;

import com.mycompany.modul8.repo.*;
import java.util.*;

/**
 *
 * @author User
 */
public class MenuManager {

    private final QueryWrite<MenuModel> addMenu;
    private final QueryRead<Void, List<MenuModel>> getAllMenu;
    private final QueryWrite<Integer> deleteMenu;
    private final QueryRead<Integer, MenuModel> getAMenu;

    public MenuManager(QueryWrite<MenuModel> addMenu,
            QueryRead<Void, List<MenuModel>> getAllMenu,
            QueryWrite<Integer> deleteMenu, QueryRead<Integer, MenuModel> getAMenu) {
        this.addMenu = addMenu;
        this.getAllMenu = getAllMenu;
        this.deleteMenu = deleteMenu;
        this.getAMenu = getAMenu;
    }

    public void tambahMenu(String menu, String tujuan) {
        if (menu == null || menu.isBlank()) {
            throw new IllegalArgumentException("Nama menu tidak boleh kosong!");
        }
        if (tujuan == null || tujuan.isBlank()) {
            throw new IllegalArgumentException("Nama tujuan tidak boleh kosong!");
        }
        addMenu.query(new MenuModel(menu.trim(), tujuan.trim()));
    }

    public void hapusMenu(int id) {
        deleteMenu.query(id);
    }

    public MenuModel ambilSatuMenu(int id) {
        return this.getAMenu.query(id);
    }

    public List<MenuModel> ambilMenu() {
        return this.getAllMenu.query(null);
    }
}
