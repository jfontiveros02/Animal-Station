package com.aj.refugio.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.aj.refugio.model.Donacion;
import com.aj.refugio.service.Refugio;

public class DonacionesPanel extends JPanel {

    public DonacionesPanel(Refugio refugio) {

        setLayout(new BorderLayout());
        setBackground(MainFrame.COLOR_SECONDARY);

        JLabel title = new JLabel("💰 Donaciones", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(40, 40, 40));
        add(title, BorderLayout.NORTH);

        String[] columnas = {"Donante", "Cantidad", "Tipo", "Fecha"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (Donacion d : refugio.donaciones) {
            model.addRow(new Object[]{
                    d.getDonante(), d.getCantidad(), d.getTipo(), d.getFecha()
            });
        }

        JTable tabla = new JTable(model);
        tabla.setRowHeight(24);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}
