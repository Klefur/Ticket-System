package com.system.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "area")
@Data
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter private Long id;

    @Getter @Setter private String nombre;
    @OneToMany(mappedBy = "area")
    @JsonIgnore
    private List<Ticket> ticket;
    @OneToMany(mappedBy = "area")
    @JsonIgnore
    private List<Usuario> usuario;

    public Area(Long id) {
        this.id = id;
    }
}
