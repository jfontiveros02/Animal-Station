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

import com.aj.refugio.model.Adoptante;
import com.aj.refugio.service.Refugio;

public class AdoptantesPanel extends JPanel {

    public AdoptantesPanel(Refugio refugio) {

        setLayout(new BorderLayout());
        setBackground(MainFrame.COLOR_SECONDARY);

        JLabel title = new JLabel("👤 Adoptantes", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(40, 40, 40));
        add(title, BorderLayout.NORTH);

        String[] columnas = {"Nombre", "DNI", "Teléfono"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (var p : refugio.adoptantes) {
            if (p instanceof Adoptante a) {
                model.addRow(new Object[]{
                        a.getNombre(), a.getDni(), a.getTelefono()
                });
            }
        }

        JTable tabla = new JTable(model);
        tabla.setRowHeight(24);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}
