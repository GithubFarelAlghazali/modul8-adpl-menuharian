/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view;

import com.mycompany.modul8.model.MenuModel;

/**
 *
 * @author User
 */
public class TableMenuRow {

    private final int no;
    private final MenuModel menu;

    public TableMenuRow(int no, MenuModel menu) {
        this.no = no;
        this.menu = menu;
    }

    public Object[] toArray() {
        return new Object[]{no, menu.getMenu(), menu.getTujuan(), ""};
    }
}
