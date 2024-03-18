package com.orcamo.hssanti.app.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean verified;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
}
