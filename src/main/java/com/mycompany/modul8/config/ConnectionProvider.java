/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.modul8.config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public interface ConnectionProvider {

    Connection getConnection() throws SQLException;
}
