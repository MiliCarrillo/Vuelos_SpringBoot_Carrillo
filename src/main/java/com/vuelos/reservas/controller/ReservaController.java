package com.vuelos.reservas.controller;

import com.vuelos.reservas.entity.MetodoPago;
import com.vuelos.reservas.entity.Reserva;
import com.vuelos.reservas.entity.Usuario;
import com.vuelos.reservas.entity.Vuelo;
import com.vuelos.reservas.service.ReservaService;
import com.vuelos.reservas.service.VueloService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * Controlador de Reservas.
 * El POST devuelve JSON para que el JS del frontend pueda mostrar
 */
@Controller
public class ReservaController {

    private final VueloService vueloService;
    private final ReservaService reservaService;

    public ReservaController(VueloService vueloService, ReservaService reservaService) {
        this.vueloService = vueloService;
        this.reservaService = reservaService;
    }

    // ── GET /checkout/{vueloId} ───────────────────────────────────────────────

    @GetMapping("/checkout/{vueloId}")
    public String mostrarCheckout(@PathVariable Long vueloId,
                                  HttpSession session,
                                  Model model) {

        // Guard de sesión
        Usuario usuario = (Usuario) session.getAttribute(AuthController.SESSION_USUARIO);
        if (usuario == null) {
            return "redirect:/login";
        }

        Optional<Vuelo> vueloOpt = vueloService.buscarPorId(vueloId);
        if (vueloOpt.isEmpty()) {
            return "redirect:/dashboard?error=vuelo_no_encontrado";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("vuelo", vueloOpt.get());
        model.addAttribute("metodosPago", MetodoPago.values()); // para el <select>

        return "checkout";
    }

    // ── POST /reservar ────────────────────────────────────────────────────────

    @PostMapping("/reservar")
    @ResponseBody
    public ResponseEntity<?> procesarReserva(@RequestParam Long vueloId,
                                              @RequestParam String metodoPago,
                                              HttpSession session) {

        // Guard de sesión (por si el token expiró entre el GET y el POST)
        Usuario usuario = (Usuario) session.getAttribute(AuthController.SESSION_USUARIO);
        if (usuario == null) {
            return ResponseEntity.status(401)
                    .body(Map.of("error", "Sesión expirada. Por favor, iniciá sesión nuevamente."));
        }

        try {
            MetodoPago metodo = MetodoPago.valueOf(metodoPago);
            Reserva reserva = reservaService.crearReserva(vueloId, metodo, usuario);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "nroReserva", reserva.getNroReserva(),
                    "mensaje", "¡Reserva confirmada exitosamente!"
            ));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Error inesperado. Por favor, intentá nuevamente."));
        }
    }
}
