package com.aj.refugio;

import java.time.LocalDate;

import com.aj.refugio.model.Adoptante;
import com.aj.refugio.model.AnimalDomestico;
import com.aj.refugio.model.AnimalSalvaje;
import com.aj.refugio.model.Donacion;
import com.aj.refugio.model.Persona;
import com.aj.refugio.service.Refugio;

public class App {

    public static void main(String[] args) {
        Refugio refugio = new Refugio("Libertad", "Calle Desengaño 21");

        // Crear algunos animales domésticos
        AnimalDomestico perro = new AnimalDomestico(1, "Chanel", "Perro", 5, 20.5, false, true, true);
        AnimalDomestico gato = new AnimalDomestico(2, "Shya", "Gato", 3, 4.2, false, true, true);
        AnimalDomestico conejo = new AnimalDomestico(5, "Bunny", "Conejo", 2, 1.5, false, true, true);
        // Crear algunos animales salvajes
        AnimalSalvaje aguila = new AnimalSalvaje(3, "Piolín", "Águila", 8, 54.0,
                "Bosque", true, true, false);
        AnimalSalvaje zorro = new AnimalSalvaje(4, "Swiper", "Zorro", 10, 5000.0,
                "", false, true, true);

        refugio.agregarAnimal(perro);
        refugio.agregarAnimal(gato);
        refugio.agregarAnimal(conejo);
        refugio.agregarAnimal(aguila);
        refugio.agregarAnimal(zorro);

        //Creo una perona
        Persona maria = new Persona("María López", "99887766C", "600-112233");

        // Crear un adoptante
        Adoptante juan = new Adoptante("Juan Fontiveros", "12345678A", "555-1234");
        Adoptante andrea = new Adoptante("Andrea Jiménez", "87654321B", "555-5678");

        // Juan adopta a Shya
        juan.adoptarAnimal(gato);
        // Andrea adopta a Chanel
        andrea.adoptarAnimal(perro);

         

        //Donaciones
        Donacion donacionJuan = new Donacion(
                juan.getNombre(), // nombre del donante
                50.0, // cantidad
                LocalDate.now(), // fecha
                "Dinero" // tipo
        );

        Donacion donacionMaria = new Donacion(
                maria.getNombre(), // nombre del donante
                300.0, // cantidad
                LocalDate.now(), // fecha
                "Medicamentos" // tipo
        );
        //Registramos las donaciones en el refugio
        refugio.registrarDonacion(donacionJuan);                
        refugio.registrarDonacion(donacionMaria);

        // Ver animales
        System.out.println("Animales agregados al refugio: ");

        System.out.println("");

        // Mostrar información del refugio y del adoptante
        refugio.listarAnimales();

        System.out.println("");
        System.out.println("Adoptantes: ");
        System.out.println("");

        System.out.println(juan.toString());
        System.out.println(andrea.toString());

        //Ver donaciones(De donaciones)
        System.out.println("");
        System.out.println("Donaciones registradas: ");
        System.out.println(donacionJuan.toString());
        System.out.println(donacionMaria.toString());
        //Total donaciones(Refugio)
        System.out.println("");
        System.out.println("Total donaciones: " + refugio.calcularTotalDonaciones());
    }
}
