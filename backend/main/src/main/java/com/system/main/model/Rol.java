package com.system.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter private Long id;

    @Getter @Setter private String nombre;
    @OneToOne(mappedBy = "rol")
    @JsonIgnore
    private Usuario usuario;

    public Rol(Long id) {
        this.id = id;
    }
}
