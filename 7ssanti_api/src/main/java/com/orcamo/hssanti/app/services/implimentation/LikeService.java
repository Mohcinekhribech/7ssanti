package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.repositories.ArticleRepository;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.services.interfaces.LikeServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeService implements LikeServiceInterface {
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;
    @Override
    public void addLiketoAnArticle(Integer articleId, Integer clientId) {
        Article article = articleRepository.findById(articleId).orElseThrow(EntityNotFoundException::new);
        Client client = clientRepository.findById(clientId).orElseThrow(EntityNotFoundException::new);

        article.getLikes().add(client);
        client.getArticlesLiked().add(article);

        articleRepository.save(article);
        clientRepository.save(client);
    }

    @Override
    public void removeLikeFromAPost(Integer articleId, Integer clientId) {
        Article article = articleRepository.findById(articleId).orElseThrow(EntityNotFoundException::new);
        Client client = clientRepository.findById(clientId).orElseThrow(EntityNotFoundException::new);

        article.getLikes().remove(client);
        client.getArticlesLiked().remove(article);

        articleRepository.save(article);
        clientRepository.save(client);
    }
}
