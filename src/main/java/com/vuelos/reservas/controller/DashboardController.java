package com.vuelos.reservas.controller;

import com.vuelos.reservas.entity.Usuario;
import com.vuelos.reservas.service.VueloService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador del Dashboard.
 * Muestra la lista de vuelos disponibles
 */
@Controller
public class DashboardController {

    private final VueloService vueloService;

    public DashboardController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        // Guard: redirigir a login si no hay sesion
        Usuario usuario = (Usuario) session.getAttribute(AuthController.SESSION_USUARIO);
        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("vuelos", vueloService.obtenerTodos());

        return "dashboard";
    }
}
