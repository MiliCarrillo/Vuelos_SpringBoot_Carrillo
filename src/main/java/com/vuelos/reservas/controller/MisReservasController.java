package com.vuelos.reservas.controller;

import com.vuelos.reservas.entity.Usuario;
import com.vuelos.reservas.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de Mis Reservas.
 * Muestra las reservas del usuario autenticado y permite eliminarlas.
 */
@Controller
public class MisReservasController {

    private final ReservaService reservaService;

    public MisReservasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // ── GET /mis-reservas ─────────────────────────────────────────────────────

    @GetMapping("/mis-reservas")
    public String misReservas(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute(AuthController.SESSION_USUARIO);
        if (usuario == null) return "redirect:/login";

        model.addAttribute("usuario", usuario);
        model.addAttribute("reservas", reservaService.obtenerPorUsuario(usuario));

        return "mis-reservas";
    }

    // ── POST /mis-reservas/eliminar/{id} ──────────────────────────────────────

    @PostMapping("/mis-reservas/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id,
                                  HttpSession session,
                                  RedirectAttributes redirectAttrs) {

        Usuario usuario = (Usuario) session.getAttribute(AuthController.SESSION_USUARIO);
        if (usuario == null) return "redirect:/login";

        try {
            reservaService.eliminar(id, usuario);
            redirectAttrs.addFlashAttribute("exito", "Reserva eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            redirectAttrs.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/mis-reservas";
    }
}