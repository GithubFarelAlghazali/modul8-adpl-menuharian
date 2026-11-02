/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.model;

/**
 *
 * @author User
 */
public class MenuModel {

    private String id;
    private String menu;
    private String tujuan;

    public MenuModel(String menu, String tujuan) {
        this.menu = menu;
        this.tujuan = tujuan;
    }

    public MenuModel(String id, String menu, String tujuan) {
        this.id = id;
        this.menu = menu;
        this.tujuan = tujuan;
    }

    public String getMenu() {
        return this.menu;
    }

    public String getTujuan() {
        return this.tujuan;
    }

    public void setMenu(String newMenu) {
        this.menu = newMenu;
    }

    public void setTujuan(String newTujuan) {
        this.tujuan = newTujuan;
    }
}
