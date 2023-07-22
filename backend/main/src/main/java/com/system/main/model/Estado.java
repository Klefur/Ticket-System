package com.system.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estado")
@Data
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter private Long id;
    
    @Getter @Setter private String nombre;
    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Ticket> ticket;

    public Estado(Long id) {
        this.id = id;
    }
}
