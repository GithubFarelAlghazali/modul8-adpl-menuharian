/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.modul8;

import com.mycompany.modul8.view.MenuDashboardView;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> new MenuDashboardView()
        );
    }
}
