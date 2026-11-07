/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modul8.view.actioncell;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author User
 */
public class ActionCellPanel extends JPanel {

    final JButton btnEdit = new JButton("Edit");
    final JButton btnDelete = new JButton("Delete");

    public ActionCellPanel() {
        super(new FlowLayout(FlowLayout.CENTER, 4, 2));
        add(btnEdit);
        add(btnDelete);
    }
}
