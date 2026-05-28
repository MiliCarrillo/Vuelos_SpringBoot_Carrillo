package com.vuelos.reservas.controller;

import com.vuelos.reservas.entity.Usuario;
import com.vuelos.reservas.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * Controlador de Autenticación.
 */
@Controller
public class AuthController {

    /**almacena el usuario autenticado. */
    public static final String SESSION_USUARIO = "usuarioActivo";

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ── GET / ─────────────────────────────────────────────────────────────────

    @GetMapping("/")
    public String inicio(HttpSession session) {
        // Si ya hay sesión activa, ir directo al dashboard
        if (session.getAttribute(SESSION_USUARIO) != null) {
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }

    // ── GET /login ────────────────────────────────────────────────────────────

    @GetMapping("/login")
    public String mostrarLogin(HttpSession session) {
        if (session.getAttribute(SESSION_USUARIO) != null) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    // ── POST /login ───────────────────────────────────────────────────────────

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

        Optional<Usuario> usuarioOpt = usuarioService.autenticar(username, password);

        if (usuarioOpt.isPresent()) {
            session.setAttribute(SESSION_USUARIO, usuarioOpt.get());
            session.setMaxInactiveInterval(30 * 60); // 30 minutos
            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos.");
        model.addAttribute("username", username); // mantener el campo usuario pre-cargado
        return "login";
    }

    // ── GET /registro ─────────────────────────────────────────────────────────

    @GetMapping("/registro")
    public String mostrarRegistro(HttpSession session) {
        if (session.getAttribute(SESSION_USUARIO) != null) {
            return "redirect:/dashboard";
        }
        return "registro";
    }

    // ── POST /registro ────────────────────────────────────────────────────────

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String correoElectronico,
                                   @RequestParam String nombre,
                                   @RequestParam String apellido,
                                   RedirectAttributes redirectAttrs,
                                   Model model) {
        try {
            usuarioService.registrar(username, password, correoElectronico, nombre, apellido);
            redirectAttrs.addFlashAttribute("exito", "¡Cuenta creada exitosamente! Ya podés iniciar sesión.");
            return "redirect:/login";

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());

            model.addAttribute("username", username);
            model.addAttribute("correoElectronico", correoElectronico);
            model.addAttribute("nombre", nombre);
            model.addAttribute("apellido", apellido);
            return "registro";
        }
    }

    // ── GET /logout ───────────────────────────────────────────────────────────

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttrs) {
        session.invalidate();
        redirectAttrs.addFlashAttribute("exito", "Sesión cerrada correctamente.");
        return "redirect:/login";
    }
}
