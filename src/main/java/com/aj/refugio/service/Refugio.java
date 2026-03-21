package com.aj.refugio.service;

import java.util.ArrayList;

import com.aj.refugio.model.Animal;
import com.aj.refugio.model.Donacion;
import com.aj.refugio.model.Persona;

public class Refugio {

    //Variables principales
    String nombre;

    String direccion;

    ArrayList<Animal> animales;

    ArrayList<Donacion> donaciones;

    ArrayList<Persona> adoptantes;

    //Constructor
    public Refugio(String nombre, String direccion) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.animales = new ArrayList<>();
        this.donaciones = new ArrayList<>();
        this.adoptantes = new ArrayList<>();
    }

    //Metodos
    public Animal agregarAnimal(Animal a) {
        return null;
    }

    public void eliminarAnimal(int id) {

    }

    public void listarAnimales(ArrayList<Animal> animales) {

    }

    public void registrarDonacion(Donacion d) {

    }

    public double calcularTotalDonaciones() {
        return 0.0;
    }

    public Animal buscarAnimalPorID(int id) {
        return null;
    }

    public void listarAnimalesPorTipo(ArrayList<Animal> animales) {

    }

}
