/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.repo;

import com.mycompany.modul8.model.MenuModel;
import com.mycompany.modul8.config.Database;
import java.sql.*;
import java.util.*;

/**
 *
 * @author User
 */
public class GetAllMenu extends BaseMenuRepo implements QueryRead<Void, List<MenuModel>> {

    public GetAllMenu(Database db) {
        super(db);
    }

    @Override
    public List<MenuModel> query(Void param) {
        List<MenuModel> daftarMenu = new ArrayList<>();
        String sql = "SELECT id, menu, tujuan FROM tabel_menu";

        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                daftarMenu.add(new MenuModel(
                        rs.getString("id"),
                        rs.getString("menu"),
                        rs.getString("tujuan")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal membaca daftar menu : " + e);
        }

        return daftarMenu;
    }
}
