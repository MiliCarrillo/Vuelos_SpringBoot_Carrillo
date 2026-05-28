
document.addEventListener('DOMContentLoaded', function () {

    const form        = document.getElementById('checkoutForm');
    const btnReservar = document.getElementById('btnReservar');
    const overlay     = document.getElementById('modalOverlay');
    const nroDisplay  = document.getElementById('nroReservaDisplay');
    const btnCerrar   = document.getElementById('btnCerrarModal');
    const serverError = document.getElementById('serverError');

    if (!form) return; // salir si el elemento no existe en la página

    // ── Envío del formulario ──────────────────────────────────────────────

    form.addEventListener('submit', async function (e) {
        e.preventDefault();

        // Validación del lado del cliente
        if (!validarCheckout()) return;

        const vueloId    = document.getElementById('vueloId').value;
        const metodoPago = document.getElementById('metodoPago').value;

        // Estado de carga
        btnReservar.disabled    = true;
        btnReservar.textContent = 'Procesando...';
        serverError.style.display = 'none';

        try {
            const response = await fetch('/reservar', {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: new URLSearchParams({ vueloId, metodoPago })
            });

            const data = await response.json();

            if (response.ok && data.success) {

                nroDisplay.textContent  = data.nroReserva;
                overlay.style.display   = 'flex';
                document.body.style.overflow = 'hidden'; // evitar scroll detrás del modal
            } else {

                mostrarErrorServidor(data.error || 'Ocurrió un error al procesar la reserva.');
            }

        } catch (err) {
            mostrarErrorServidor('Error de conexión. Verificá tu internet e intentá nuevamente.');
        } finally {
            btnReservar.disabled    = false;
            btnReservar.textContent = 'Reservar ✈';
        }
    });

    // ── Cerrar modal y redirigir al dashboard ─────────────────────────────

    btnCerrar.addEventListener('click', function () {
        cerrarModal();
        window.location.href = '/dashboard';
    });


    overlay.addEventListener('click', function (e) {
        if (e.target === overlay) {
            cerrarModal();
            window.location.href = '/dashboard';
        }
    });


    document.addEventListener('keydown', function (e) {
        if (e.key === 'Escape' && overlay.style.display === 'flex') {
            cerrarModal();
            window.location.href = '/dashboard';
        }
    });

    // ── Helpers internos ─────────────────────────────────────────────────

    function cerrarModal() {
        overlay.style.display        = 'none';
        document.body.style.overflow = '';
    }

    function mostrarErrorServidor(mensaje) {
        serverError.textContent   = mensaje;
        serverError.style.display = 'block';
        // Scroll suave al error para que sea visible
        serverError.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
    }
});
