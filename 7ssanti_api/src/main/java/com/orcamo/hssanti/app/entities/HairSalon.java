package com.orcamo.hssanti.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class HairSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "hairSalon")
    private List<Barber> barbers;
}
