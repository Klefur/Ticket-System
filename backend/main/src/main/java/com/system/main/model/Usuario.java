package com.system.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "usuario")
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter private Long id;

    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Column(unique = true, nullable = false)
    @Getter @Setter private String rut;
    @Getter @Setter private String correo;
    @Getter @Setter private String clave;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;
    @OneToMany(mappedBy = "encargado")
    @JsonIgnore
    private List<Ticket> tickets;


    public Usuario(Long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Long id) {
        rol = new Rol(id);
    }

    public Area getArea() {
        return area;
    }

    public  void setArea(Long id) {
        area = new Area(id);
    }
}
