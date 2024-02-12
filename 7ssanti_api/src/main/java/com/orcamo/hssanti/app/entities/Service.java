package com.orcamo.hssanti.app.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer timeIstimation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barber_id")
    public Barber barber;
}
