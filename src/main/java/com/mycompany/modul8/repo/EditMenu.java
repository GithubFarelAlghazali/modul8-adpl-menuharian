/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.repo;

import com.mycompany.modul8.config.ConnectionProvider;
import com.mycompany.modul8.model.MenuModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class EditMenu extends BaseMenuRepo implements QueryWrite<MenuModel> {

    public EditMenu(ConnectionProvider db) {
        super(db);
    }

    @Override
    public void query(MenuModel menu) {
        String sql = "UPDATE tabel_menu SET menu = ? , tujuan = ? WHERE id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, menu.getMenu());
            ps.setString(2, menu.getTujuan());
            ps.setInt(3, menu.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengedit data menu : " + e.getMessage());
        }
    }
}
