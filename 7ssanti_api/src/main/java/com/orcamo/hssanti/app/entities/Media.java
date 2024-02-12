package com.orcamo.hssanti.app.entities;

import com.orcamo.hssanti.security.User.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mediaLink;
    private MediaType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    public Article article;
}