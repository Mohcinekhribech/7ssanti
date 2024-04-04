package com.orcamo.hssanti.app.entities;

import com.orcamo.hssanti.security.User.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "client")
    private List<Comment> comments;
    @ManyToMany(mappedBy = "likes")
    private List<Article> articlesLiked = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations ;
    @OneToMany(mappedBy = "client")
    private List<Rate> rates ;
}
