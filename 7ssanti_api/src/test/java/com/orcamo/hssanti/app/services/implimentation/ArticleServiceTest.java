package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.ArticleReq;
import com.orcamo.hssanti.app.dtos.response.ArticleResp;
import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.Barber;
import com.orcamo.hssanti.app.repositories.ArticleRepository;
import com.orcamo.hssanti.app.repositories.BarberRepository;
import com.orcamo.hssanti.app.services.implimentation.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private BarberRepository barberRepository;

    @InjectMocks
    private ArticleService articleService;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        articleService = new ArticleService(articleRepository, barberRepository, modelMapper);
    }

    @Test
    void testCreate() {
        // Arrange
        Barber barber = new Barber();
        barber.setId(1);
        ArticleReq articleReq = new ArticleReq();
        articleReq.setBarber_id(1);
        Article article = modelMapper.map(articleReq, Article.class);
        article.setBarber(barber);
        ArticleResp expectedResp = modelMapper.map(article, ArticleResp.class);

        when(barberRepository.findById(1)).thenReturn(Optional.of(barber));
        when(articleRepository.save(any(Article.class))).thenReturn(article);

        // Act
        ArticleResp result = articleService.create(articleReq);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        Barber barber = new Barber();
        barber.setId(1);
        Article existingArticle = new Article();
        existingArticle.setId(1);
        ArticleReq articleReq = new ArticleReq();
        articleReq.setId(1);
        articleReq.setBarber_id(1);
        Article updatedArticle = modelMapper.map(articleReq, Article.class);
        updatedArticle.setBarber(barber);
        updatedArticle.setId(1);
        ArticleResp expectedResp = modelMapper.map(updatedArticle, ArticleResp.class);

        when(articleRepository.findById(1)).thenReturn(Optional.of(existingArticle));
        when(barberRepository.findById(1)).thenReturn(Optional.of(barber));
        when(articleRepository.save(any(Article.class))).thenReturn(updatedArticle);

        // Act
        ArticleResp result = articleService.update(articleReq, 1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Article article = new Article();
        article.setId(1);

        when(articleRepository.findById(1)).thenReturn(Optional.of(article));

        // Act
        Integer result = articleService.delete(1);

        // Assert
        assertEquals(1, result);
        verify(articleRepository, times(1)).delete(article);
    }

    @Test
    void testGetAll() {
        // Arrange
        Article article1 = new Article();
        Article article2 = new Article();
        List<Article> articles = Arrays.asList(article1, article2);
        List<ArticleResp> expectedResp = articles.stream()
                .map(a -> modelMapper.map(a, ArticleResp.class))
                .toList();

        when(articleRepository.findAll()).thenReturn(articles);

        // Act
        List<ArticleResp> result = articleService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetOne() {
        // Arrange
        Article article = new Article();
        article.setId(1);
        ArticleResp expectedResp = modelMapper.map(article, ArticleResp.class);

        when(articleRepository.findById(1)).thenReturn(Optional.of(article));

        // Act
        ArticleResp result = articleService.getOne(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }
}