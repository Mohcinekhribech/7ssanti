package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
