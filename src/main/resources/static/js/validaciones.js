
// ── Helpers ────────────────────────────────────────────────────────────────


//Muestra un mensaje de error debajo del campo

function mostrarError(fieldId, errorId, mensaje) {
    const field = document.getElementById(fieldId);
    const errorEl = document.getElementById(errorId);
    if (field)   field.classList.add('is-invalid');
    if (errorEl) errorEl.textContent = mensaje;
}


//Limpia el estado de error de un campo

function limpiarError(fieldId, errorId) {
    const field = document.getElementById(fieldId);
    const errorEl = document.getElementById(errorId);
    if (field)   field.classList.remove('is-invalid');
    if (errorEl) errorEl.textContent = '';
}

//Limpia todos los errores de un formulario dado

function limpiarTodosLosErrores(pares) {
    pares.forEach(([fieldId, errorId]) => limpiarError(fieldId, errorId));
}

// ── Validar Login ──────────────────────────────────────────────────────────

function validarLogin() {
    const pares = [
        ['username', 'usernameError'],
        ['password', 'passwordError'],
    ];
    limpiarTodosLosErrores(pares);

    let valido = true;

    const username = document.getElementById('username');
    const password = document.getElementById('password');

    if (!username || username.value.trim() === '') {
        mostrarError('username', 'usernameError', 'El nombre de usuario es obligatorio.');
        valido = false;
    }

    if (!password || password.value.trim() === '') {
        mostrarError('password', 'passwordError', 'La contraseña es obligatoria.');
        valido = false;
    }

    return valido;
}

// ── Validar Registro ───────────────────────────────────────────────────────

function validarRegistro() {
    const pares = [
        ['nombre',             'nombreError'],
        ['apellido',           'apellidoError'],
        ['correoElectronico',  'correoError'],
        ['username',           'usernameError'],
        ['password',           'passwordError'],
        ['confirmarPassword',  'confirmarPasswordError'],
    ];
    limpiarTodosLosErrores(pares);

    let valido = true;

    // nombre
    const nombre = document.getElementById('nombre');
    if (!nombre || nombre.value.trim() === '') {
        mostrarError('nombre', 'nombreError', 'El nombre es obligatorio.');
        valido = false;
    }

    // apellido
    const apellido = document.getElementById('apellido');
    if (!apellido || apellido.value.trim() === '') {
        mostrarError('apellido', 'apellidoError', 'El apellido es obligatorio.');
        valido = false;
    }

    // mail
    const correo = document.getElementById('correoElectronico');
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!correo || correo.value.trim() === '') {
        mostrarError('correoElectronico', 'correoError', 'El correo electrónico es obligatorio.');
        valido = false;
    } else if (!emailRegex.test(correo.value.trim())) {
        mostrarError('correoElectronico', 'correoError', 'Ingresá un correo electrónico válido.');
        valido = false;
    }

    // username
    const username = document.getElementById('username');
    if (!username || username.value.trim() === '') {
        mostrarError('username', 'usernameError', 'El nombre de usuario es obligatorio.');
        valido = false;
    } else if (username.value.trim().length < 3) {
        mostrarError('username', 'usernameError', 'El nombre de usuario debe tener al menos 3 caracteres.');
        valido = false;
    }

    // contraseña
    const password = document.getElementById('password');
    if (!password || password.value === '') {
        mostrarError('password', 'passwordError', 'La contraseña es obligatoria.');
        valido = false;
    } else if (password.value.length < 6) {
        mostrarError('password', 'passwordError', 'La contraseña debe tener al menos 6 caracteres.');
        valido = false;
    }

    // Confirmar contraseña
    const confirmar = document.getElementById('confirmarPassword');
    if (!confirmar || confirmar.value === '') {
        mostrarError('confirmarPassword', 'confirmarPasswordError', 'Confirmá tu contraseña.');
        valido = false;
    } else if (password && password.value !== confirmar.value) {
        mostrarError('confirmarPassword', 'confirmarPasswordError', 'Las contraseñas no coinciden.');
        valido = false;
    }

    return valido;
}

// ── Validar Checkout ───────────────────────────────────────────────────────

function validarCheckout() {
    limpiarError('metodoPago', 'metodoPagoError');

    const metodoPago = document.getElementById('metodoPago');

    if (!metodoPago || metodoPago.value === '') {
        mostrarError('metodoPago', 'metodoPagoError', 'Seleccioná un método de pago para continuar.');
        return false;
    }

    return true;
}
