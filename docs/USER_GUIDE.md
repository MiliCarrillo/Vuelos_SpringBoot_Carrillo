# 📖 Guía de Usuario

## Sistema de Reserva de Vuelos — SkyReservas

---

## 1. Acceso a la Aplicación

Una vez iniciada la aplicación, abrí tu navegador y dirigite a:

```
http://localhost:8080
```

El sistema te redirigirá automáticamente a la pantalla de inicio de sesión.

---

## 2. Crear una Cuenta

Si es tu primera vez en el sistema, debés registrarte:

1. En la pantalla de login, hacé click en **"Crear usuario"**
2. Completá el formulario con tus datos:
   - **Nombre** y **Apellido**
   - **Correo electrónico** (debe ser único)
   - **Nombre de usuario** (mínimo 3 caracteres, debe ser único)
   - **Contraseña** (mínimo 6 caracteres)
   - **Confirmar contraseña**
3. Hacé click en **"Crear Cuenta"**
4. Si todo es correcto, serás redirigido al login con un mensaje de éxito

> ⚠️ Si el nombre de usuario o el correo ya están en uso, el sistema te lo informará y podrás corregirlo.

---

## 3. Iniciar Sesión

1. Ingresá tu **nombre de usuario** y **contraseña**
2. Hacé click en **"Iniciar Sesión"**
3. Si las credenciales son correctas, serás redirigido al **Dashboard**

---

## 4. Dashboard — Vuelos Disponibles

Aquí verás la lista de todos los vuelos disponibles ordenados por fecha.

| Columna | Descripción |
|---|---|
| N° Vuelo | Identificador del vuelo |
| Destino | Ciudad de llegada |
| Piloto | Nombre del piloto a cargo |
| Fecha | Fecha del vuelo |
| Aerolínea | Compañía aérea operadora |
| Aeropuerto | Aeropuerto de salida |
| N° Avión | Identificador del avión |

Para reservar un vuelo, hacé click en el botón **"Reservar"** de la fila correspondiente.

---

## 5. Checkout — Confirmar Reserva

Al seleccionar un vuelo serás llevado a la pantalla de checkout:

1. Revisá el **resumen del vuelo** seleccionado
2. Seleccioná un **método de pago** del desplegable:
   - Tarjeta de Crédito
   - Tarjeta de Débito
   - Transferencia Bancaria
   - Efectivo en Aeropuerto
3. Hacé click en **"Reservar ✈"**

> ⚠️ Si no seleccionás un método de pago, el sistema te mostrará un error de validación sin enviar el formulario.

---

## 6. Confirmación de Reserva

Al completar la reserva exitosamente, aparecerá una ventana de confirmación con:

- ✓ Mensaje de éxito
- **N° de Reserva** generado (6 dígitos, ej: `482931`)

> 📌 Guardá ese número para futuras consultas.

Al cerrar la ventana (botón "Volver a Vuelos Disponibles"), serás redirigido automáticamente al Dashboard.

---

## 7. Mis Reservas

Para ver el historial de tus reservas:

1. En la barra de navegación, hacé click en **"Mis Reservas"**
2. Verás una tabla con todas tus reservas ordenadas de más reciente a más antigua

### 7.1 Eliminar una Reserva

1. En la fila de la reserva que querés eliminar, hacé click en **"Eliminar"**
2. Aparecerá un modal de confirmación mostrando el N° de reserva
3. Si estás seguro, hacé click en **"Sí, eliminar"**
4. Si no querés continuar, hacé click en **"Cancelar"**

> ⚠️ La eliminación es permanente y no puede deshacerse.

---

## 8. Cerrar Sesión

Hacé click en el botón **"Cerrar sesión"** en la barra de navegación superior.

La sesión expira automáticamente luego de **30 minutos de inactividad**.

---

## 9. Mensajes del Sistema

| Tipo | Color | Descripción |
|---|---|---|
| ✅ Éxito | Verde | La operación se completó correctamente |
| ❌ Error | Rojo | Ocurrió un problema, se describe el motivo |

---

## 10. Preguntas Frecuentes

**¿Puedo reservar el mismo vuelo más de una vez?**
Sí, el sistema permite múltiples reservas sobre el mismo vuelo.

**¿Qué pasa si cierro el navegador sin cerrar sesión?**
La sesión expira automáticamente a los 30 minutos de inactividad.

**¿Puedo modificar una reserva existente?**
En esta versión del sistema no está disponible la modificación. Podés eliminar la reserva y crear una nueva.

**¿Puedo ver las reservas de otros usuarios?**
No, cada usuario solo puede ver y gestionar sus propias reservas.
