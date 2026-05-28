package com.vuelos.reservas.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int nroReserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vuelo_id", nullable = false)
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private MetodoPago metodoPago;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    // ── Lifecycle ─────────────────────────────────────────────────────────────

    @PrePersist
    public void prePersist() {
        if (this.fechaReserva == null) {
            this.fechaReserva = LocalDateTime.now();
        }
    }

    // ── Constructores ─────────────────────────────────────────────────────────

    public Reserva() {}

    public Reserva(int nroReserva, Vuelo vuelo, Usuario usuario, MetodoPago metodoPago) {
        this.nroReserva = nroReserva;
        this.vuelo = vuelo;
        this.usuario = usuario;
        this.metodoPago = metodoPago;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNroReserva() { return nroReserva; }
    public void setNroReserva(int nroReserva) { this.nroReserva = nroReserva; }

    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }
}
