package com.aj.refugio.model;

public class AnimalSalvaje extends Animal {
    //Variables principales

    private String habitatOrigen;
    private boolean peligroso;
    private boolean protegido;
    //Constructor
    public AnimalSalvaje(int id, String nombre, String especie, int edad, double peso, 
                        String habitatOrigen, boolean peligroso, boolean protegido) {
        super(id, nombre, especie, edad, peso);

        this.habitatOrigen = habitatOrigen;
        this.peligroso = peligroso;
        this.protegido = protegido;
    }
    //Metodos  
}
