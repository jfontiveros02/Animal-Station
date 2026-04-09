package com.aj.refugio.service;

import java.util.ArrayList;

import com.aj.refugio.model.Animal;
import com.aj.refugio.model.Donacion;
import com.aj.refugio.model.Persona;

public class Refugio {

    // Variables principales
    private String nombre;
    private String direccion;
    public ArrayList<Animal> animales;
    public ArrayList<Donacion> donaciones;
    public ArrayList<Persona> adoptantes;

    // Constructor completo
    public Refugio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.animales = new ArrayList<>();
        this.donaciones = new ArrayList<>();
        this.adoptantes = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    // Agregar un animal al refugio
    public void agregarAnimal(Animal a) {
        this.animales.add(a);
    }

    // Eliminar un animal por su ID (si existe)
    public void eliminarAnimal(int id) {
        this.animales.removeIf(animal -> animal.getId() == id);
    }

    // Ver lista de animales en el refugio
    public void listarAnimales() {
        for (Animal animal : animales) {
            System.out.println(animal);
        }
    }

    // Registrar una donación al refugio
    public void registrarDonacion(Donacion d) {
        this.donaciones.add(d);
    }

    // Total donaciones
    public double calcularTotalDonaciones() {
        double total = 0.0;
        for (Donacion donacion : donaciones) {
            total += donacion.getTotalDonado();
        }
        return total;
    }

    public Animal buscarAnimalPorID(int id) {
        for (Animal animal : this.animales) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    // Listar animales por tipo (domésticos o salvajes)
    public void listarAnimalesPorTipo(ArrayList<Animal> animales) {
        for (Animal animal : animales) {
            System.out.println(animal.getTipo() + ": " + animal);
        }
    }
}