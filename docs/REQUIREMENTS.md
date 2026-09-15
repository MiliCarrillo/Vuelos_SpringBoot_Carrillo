# 📋 Requerimientos del Sistema

## Sistema de Reserva de Vuelos — Spring Boot

---

## 1. Requerimientos Funcionales

### RF-01 · Gestión de Usuarios

| ID | Requerimiento |
|---|---|
| RF-01.1 | El sistema debe permitir registrar un nuevo usuario con nombre, apellido, correo electrónico, nombre de usuario y contraseña. |
| RF-01.2 | El sistema debe validar que el nombre de usuario sea único en el momento del registro. |
| RF-01.3 | El sistema debe validar que el correo electrónico sea único y tenga formato válido. |
| RF-01.4 | El sistema debe permitir al usuario iniciar sesión con su nombre de usuario y contraseña. |
| RF-01.5 | El sistema debe permitir cerrar sesión en cualquier momento. |
| RF-01.6 | El sistema debe redirigir al login si el usuario intenta acceder a una página protegida sin sesión activa. |

---

### RF-02 · Dashboard de Vuelos

| ID | Requerimiento |
|---|---|
| RF-02.1 | El sistema debe mostrar todos los vuelos disponibles en una tabla al usuario autenticado. |
| RF-02.2 | Cada vuelo debe mostrar: N° de vuelo, destino, piloto, fecha, aerolínea, aeropuerto y N° de avión. |
| RF-02.3 | Los vuelos deben estar ordenados por fecha de forma ascendente. |
| RF-02.4 | Si no existen vuelos cargados, el sistema debe mostrar un mensaje informativo. |

---

### RF-03 · Proceso de Reserva

| ID | Requerimiento |
|---|---|
| RF-03.1 | Al seleccionar un vuelo, el sistema debe redirigir al usuario a la pantalla de checkout. |
| RF-03.2 | La pantalla de checkout debe mostrar el resumen completo del vuelo seleccionado. |
| RF-03.3 | El sistema debe ofrecer al menos 4 métodos de pago: Tarjeta de Crédito, Tarjeta de Débito, Transferencia Bancaria y Efectivo. |
| RF-03.4 | El sistema debe validar del lado del cliente que se haya seleccionado un método de pago antes de enviar el formulario. |
| RF-03.5 | El sistema debe generar un número de reserva único de 6 dígitos al confirmar la reserva. |
| RF-03.6 | Al confirmar la reserva exitosamente, el sistema debe mostrar un modal con el número de reserva generado. |
| RF-03.7 | Al cerrar el modal de confirmación, el usuario debe ser redirigido al dashboard. |

---

### RF-04 · Gestión de Mis Reservas

| ID | Requerimiento |
|---|---|
| RF-04.1 | El sistema debe permitir al usuario ver todas sus reservas en una sección dedicada. |
| RF-04.2 | Cada reserva debe mostrar: N° de reserva, destino, N° de vuelo, fecha de vuelo, aerolínea, método de pago y fecha de la reserva. |
| RF-04.3 | Las reservas deben estar ordenadas por fecha de creación de forma descendente. |
| RF-04.4 | El sistema debe permitir al usuario eliminar una reserva seleccionada. |
| RF-04.5 | Antes de eliminar, el sistema debe mostrar un modal de confirmación con el N° de reserva. |
| RF-04.6 | Un usuario no puede eliminar reservas que no le pertenezcan. |
| RF-04.7 | Si el usuario no tiene reservas, el sistema debe mostrar un mensaje informativo con un acceso directo al dashboard. |

---

## 2. Requerimientos No Funcionales

### RNF-01 · Seguridad

| ID | Requerimiento |
|---|---|
| RNF-01.1 | Todas las rutas de la aplicación (excepto `/login` y `/registro`) deben requerir autenticación. |
| RNF-01.2 | La sesión del usuario debe expirar automáticamente tras 30 minutos de inactividad. |
| RNF-01.3 | Un usuario autenticado no puede acceder ni modificar datos de otros usuarios. |

---

### RNF-02 · Usabilidad

| ID | Requerimiento |
|---|---|
| RNF-02.1 | La interfaz debe ser responsive y adaptarse a dispositivos móviles y de escritorio. |
| RNF-02.2 | Los errores de validación deben mostrarse de forma clara e inmediata al usuario, sin recargar la página. |
| RNF-02.3 | Las acciones destructivas (eliminar reserva) deben requerir confirmación explícita del usuario. |
| RNF-02.4 | El tiempo de respuesta de las operaciones principales no debe superar los 3 segundos en condiciones normales. |

---

### RNF-03 · Tecnología

| ID | Requerimiento |
|---|---|
| RNF-03.1 | El backend debe desarrollarse con Java 17 y Spring Boot 3.2.5. |
| RNF-03.2 | La base de datos debe ser MySQL 8.0. |
| RNF-03.3 | El motor de plantillas debe ser Thymeleaf. |
| RNF-03.4 | El frontend debe desarrollarse con HTML5, CSS3 y Vanilla JavaScript (sin frameworks JS externos). |
| RNF-03.5 | La herramienta de build debe ser Apache Maven. |

---

### RNF-04 · Mantenibilidad

| ID | Requerimiento |
|---|---|
| RNF-04.1 | El proyecto debe seguir una arquitectura en capas: Controller → Service → Repository → Entity. |
| RNF-04.2 | El código debe estar documentado con comentarios que expliquen las decisiones de diseño. |
| RNF-04.3 | Las entidades del dominio original deben estar presentes en el proyecto aunque no estén todas mapeadas a la base de datos. |

---

## 3. Restricciones

- El sistema es un MVP académico; las contraseñas se almacenan en texto plano intencionalmente para simplificar la implementación. En un entorno de producción se debe utilizar `BCryptPasswordEncoder`.
- No se implementa Spring Security en esta versión del MVP.
- La gestión de la sesión se realiza mediante `HttpSession` de Jakarta Servlet.
