package com.aj.refugio.model;

public class Animal {
    //Variables principales

    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private String tipo;

//Constructor
    public Animal(int id, String nombre, String especie, int edad, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;

    }

//Metodos
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEspecie() {
        return this.especie;
    }

    public int getEdad() {
        return this.edad;
    }

    public double getPeso() {
        return this.peso;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String toString() {
        return null;
    }
}
