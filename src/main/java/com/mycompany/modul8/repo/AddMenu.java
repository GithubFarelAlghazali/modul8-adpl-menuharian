/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.repo;

import com.mycompany.modul8.config.ConnectionProvider;
import com.mycompany.modul8.model.MenuModel;
import java.sql.*;

/**
 *
 * @author User
 */
public class AddMenu extends BaseMenuRepo implements QueryWrite<MenuModel> {

    public AddMenu(ConnectionProvider db) {
        super(db);
    }

    @Override
    public void query(MenuModel menu) {
        String sql = "INSERT INTO tabel_menu (menu, tujuan) VALUES (?,?)";

        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, menu.getMenu());
            ps.setString(2, menu.getTujuan());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal menambah data menu : " + e.getMessage());
        }
    }
}
