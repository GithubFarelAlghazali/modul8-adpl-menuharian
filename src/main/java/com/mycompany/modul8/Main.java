/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.modul8;

import com.mycompany.modul8.config.Database;
import com.mycompany.modul8.controller.DashboardController;
import com.mycompany.modul8.model.MenuManager;
import com.mycompany.modul8.model.MenuModel;
import com.mycompany.modul8.repo.*;
import com.mycompany.modul8.view.MenuDashboardView;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Database db = new Database();

            QueryWrite<MenuModel> addMenu = new AddMenu(db);
            QueryWrite<MenuModel> editMenu = new EditMenu(db);
            QueryRead<Void, List<MenuModel>> getAllMenu = new GetAllMenu(db);
            QueryWrite<Integer> deleteMenu = new DeleteMenu(db);
            QueryRead<Integer, MenuModel> getAMenu = new GetAMenu(db);

            MenuManager manager = new MenuManager(addMenu, getAllMenu, deleteMenu, getAMenu, editMenu);
            MenuDashboardView view = new MenuDashboardView();
            new DashboardController(view, manager);

            view.setVisible(true);
        });
    }
}
