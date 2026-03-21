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

    public ArrayList<Animal> getAnimalesAdoptados() {
        return null;
    }
}
