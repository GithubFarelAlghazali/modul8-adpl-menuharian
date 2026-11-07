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
public class DeleteMenu extends BaseMenuRepo implements QueryWrite<MenuModel> {

    public DeleteMenu(ConnectionProvider db) {
        super(db);
    }

    @Override
    public void query(MenuModel menu) {
        String sql = "DELETE FROM tabel_menu WHERE ID = ?";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, menu.getId());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Data menu dengan id : " + menu.getId() + " tidak ditemukan");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal menghapus data menu : " + e.getMessage());
        }
    }
}
