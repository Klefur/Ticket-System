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
    @Getter @Setter private String rut;
    @Getter @Setter private String correo;
    @Getter @Setter private String prioridad;
    @Getter @Setter private String asunto;
    @ManyToOne
    @JoinColumn(name = "encargado")
    private Usuario encargado;
    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

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

    public Usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(Long id) {
        this.encargado = new Usuario(id);
    }
}
