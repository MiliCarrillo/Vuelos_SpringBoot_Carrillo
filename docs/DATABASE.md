# 🗄 Base de Datos

## Sistema de Reserva de Vuelos — Spring Boot

---

## 1. Configuración

| Parámetro | Valor |
|---|---|
| Motor | MySQL 8.0 |
| Nombre de la BD | `reserva_vuelos` |
| Charset | `utf8mb4` |
| Collation | `utf8mb4_unicode_ci` |
| ORM | Hibernate 6 / Spring Data JPA |
| DDL | `spring.jpa.hibernate.ddl-auto=update` |

---

## 2. Creación de la Base de Datos

```sql
CREATE DATABASE reserva_vuelos
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
```

---

## 3. Diagrama de Tablas

```
┌──────────────────┐        ┌──────────────────────────────────────────┐
│    usuarios      │        │                  vuelos                  │
├──────────────────┤        ├──────────────────────────────────────────┤
│ id          BIGINT PK │   │ id          BIGINT PK AUTO_INCREMENT     │
│ username    VARCHAR(50) UNIQUE │ nro_vuelo  INT UNIQUE              │
│ password    VARCHAR(255) │  │ destino     VARCHAR(100)              │
│ correo_electronico VARCHAR(100) UNIQUE │ piloto VARCHAR(100)        │
│ nombre      VARCHAR(50) │  │ fecha       DATE                       │
│ apellido    VARCHAR(50) │  │ aerolinea   VARCHAR(100)               │
└────────┬─────────┘        │ aeropuerto  VARCHAR(100)               │
         │                  │ nro_avion   INT                         │
         │                  └──────────────┬───────────────────────────┘
         │                                 │
         │       ┌─────────────────────────┘
         │       │
         ▼       ▼
┌──────────────────────────────────────────────┐
│                   reservas                   │
├──────────────────────────────────────────────┤
│ id             BIGINT PK AUTO_INCREMENT      │
│ nro_reserva    INT UNIQUE                    │
│ usuario_id     BIGINT FK → usuarios.id       │
│ vuelo_id       BIGINT FK → vuelos.id         │
│ metodo_pago    ENUM(...)                     │
│ fecha_reserva  DATETIME                      │
└──────────────────────────────────────────────┘
```

---

## 4. Descripción de Tablas

### 4.1 `usuarios`

| Columna | Tipo | Restricciones | Descripción |
|---|---|---|---|
| `id` | BIGINT | PK, AUTO_INCREMENT | Identificador único |
| `username` | VARCHAR(50) | NOT NULL, UNIQUE | Nombre de usuario para login |
| `password` | VARCHAR(255) | NOT NULL | Contraseña del usuario |
| `correo_electronico` | VARCHAR(100) | NOT NULL, UNIQUE | Email del usuario |
| `nombre` | VARCHAR(50) | NOT NULL | Nombre de pila |
| `apellido` | VARCHAR(50) | NOT NULL | Apellido |

---

### 4.2 `vuelos`

| Columna | Tipo | Restricciones | Descripción |
|---|---|---|---|
| `id` | BIGINT | PK, AUTO_INCREMENT | Identificador único |
| `nro_vuelo` | INT | NOT NULL, UNIQUE | Número identificador del vuelo |
| `destino` | VARCHAR(100) | NOT NULL | Ciudad de destino |
| `piloto` | VARCHAR(100) | NOT NULL | Nombre completo del piloto |
| `fecha` | DATE | NOT NULL | Fecha del vuelo |
| `aerolinea` | VARCHAR(100) | NOT NULL | Nombre de la aerolínea |
| `aeropuerto` | VARCHAR(100) | NOT NULL | Nombre del aeropuerto |
| `nro_avion` | INT | NOT NULL | Número identificador del avión |

---

### 4.3 `reservas`

| Columna | Tipo | Restricciones | Descripción |
|---|---|---|---|
| `id` | BIGINT | PK, AUTO_INCREMENT | Identificador único |
| `nro_reserva` | INT | NOT NULL, UNIQUE | Número de 6 dígitos generado aleatoriamente |
| `usuario_id` | BIGINT | NOT NULL, FK | Referencia al usuario que realizó la reserva |
| `vuelo_id` | BIGINT | NOT NULL, FK | Referencia al vuelo reservado |
| `metodo_pago` | ENUM | NOT NULL | Método de pago seleccionado |
| `fecha_reserva` | DATETIME | NOT NULL | Fecha y hora en que se realizó la reserva |

#### Valores del ENUM `metodo_pago`

| Valor | Descripción |
|---|---|
| `TARJETA_CREDITO` | Tarjeta de Crédito |
| `TARJETA_DEBITO` | Tarjeta de Débito |
| `TRANSFERENCIA` | Transferencia Bancaria |
| `EFECTIVO` | Efectivo en Aeropuerto |

---

## 5. Relaciones

| Relación | Tipo | Descripción |
|---|---|---|
| `reservas.usuario_id → usuarios.id` | ManyToOne | Un usuario puede tener múltiples reservas |
| `reservas.vuelo_id → vuelos.id` | ManyToOne | Un vuelo puede tener múltiples reservas |

---

## 6. Datos de Ejemplo (DataInitializer)

Al primer arranque de la aplicación, se insertan automáticamente los siguientes vuelos:

```sql
INSERT INTO vuelos (nro_vuelo, destino, piloto, fecha, aerolinea, aeropuerto, nro_avion) VALUES
(1001, 'Buenos Aires',   'Carlos Rodríguez', '2025-08-15', 'Aerolíneas Argentinas', 'Aeroparque Jorge Newbery', 301),
(1002, 'Mendoza',        'Ana García',        '2025-08-18', 'Aerolíneas Argentinas', 'Aeropuerto El Plumerillo', 302),
(1003, 'Bariloche',      'Luis Fernández',    '2025-08-20', 'LATAM Airlines',        'Aeropuerto Teniente Candelaria', 401),
(1004, 'Córdoba',        'María López',       '2025-08-22', 'Flybondi',              'Aeropuerto Ambrosio Taravella', 201),
(1005, 'Ushuaia',        'Roberto Silva',     '2025-08-25', 'Aerolíneas Argentinas', 'Aeropuerto Malvinas Argentinas', 503),
(1006, 'Salta',          'Elena Martínez',    '2025-09-01', 'JetSMART',              'Aeropuerto Martín Miguel de Güemes', 150),
(1007, 'Mar del Plata',  'Jorge Pérez',       '2025-09-05', 'Flybondi',              'Aeropuerto Ástor Piazzolla', 202);
```

> Para cargar datos propios desde MySQL Workbench, eliminá o comentá la clase `DataInitializer.java`.

---

## 7. Consultas Útiles

```sql
-- Ver todos los vuelos
SELECT * FROM vuelos ORDER BY fecha;

-- Ver todas las reservas con detalle
SELECT r.nro_reserva, u.username, v.destino, v.nro_vuelo,
       r.metodo_pago, r.fecha_reserva
FROM reservas r
JOIN usuarios u ON r.usuario_id = u.id
JOIN vuelos   v ON r.vuelo_id   = v.id
ORDER BY r.fecha_reserva DESC;

-- Ver reservas de un usuario específico
SELECT * FROM reservas
WHERE usuario_id = (SELECT id FROM usuarios WHERE username = 'milagros');
```
