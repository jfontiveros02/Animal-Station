package com.aj.refugio.model;

public class AnimalDomestico extends Animal {
    //Variables principales

    private boolean adoptado;
    private boolean sociable;
    private boolean vacunado;
    //Constructor
    public AnimalDomestico(int id, String nombre, String especie, int edad, double peso, 
                            boolean adoptado, boolean sociable, boolean vacunado) {
        super(id, nombre, especie, edad, peso);

        this.adoptado = adoptado;
        this.sociable = sociable;
        this.vacunado = vacunado;
    }
    //Metodos  
}
