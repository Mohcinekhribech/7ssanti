package com.orcamo.hssanti.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mediaLink;
    private String description;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "client_article_like",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> likes = new ArrayList<>();
    @OneToMany(mappedBy = "article")
    private List<Media> medias;
}