package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ArticleReq;
import com.orcamo.hssanti.app.dtos.response.ArticleResp;
import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.ArticleRepository;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.services.interfaces.ArticleServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService implements ArticleServiceInterface {
    private final ArticleRepository articleRepository;
    private final BarberRepository barberRepository;
    private final ModelMapper modelMapper;

    @Override
    public ArticleResp create(ArticleReq articleReq) {
        Optional<Barber> barberOptional = barberRepository.findById(articleReq.getBarber_id());
        return barberOptional.map(barber -> {
            Article article = modelMapper.map(articleReq, Article.class);
            article.setBarber(barber);
            article = articleRepository.save(article);
            return modelMapper.map(article, ArticleResp.class);
        }).orElse(null);
    }

    @Override
    public ArticleResp update(ArticleReq articleReq, Integer id) {
        Optional<Article> articleOptional = articleRepository.findById(id);

        return articleOptional.map(articleOpt -> {
            Optional<Barber> barberOptional = barberRepository.findById(articleReq.getId());

            return barberOptional.map(barber -> {
                Article article = modelMapper.map(articleReq, Article.class);
                article.setBarber(barber);
                article.setId(articleOpt.getId());
                article = articleRepository.save(article);

                return modelMapper.map(article, ArticleResp.class);
            }).orElse(null);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        return articleOptional.map(article -> {
                    articleRepository.delete(article);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<ArticleResp> getAll() {
        return articleRepository.findAll().stream().map(article -> modelMapper.map(article,ArticleResp.class)).collect(Collectors.toList());
    }

    @Override
    public ArticleResp getOne(Integer id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        return modelMapper.map(articleOptional.orElse(null),ArticleResp.class);
    }
}