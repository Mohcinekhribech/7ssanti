package com.orcamo.hssanti.app.entities;

import com.orcamo.hssanti.security.User.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}