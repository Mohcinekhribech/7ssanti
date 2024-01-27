package com.orcamo.hssanti.domains.article;

import com.orcamo.hssanti.domains.commment.Comment;
import com.orcamo.hssanti.domains.users.barber.Barber;
import com.orcamo.hssanti.domains.users.client.Client;
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
    @ManyToMany(mappedBy = "articlesLiked")
    private List<Client> likes = new ArrayList<>();
}
