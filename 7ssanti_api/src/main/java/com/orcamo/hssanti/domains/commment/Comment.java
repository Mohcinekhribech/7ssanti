package com.orcamo.hssanti.domains.commment;

import com.orcamo.hssanti.domains.article.Article;
import com.orcamo.hssanti.domains.users.client.Client;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
