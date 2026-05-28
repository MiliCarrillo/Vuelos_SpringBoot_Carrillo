package com.vuelos.reservas.repository;

import com.vuelos.reservas.entity.Reserva;
import com.vuelos.reservas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /** Reservas del usuario autenticado. */
    List<Reserva> findByUsuarioOrderByFechaReservaDesc(Usuario usuario);

    /** Verifica unicidad del número de reserva. */
    boolean existsByNroReserva(int nroReserva);
}
