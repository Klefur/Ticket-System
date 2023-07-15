package com.system.main.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ticket")
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter private Long id;

    @Column(nullable = false)
    @Getter @Setter private String nombre;
    @Column(nullable = false)
    @Getter @Setter private String apellido;
    @Column(unique = true, nullable = false)
    @Getter @Setter private String rut;
    @Column(nullable = false)
    @Getter @Setter private String correo;
    @Column(nullable = false)
    private String asunto;
    @OneToOne
    @JoinColumn(name = "id_area")
    private Area area;
    @OneToOne
    @JoinColumn(name = "id_estado",nullable = false)
    private Estado estado;

    public Ticket(String nombre, String apellido, String rut, String correo, String asunto, Long area, Long estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.asunto = asunto;
        this.area = new Area(area);
        this.estado = new Estado(estado);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Long id) {
        this.estado = new Estado(id);
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Long id) {
        this.area = new Area(id);
    }
}
