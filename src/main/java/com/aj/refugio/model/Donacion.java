package com.aj.refugio.model;

import java.time.LocalDate;
import java.util.ArrayList;

// Esta clase representa una donación hecha al refugio.
// Puede ser dinero, comida, medicinas, etc.
// También guarda un historial de cantidades si quieres registrar varias donaciones del mismo donante.
public class Donacion implements Exportable {

    // Nombre de la persona que dona
    private String donante;

    // Cantidad de la donación inicial
    private double cantidad;

    // Fecha en la que se hizo la donación
    private LocalDate fecha;

    // Tipo de donación (dinero, comida, medicinas…)
    private String tipo;

    // Lista para guardar todas las cantidades si el mismo donante dona varias veces
    private ArrayList<Double> donaciones;

    // Constructor principal
    public Donacion(String donante, double cantidad, LocalDate fecha, String tipo) {
        this.donante = donante;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipo = tipo;

        // Inicializamos la lista para evitar NullPointerException
        this.donaciones = new ArrayList<>();

        // Guardamos la primera donación en la lista
        this.donaciones.add(cantidad);
    }

    // Método para añadir más donaciones del mismo donante
    public void agregarDonacion(double cantidad) {
        this.donaciones.add(cantidad);
    }

    // Devuelve la lista completa de cantidades donadas por esta persona
    public ArrayList<Double> getDonaciones() {
        return this.donaciones;
    }

    // Devuelve la suma total de todas las donaciones de este donante
    public double getTotalDonado() {
        double total = 0;
        for (double d : donaciones) {
            total += d;
        }
        return total;
    }

    public String getDonante() {
        return this.donante;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public String getTipo() {
        return this.tipo;
    }

    // Representación en texto de la donación
    @Override
    public String toString() {
        return "Donante: " + donante +
               " | Cantidad inicial: " + cantidad +
               " | Total donado: " + getTotalDonado() +
               " | Tipo: " + tipo +
               " | Fecha: " + fecha +
               " | Historial: " + donaciones;
    }

    @Override
    public String toJSON() {
        return "{\"donante\":\"" + donante + "\"" +
               ",\"cantidad\":" + cantidad +
               ",\"tipo\":\"" + tipo + "\"" +
               ",\"fecha\":\"" + fecha + "\"}";
    }

    @Override
    public String toCSV() {
        return donante + "," + cantidad + "," + tipo + "," + fecha;
    }
}