# ✈ Vuelos\_SpringBoot\_Carrillo

> Sistema de Reserva de Vuelos — Migración de Java POO puro a Spring Boot Web

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-green?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.9-red?style=flat-square&logo=apachemaven)
![Estado](https://img.shields.io/badge/Estado-MVP%20Funcional-success?style=flat-square)

\---

## 

## Descripción

Este proyecto es la **migración de un sistema de reserva de vuelos** desarrollado originalmente en Java orientado a objetos puro (sin framework), hacia una **aplicación web completa** utilizando el ecosistema de Spring Boot.

El objetivo fue construir un **MVP (Producto Mínimo Viable)** funcional, enfocado en el flujo de reserva de extremo a extremo, aplicando arquitectura en capas, persistencia con JPA/Hibernate y una interfaz web limpia con Thymeleaf.

\---

## 

## &#x20;Funcionalidades

|Funcionalidad|Estado|
|-|-|
|Registro de usuarios|✅|
|Inicio de sesión con sesión HTTP|✅|
|Dashboard con vuelos disponibles|✅|
|Checkout con selector de método de pago|✅|
|Generación de número de reserva único|✅|
|Modal de confirmación de reserva|✅|
|Sección "Mis Reservas" por usuario|✅|
|Eliminación de reservas con confirmación|✅|
|Validaciones del lado del cliente (JS)|✅|
|Datos de ejemplo precargados al iniciar|✅|

\---

## Estructura del Proyecto

```
Vuelos\_SpringBoot\_Carrillo/
├── src/
│   └── main/
│       ├── java/com/vuelos/reservas/
│       │   ├── ReservasApplication.java
│       │   ├── controller/
│       │   │   ├── AuthController.java
│       │   │   ├── DashboardController.java
│       │   │   ├── ReservaController.java
│       │   │   ├── MisReservasController.java
│       │   │   └── DataInitializer.java
│       │   ├── entity/
│       │   │   ├── Usuario.java          ← mapeada
│       │   │   ├── Vuelo.java            ← mapeada
│       │   │   ├── Reserva.java          ← mapeada
│       │   │   ├── MetodoPago.java       ← enum mapeado
│       │   │   ├── Persona.java          ← POJO
│       │   │   ├── Piloto.java           ← POJO
│       │   │   ├── Aerolinea.java        ← POJO
│       │   │   ├── Aeropuerto.java       ← POJO
│       │   │   ├── Ciudad.java           ← POJO
│       │   │   ├── Avion.java            ← POJO
│       │   │   ├── Asiento.java          ← POJO
│       │   │   ├── Tarifa.java           ← POJO
│       │   │   ├── Tarjeta.java          ← POJO
│       │   │   ├── Pago.java             ← POJO
│       │   │   ├── Fecha.java            ← POJO
│       │   │   ├── Consulta.java         ← POJO
│       │   │   ├── Clase.java            ← enum
│       │   │   ├── TipoTarjeta.java      ← enum
│       │   │   └── Especificacion.java   ← interface
│       │   ├── repository/
│       │   │   ├── UsuarioRepository.java
│       │   │   ├── VueloRepository.java
│       │   │   └── ReservaRepository.java
│       │   └── service/
│       │       ├── UsuarioService.java
│       │       ├── VueloService.java
│       │       └── ReservaService.java
│       └── resources/
│           ├── application.properties
│           ├── templates/
│           │   ├── login.html
│           │   ├── registro.html
│           │   ├── dashboard.html
│           │   ├── checkout.html
│           │   └── mis-reservas.html
│           └── static/
│               ├── css/styles.css
│               └── js/
│                   ├── validaciones.js
│                   └── reserva.js
├── docs/
│   ├── REQUIREMENTS.md
│   ├── ARCHITECTURE.md
│   ├── DATABASE.md
│   └── USER\_GUIDE.md
├── .gitignore
├── pom.xml
└── README.md
```

\---

## 

## Stack Tecnológico

|Capa|Tecnología|
|-|-|
|Backend|Java 17 + Spring Boot 3.2.5|
|Persistencia|Spring Data JPA + Hibernate 6|
|Base de datos|MySQL 8|
|Motor de plantillas|Thymeleaf 3.1|
|Build|Apache Maven|
|Frontend|HTML5 + CSS3 + Vanilla JavaScript|
|IDE|IntelliJ IDEA 2024|

\---

## 

## Requisitos Previos

* Java JDK 17 o superior
* MySQL 8.0 o superior (con MySQL Workbench)
* Apache Maven 3.9+
* IntelliJ IDEA (recomendado)

\---

## 

## Instalación y Configuración

### 1\. Clonar el repositorio

```bash
git clone https://github.com/MiliCarrillo/Vuelos\_SpringBoot\_Carrillo.git
cd Vuelos\_SpringBoot\_Carrillo
```

### 2\. Crear la base de datos en MySQL

Abrí MySQL Workbench y ejecutá:

```sql
CREATE DATABASE reserva\_vuelos
  CHARACTER SET utf8mb4
  COLLATE utf8mb4\_unicode\_ci;
```

### 3\. Configurar credenciales

Editá el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/reserva\_vuelos?useSSL=false\&serverTimezone=UTC\&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=TU\_CONTRASEÑA
```

### 4\. Ejecutar el proyecto

Desde IntelliJ, corré `ReservasApplication.java`, o desde terminal:

```bash
mvn spring-boot:run
```

### 5\. Acceder a la aplicación

```
http://localhost:8080
```

> Al primer arranque, el sistema carga automáticamente 7 vuelos de ejemplo. Registrate con cualquier usuario para comenzar.

\---

## 

## Flujo de Usuario

```
Registro / Login
      ↓
Dashboard (lista de vuelos disponibles)
      ↓
Checkout (selección de método de pago)
      ↓
Modal de confirmación con N° de Reserva
      ↓
Mis Reservas (gestión del historial)
```

\---

## 

## Documentación Adicional

|Documento|Descripción|
|-|-|
|[REQUIREMENTS.md](docs/REQUIREMENTS.md)|Requerimientos funcionales y no funcionales|
|[ARCHITECTURE.md](docs/ARCHITECTURE.md)|Decisiones de arquitectura y diseño|
|[DATABASE.md](docs/DATABASE.md)|Esquema de base de datos|
|[USER\_GUIDE.md](docs/USER_GUIDE.md)|Guía de uso de la aplicación|

\---

## 

## Autora

**Milagros Carrillo**
Proyecto académico — Migración y desarrollo web con Spring Boot

\---

## 

