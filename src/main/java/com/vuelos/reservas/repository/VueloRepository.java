package com.vuelos.reservas.repository;

import com.vuelos.reservas.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    /** Vuelos ordenados por fecha ascendente para el dashboard. */
    List<Vuelo> findAllByOrderByFechaAsc();

    /** Permite buscar por destino (búsqueda futura). */
    List<Vuelo> findByDestinoContainingIgnoreCase(String destino);
}
