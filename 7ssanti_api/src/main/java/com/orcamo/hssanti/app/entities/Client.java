package com.orcamo.hssanti.app.entities;

import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.Comment;
import com.orcamo.hssanti.security.User.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Client extends User {
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "client")
    private List<Comment> comments;
    @ManyToMany(mappedBy = "likes")
    private List<Article> articlesLiked = new ArrayList<>();
}
