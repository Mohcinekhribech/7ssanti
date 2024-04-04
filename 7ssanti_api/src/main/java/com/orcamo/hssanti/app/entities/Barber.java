package com.orcamo.hssanti.app.entities;

import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.HairSalon;
import com.orcamo.hssanti.app.services.interfaces.ArticleServiceInterface;
import com.orcamo.hssanti.security.User.User;
import com.orcamo.hssanti.shareable.ResponseMessage;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Barber extends User {
    private  Integer yearsOfExperience;
    @OneToMany(mappedBy = "barber")
    private List<Article> articles;
    @OneToMany(mappedBy = "barber")
    private List<Service> services;
    @OneToMany(mappedBy = "barber")
    private List<Competence> competences;
    @ManyToOne
    @JoinColumn(name = "hairSalon_id")
    private HairSalon hairSalon;
    @OneToMany(mappedBy = "barber")
    private List<Rate> rates;
}