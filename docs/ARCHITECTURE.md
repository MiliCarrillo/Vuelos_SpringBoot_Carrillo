# 🏛 Arquitectura del Sistema

## Sistema de Reserva de Vuelos — Spring Boot

---

## 1. Visión General

El sistema sigue una **arquitectura en capas** (Layered Architecture), patrón estándar en aplicaciones Spring Boot MVC. Cada capa tiene una responsabilidad única y solo se comunica con la capa inmediatamente inferior.

```
┌─────────────────────────────────────────┐
│           CAPA DE PRESENTACIÓN          │
│     Thymeleaf + HTML + CSS + JS         │
└────────────────────┬────────────────────┘
                     │ HTTP Request/Response
┌────────────────────▼────────────────────┐
│           CAPA DE CONTROLADORES         │
│  AuthController · DashboardController   │
│  ReservaController · MisReservasCtrl    │
└────────────────────┬────────────────────┘
                     │ Llamadas a métodos
┌────────────────────▼────────────────────┐
│            CAPA DE SERVICIOS            │
│  UsuarioService · VueloService          │
│  ReservaService                         │
└────────────────────┬────────────────────┘
                     │ Spring Data JPA
┌────────────────────▼────────────────────┐
│           CAPA DE REPOSITORIOS          │
│  UsuarioRepository · VueloRepository    │
│  ReservaRepository                      │
└────────────────────┬────────────────────┘
                     │ Hibernate ORM
┌────────────────────▼────────────────────┐
│           BASE DE DATOS MySQL           │
│  usuarios · vuelos · reservas           │
└─────────────────────────────────────────┘
```

---

## 2. Descripción de Capas

### 2.1 Capa de Presentación
- Archivos Thymeleaf (`.html`) ubicados en `resources/templates/`
- Archivos estáticos (CSS, JS) en `resources/static/`
- Responsable de renderizar la UI y capturar la entrada del usuario
- Vanilla JavaScript para validaciones del lado del cliente y llamadas Fetch API

### 2.2 Capa de Controladores
- Clases anotadas con `@Controller`
- Reciben las peticiones HTTP, invocan servicios y retornan vistas o respuestas JSON
- Gestionan el guard de sesión en cada endpoint protegido
- `ReservaController` usa `@ResponseBody` para devolver JSON al frontend (modal de éxito)

### 2.3 Capa de Servicios
- Clases anotadas con `@Service` y `@Transactional`
- Contienen toda la lógica de negocio
- Son el único punto de entrada a los repositorios
- Realizan validaciones de negocio (unicidad de reserva, pertenencia al usuario, etc.)

### 2.4 Capa de Repositorios
- Interfaces que extienden `JpaRepository<Entity, Long>`
- Spring Data JPA genera la implementación automáticamente
- Incluyen métodos de consulta derivados del nombre del método (query methods)

### 2.5 Capa de Entidades
- Clases anotadas con `@Entity` para las 3 tablas activas
- POJOs sin anotaciones JPA para el resto del modelo de dominio original
- Refleja la jerarquía de herencia del proyecto original (Persona → Usuario/Piloto, Pago → Tarjeta)

---

## 3. Decisiones de Diseño

### 3.1 Mapeo Selectivo de Entidades
**Decisión:** solo se mapearon a la base de datos las entidades estrictamente necesarias para el flujo de reserva (`Usuario`, `Vuelo`, `Reserva`).

**Justificación:** el proyecto original tenía una cadena de relaciones compleja (`Vuelo → Aeropuerto → Ciudad`, `Vuelo → Piloto → Persona`, etc.) que hubiera generado múltiples JOINs y tablas innecesarias para el MVP. Los campos de display se aplanaron directamente en la entidad `Vuelo`.

---

### 3.2 Autenticación por Sesión HTTP
**Decisión:** se usa `HttpSession` de Jakarta Servlet en lugar de Spring Security.

**Justificación:** Spring Security agrega complejidad de configuración significativa que excede el alcance de un MVP. La sesión HTTP es suficiente para proteger los endpoints y mantener el estado del usuario autenticado.

---

### 3.3 Confirmación de Reserva vía Fetch API
**Decisión:** el POST de `/reservar` devuelve JSON y es consumido por JavaScript.

**Justificación:** permite mostrar el modal de confirmación con el número de reserva sin recargar la página, mejorando la experiencia de usuario. Si el JS estuviera deshabilitado, el formulario podría adaptarse a un POST tradicional.

---

### 3.4 DataInitializer
**Decisión:** se precargaron 7 vuelos de ejemplo al primer arranque usando `CommandLineRunner`.

**Justificación:** permite evaluar el sistema inmediatamente sin necesidad de insertar datos manualmente en MySQL Workbench.

---

## 4. Flujo de una Reserva (Secuencia)

```
Usuario          AuthController     DashboardCtrl     ReservaCtrl      ReservaService      DB
   │                   │                 │                 │                  │              │
   │── GET /login ────►│                 │                 │                  │              │
   │◄─ login.html ─────│                 │                 │                  │              │
   │── POST /login ───►│                 │                 │                  │              │
   │                   │── autenticar() ─────────────────────────────────────►│              │
   │                   │◄─ Usuario ──────────────────────────────────────────│              │
   │◄─ redirect /dashboard ────────────►│                 │                  │              │
   │── GET /dashboard ──────────────────►│                 │                  │              │
   │◄─ dashboard.html (vuelos) ─────────│                 │                  │              │
   │── GET /checkout/{id} ───────────────────────────────►│                  │              │
   │◄─ checkout.html ────────────────────────────────────│                  │              │
   │── POST /reservar (fetch) ───────────────────────────►│                  │              │
   │                   │                 │                 │── crearReserva()►│              │
   │                   │                 │                 │                  │── INSERT ───►│
   │                   │                 │                 │◄─ Reserva ───────│              │
   │◄─ JSON {nroReserva} ───────────────────────────────│                  │              │
   │── (modal) cerrar ───────────────────────────────────►│                  │              │
   │◄─ redirect /dashboard ────────────►│                 │                  │              │
```

---

## 5. Estructura de Paquetes

```
com.vuelos.reservas
├── controller      ← Manejo de HTTP, guards de sesión, respuestas
├── service         ← Lógica de negocio, transacciones
├── repository      ← Acceso a datos (Spring Data JPA)
└── entity          ← Modelo de dominio (JPA + POJOs)
```
