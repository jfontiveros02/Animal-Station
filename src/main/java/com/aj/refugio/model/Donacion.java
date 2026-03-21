package com.aj.refugio.model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Donacion {
    //Variables principales

    private String donante;

    private double cantidad;

    private LocalDate fecha;

    private String tipo; // (dinero, comida, medicinas…)

    private ArrayList<Double> donaciones;

    //Constructor
    public Donacion(String donante, double cantidad, LocalDate fecha, String tipo) {
        this.donante = donante;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    //Metodos
    @Override
    public String toString() {
        return null;
    }

    public ArrayList<Double> getDonaciones() {
        return this.donaciones;
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

}
