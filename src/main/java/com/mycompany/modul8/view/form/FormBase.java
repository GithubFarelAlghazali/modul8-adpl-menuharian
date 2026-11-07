/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.modul8.view.form;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author User
 */
public class FormBase extends JDialog {

    private JButton btnSave;
    private JButton btnCancel;
    private JTextField inMenu;
    private JTextField inTujuan;

    public FormBase(Frame owner, String title, String saveText) {
        super(owner, title, true);
        setLayout(new BorderLayout());
        setSize(400, 150);

        // form
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 10));

        inMenu = new JTextField();
        inTujuan = new JTextField();

        formPanel.add(new JLabel("Nama menu : "));
        formPanel.add(this.inMenu);
        formPanel.add(new JLabel("Tujuan pengiriman : "));
        formPanel.add(this.inTujuan);
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));

        // button
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnSave = new JButton(saveText);
        btnCancel = new JButton("Batal");
        btnPanel.add(this.btnSave);
        btnPanel.add(this.btnCancel);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));

        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(owner);
    }

    public JTextField getInMenu() {
        return this.inMenu;
    }

    public JTextField getInTujuan() {
        return this.inTujuan;
    }

    public JButton getBtnSave() {
        return this.btnSave;
    }

    public JButton getBtnCancel() {
        return this.btnCancel;
    }
}
