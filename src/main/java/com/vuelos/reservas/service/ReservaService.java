package com.vuelos.reservas.service;

import com.vuelos.reservas.entity.MetodoPago;
import com.vuelos.reservas.entity.Reserva;
import com.vuelos.reservas.entity.Usuario;
import com.vuelos.reservas.entity.Vuelo;
import com.vuelos.reservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final VueloService vueloService;

    public ReservaService(ReservaRepository reservaRepository, VueloService vueloService) {
        this.reservaRepository = reservaRepository;
        this.vueloService = vueloService;
    }

    /**
     * Crea una nueva reserva para el usuario autenticado.
     */
    public Reserva crearReserva(Long vueloId, MetodoPago metodoPago, Usuario usuario) {

        Vuelo vuelo = vueloService.buscarPorId(vueloId)
                .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado: " + vueloId));

        int nroReserva = generarNroReservaUnico();

        Reserva reserva = new Reserva(nroReserva, vuelo, usuario, metodoPago);
        return reservaRepository.save(reserva);
    }

    /**
     * Devuelve todas las reservas del usuario, ordenadas por fecha descendente.
     */
    @Transactional(readOnly = true)
    public List<Reserva> obtenerPorUsuario(Usuario usuario) {
        return reservaRepository.findByUsuarioOrderByFechaReservaDesc(usuario);
    }

    /**
     * Elimina una reserva por ID, validando que pertenezca al usuario de la sesión.
     *
     * @throws IllegalArgumentException si la reserva no existe o no pertenece al usuario.
     */
    public void eliminar(Long reservaId, Usuario usuario) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada: " + reservaId));

        if (!reserva.getUsuario().getId().equals(usuario.getId())) {
            throw new IllegalArgumentException("No tenés permiso para eliminar esta reserva.");
        }

        reservaRepository.delete(reserva);
    }

    private int generarNroReservaUnico() {
        Random random = new Random();
        int nro;
        int intentos = 0;
        do {
            nro = 100000 + random.nextInt(900000);
            intentos++;
            if (intentos > 100) {
                throw new IllegalStateException("No se pudo generar un número de reserva único.");
            }
        } while (reservaRepository.existsByNroReserva(nro));
        return nro;
    }
}