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

import com.aj.refugio.model.Empleado;
import com.aj.refugio.service.Refugio;

public class EmpleadosPanel extends JPanel {

    public EmpleadosPanel(Refugio refugio) {

        setLayout(new BorderLayout());
        setBackground(MainFrame.COLOR_SECONDARY);

        JLabel title = new JLabel("👷 Empleados", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(40, 40, 40));
        add(title, BorderLayout.NORTH);

        // Columnas reales según tu clase Empleado
        String[] columnas = {"ID", "Nombre", "DNI", "Teléfono", "Tipo Empleado", "Animales a Cargo"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        // Recorremos la lista de personas del refugio
        for (var p : refugio.adoptantes) {
            if (p instanceof Empleado e) {
                model.addRow(new Object[]{
                        e.getIdEmpleado(),
                        e.getNombre(),
                        e.getDni(),
                        e.getTelefono(),
                        e.getTipoEmpleado(),
                        e.getTipoAnimalCargo()
                });
            }
        }

        JTable tabla = new JTable(model);
        tabla.setRowHeight(24);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
}
