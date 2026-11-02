/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.config;

import java.sql.*;

/**
 *
 * @author User
 */
public class DbConnection {

    static final String url = "jdbc:mysql://localhost:3306/adpldb";
    static final String user = "root";
    static final String pass = "123456";
    static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Gagal terhubung dengan database : " + e.getMessage());
        }
    }

    public void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Query gagal dijalankan : " + e.getMessage());
        }
    }

    public ResultSet view(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Gagal melakukan view : " + e.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal memutus koneksi : " + e.getMessage());
        }
    }
}
