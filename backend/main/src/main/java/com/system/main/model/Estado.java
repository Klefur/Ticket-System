package com.system.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne(mappedBy = "estado")
    @JsonIgnore
    private Ticket ticket;

    public Estado(Long id) {
        this.id = id;
    }
}
