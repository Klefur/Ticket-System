package com.system.main.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(nullable = false)
    @Getter @Setter private String clave;
    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    @OneToOne
    @JoinColumn(name = "id_area", nullable = true)
    private Area area;


    public Usuario(String nombre, String apellido, String rut, String correo, String clave, Long rol, Long area) {
        if (area == null) {
            rol = 1L;
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.clave = clave;
        this.area = new Area(area);
        this.rol = new Rol(rol);
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
