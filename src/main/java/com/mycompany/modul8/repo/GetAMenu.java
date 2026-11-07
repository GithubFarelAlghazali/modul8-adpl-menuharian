/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.repo;

import com.mycompany.modul8.config.ConnectionProvider;
import com.mycompany.modul8.model.MenuModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class GetAMenu extends BaseMenuRepo implements QueryRead<Integer, MenuModel> {

    public GetAMenu(ConnectionProvider db) {
        super(db);
    }

    @Override
    public MenuModel query(Integer id) {

        String sql = "SELECT id, menu, tujuan FROM tabel_menu WHERE id = ?";

        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new RuntimeException("Data menu dengan id = " + id + " tidak ditemukan");
                }
                return new MenuModel(rs.getInt("id"), rs.getString("menu"), rs.getString("tujuan"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal membaca menu : " + e);
        }
    }
}
