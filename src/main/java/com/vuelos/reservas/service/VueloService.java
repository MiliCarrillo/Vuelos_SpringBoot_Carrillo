package com.vuelos.reservas.service;

import com.vuelos.reservas.entity.Vuelo;
import com.vuelos.reservas.repository.VueloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VueloService {

    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    /** Devuelve todos los vuelos ordenados por fecha para el dashboard. */
    public List<Vuelo> obtenerTodos() {
        return vueloRepository.findAllByOrderByFechaAsc();
    }


    public Optional<Vuelo> buscarPorId(Long id) {
        return vueloRepository.findById(id);
    }
}
