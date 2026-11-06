/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.modul8;

import com.mycompany.modul8.config.Database;
import com.mycompany.modul8.controller.DashboardController;
import com.mycompany.modul8.model.MenuManager;
import com.mycompany.modul8.model.MenuModel;
import com.mycompany.modul8.repo.AddMenu;
import com.mycompany.modul8.repo.GetAllMenu;
import com.mycompany.modul8.repo.QueryRead;
import com.mycompany.modul8.repo.QueryWrite;
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
            QueryRead<Void, List<MenuModel>> getAllMenu = new GetAllMenu(db);

            MenuManager manager = new MenuManager(addMenu, getAllMenu);
            MenuDashboardView view = new MenuDashboardView();
            new DashboardController(view, manager);

            view.setVisible(true);
        });
    }
}
