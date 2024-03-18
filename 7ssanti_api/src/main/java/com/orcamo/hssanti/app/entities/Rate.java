package com.orcamo.hssanti.app.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rate;
    private String note;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
}
