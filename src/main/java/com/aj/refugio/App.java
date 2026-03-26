package com.aj.refugio;
import com.aj.refugio.model.*;
import com.aj.refugio.service.Refugio;

public class App {
    public static void main(String[] args) {
        Refugio refugio = new Refugio("Libertad", "Calle Desengaño 21");

        // Crear algunos animales domésticos
        AnimalDomestico perro = new AnimalDomestico(1, "Chanel", "Perro", 5, 20.5, false, true, true);
        AnimalDomestico gato = new AnimalDomestico(2, "Shya", "Gato", 3, 4.2, false, true, true);

        // Crear algunos animales salvajes
        AnimalSalvaje tigre = new AnimalSalvaje(3, "Shere Khan", "Tigre", 8, 220.0,
                "Selva", true, true, false);
        AnimalSalvaje elefante = new AnimalSalvaje(4, "Dumbo", "Elefante", 10, 5000.0,
                "Sabana", false, true, false);

        // Agregar animales al refugio
        refugio.agregarAnimal(perro);
        refugio.agregarAnimal(gato);
        refugio.agregarAnimal(tigre);
        refugio.agregarAnimal(elefante);

        // Crear un adoptante
        Adoptante juan = new Adoptante("Juan Fontiveros", "12345678A", "555-1234");
        Adoptante andrea = new Adoptante("Andrea Jiménez", "87654321B", "555-5678");

        // Juan adopta a Rex
        juan.adoptarAnimal(gato);
        // Andrea adopta a Mia
        andrea.adoptarAnimal(perro);

        // Mostrar información del refugio y del adoptante
        System.out.println(refugio);
        System.out.println(juan);
        System.out.println(andrea);

        refugio.listarAnimales();

    }
}
