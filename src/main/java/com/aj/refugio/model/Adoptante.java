package com.aj.refugio.model;

import java.util.ArrayList;

public class Adoptante extends Persona {
    //Variables principales
    private ArrayList<Animal> animalesAdoptados;

    //Constructor
    public Adoptante(String nombre, String dni, String telefono) {
        super(nombre, dni, telefono);
        this.animalesAdoptados = new ArrayList<>();
    }

    //Metodos

    // Corregido: antes devolvía null, ahora devuelve la lista de verdad
    public ArrayList<Animal> getAnimalesAdoptados() {
        return this.animalesAdoptados;
    }

    public void adoptarAnimal(Animal animal) {
        this.animalesAdoptados.add(animal);
    }

    @Override
    public String toString() {
        return "Adoptante: " + getNombre() +
               " | DNI: " + getDni() +
               " | Teléfono: " + getTelefono() +
               " | Animales adoptados: " + animalesAdoptados.size();
    }
}
