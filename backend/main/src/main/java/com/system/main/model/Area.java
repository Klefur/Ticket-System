package com.system.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne(mappedBy = "area")
    @JsonIgnore
    private Ticket ticket;
    @OneToOne(mappedBy = "area")
    @JsonIgnore
    private Usuario usuario;

    public Area(Long id) {
        this.id = id;
    }
}
