package com.aj.refugio.gui;

import com.aj.refugio.model.Animal;
import com.aj.refugio.service.Refugio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AnimalesPanel extends JPanel {

    private Refugio refugio;
    private JTable tabla;
    private DefaultTableModel model;

    public AnimalesPanel(Refugio refugio) {

        this.refugio = refugio;

        setLayout(new BorderLayout());
        setBackground(MainFrame.COLOR_SECONDARY);

        // ─────────────────────────────
        // TÍTULO
        // ─────────────────────────────
        JLabel title = new JLabel("🐶 Animales del Refugio", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(40, 40, 40));
        add(title, BorderLayout.NORTH);

        // ─────────────────────────────
        // BARRA SUPERIOR (Buscar / Añadir / Eliminar)
        // ─────────────────────────────
        JPanel topBar = new JPanel();
        topBar.setBackground(MainFrame.COLOR_SECONDARY);
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField txtBuscar = new JTextField(10);
        JButton btnBuscar = new JButton("🔍 Buscar ID");
        JButton btnAñadir = new JButton("➕ Añadir");
        JButton btnEliminar = new JButton("🗑 Eliminar");

        topBar.add(new JLabel("ID:"));
        topBar.add(txtBuscar);
        topBar.add(btnBuscar);
        topBar.add(btnAñadir);
        topBar.add(btnEliminar);

        add(topBar, BorderLayout.SOUTH);

        // ─────────────────────────────
        // TABLA
        // ─────────────────────────────
        String[] columnas = {"ID", "Nombre", "Especie", "Edad", "Peso", "Tipo"};
        model = new DefaultTableModel(columnas, 0);
        tabla = new JTable(model);
        tabla.setRowHeight(24);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        cargarDatos();

        // ─────────────────────────────
        // EVENTOS
        // ─────────────────────────────

        // Buscar por ID
        btnBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                Animal a = refugio.buscarAnimalPorID(id); // ← CORREGIDO

                if (a == null) {
                    JOptionPane.showMessageDialog(this, "No existe un animal con ID " + id);
                } else {
                    JOptionPane.showMessageDialog(this, a.toString());
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduce un ID válido");
            }
        });

        // Añadir animal
        btnAñadir.addActionListener(e -> añadirAnimal());

        // Eliminar animal
        btnEliminar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBuscar.getText());
                boolean eliminado = refugio.eliminarAnimal(id);

                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Animal eliminado");
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un animal con ese ID");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduce un ID válido");
            }
        });
    }

    // ─────────────────────────────
    // CARGAR DATOS EN LA TABLA
    // ─────────────────────────────
    private void cargarDatos() {
        model.setRowCount(0);

        for (Animal a : refugio.animales) {
            model.addRow(new Object[]{
                    a.getId(), a.getNombre(), a.getEspecie(),
                    a.getEdad(), a.getPeso(), a.getTipo()
            });
        }
    }

    // ─────────────────────────────
    // AÑADIR ANIMAL (DIÁLOGO)
    // ─────────────────────────────
    private void añadirAnimal() {

        JTextField nombre = new JTextField();
        JTextField especie = new JTextField();
        JTextField edad = new JTextField();
        JTextField peso = new JTextField();
        JTextField tipo = new JTextField();

        Object[] campos = {
                "Nombre:", nombre,
                "Especie:", especie,
                "Edad:", edad,
                "Peso:", peso,
                "Tipo (domestico/salvaje/otro):", tipo
        };

        int opcion = JOptionPane.showConfirmDialog(
                this, campos, "Añadir Animal", JOptionPane.OK_CANCEL_OPTION
        );

        if (opcion == JOptionPane.OK_OPTION) {

            try {
                refugio.añadirAnimal( // ← AHORA EXISTE EN REFUGIO
                        nombre.getText(),
                        especie.getText(),
                        Integer.parseInt(edad.getText()),
                        Double.parseDouble(peso.getText()),
                        tipo.getText()
                );

                cargarDatos();
                JOptionPane.showMessageDialog(this, "Animal añadido correctamente");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos inválidos");
            }
        }
    }
}
