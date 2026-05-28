package com.vuelos.reservas.service;

import com.vuelos.reservas.entity.Usuario;
import com.vuelos.reservas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario registrar(String username, String password, String correo,
                             String nombre, String apellido) {

        if (usuarioRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("El nombre de usuario '" + username + "' ya está en uso.");
        }
        if (usuarioRepository.existsByCorreoElectronico(correo)) {
            throw new IllegalArgumentException("El correo electrónico '" + correo + "' ya está registrado.");
        }

        Usuario nuevo = new Usuario(username, password, correo, nombre, apellido);
        return usuarioRepository.save(nuevo);
    }


    @Transactional(readOnly = true)
    public Optional<Usuario> autenticar(String username, String password) {
        return usuarioRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
}
