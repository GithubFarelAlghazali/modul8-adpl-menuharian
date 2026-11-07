/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.repo;

import com.mycompany.modul8.config.ConnectionProvider;

/**
 *
 * @author User
 */
public class BaseMenuRepo {

    protected final ConnectionProvider db;

    public BaseMenuRepo(ConnectionProvider db) {
        this.db = db;
    }
}
