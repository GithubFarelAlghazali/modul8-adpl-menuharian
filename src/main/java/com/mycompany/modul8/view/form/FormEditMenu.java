/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view.form;

import com.mycompany.modul8.model.MenuModel;
import java.awt.Frame;

/**
 *
 * @author User
 */
public class FormEditMenu extends FormBase {

    public FormEditMenu(Frame owner, MenuModel menu) {
        super(owner, "Form Edit Menu", "Simpan Perubahan");
        getInMenu().setText(menu.getMenu());
        getInTujuan().setText(menu.getTujuan());
    }
}
