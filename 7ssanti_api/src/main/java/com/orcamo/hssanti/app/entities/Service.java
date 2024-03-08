package com.orcamo.hssanti.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer timeIstimation;
    private Integer price;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barber_id")
    public Barber barber;
    @ManyToMany(mappedBy = "services")
    private List<Reservation> reservations = new ArrayList<>();
}
