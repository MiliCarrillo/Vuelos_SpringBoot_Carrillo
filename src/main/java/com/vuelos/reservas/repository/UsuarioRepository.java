package com.vuelos.reservas.repository;

import com.vuelos.reservas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /** Busca por username para el login. */
    Optional<Usuario> findByUsername(String username);

    /** Verifica si ya existe un username (registro). */
    boolean existsByUsername(String username);

    /** Verifica si ya existe un correo (registro). */
    boolean existsByCorreoElectronico(String correoElectronico);
}
