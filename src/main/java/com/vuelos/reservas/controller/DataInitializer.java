package com.vuelos.reservas.controller;

import com.vuelos.reservas.entity.Vuelo;
import com.vuelos.reservas.repository.VueloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Carga datos de ejemplo al iniciar la aplicación si la tabla de vuelos está vacía.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final VueloRepository vueloRepository;

    public DataInitializer(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public void run(String... args) {
        if (vueloRepository.count() > 0) return; // No re-insertar si ya existen datos

        List<Vuelo> vuelos = List.of(
            new Vuelo(1001, "Buenos Aires",   "Carlos Rodríguez",  LocalDate.of(2025, 8, 15), "Aerolíneas Argentinas", "Aeroparque Jorge Newbery",   301),
            new Vuelo(1002, "Mendoza",         "Ana García",         LocalDate.of(2025, 8, 18), "Aerolíneas Argentinas", "Aeropuerto El Plumerillo",   302),
            new Vuelo(1003, "Bariloche",       "Luis Fernández",     LocalDate.of(2025, 8, 20), "LATAM Airlines",       "Aeropuerto Teniente Candelaria", 401),
            new Vuelo(1004, "Córdoba",         "María López",        LocalDate.of(2025, 8, 22), "Flybondi",             "Aeropuerto Ambrosio Taravella", 201),
            new Vuelo(1005, "Ushuaia",         "Roberto Silva",      LocalDate.of(2025, 8, 25), "Aerolíneas Argentinas", "Aeropuerto Malvinas Argentinas", 503),
            new Vuelo(1006, "Salta",           "Elena Martínez",     LocalDate.of(2025, 9, 1),  "JetSMART",             "Aeropuerto Martín Miguel de Güemes", 150),
            new Vuelo(1007, "Mar del Plata",   "Jorge Pérez",        LocalDate.of(2025, 9, 5),  "Flybondi",             "Aeropuerto Ástor Piazzolla",  202)
        );

        vueloRepository.saveAll(vuelos);
        System.out.println(">>> DataInitializer: " + vuelos.size() + " vuelos de ejemplo cargados.");
    }
}
