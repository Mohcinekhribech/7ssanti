package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.CommentReq;
import com.orcamo.hssanti.app.dtos.response.CommentResp;
import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.entities.Comment;
import com.orcamo.hssanti.app.repositories.ArticleRepository;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.repositories.CommentRepository;
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

class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private CommentService commentService;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        commentService = new CommentService(commentRepository, clientRepository, articleRepository, modelMapper);
    }

    @Test
    void testCreate() {
        // Arrange
        Article article = new Article();
        article.setId(1);
        Client client = new Client();
        client.setId(1);
        CommentReq commentReq = new CommentReq();
        commentReq.setArticle_id(1);
        commentReq.setClient_id(1);
        Comment comment = modelMapper.map(commentReq, Comment.class);
        comment.setArticle(article);
        comment.setClient(client);
        CommentResp expectedResp = modelMapper.map(comment, CommentResp.class);

        when(articleRepository.findById(1)).thenReturn(Optional.of(article));
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        // Act
        CommentResp result = commentService.create(commentReq);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        Article article = new Article();
        article.setId(1);
        Client client = new Client();
        client.setId(1);
        Comment existingComment = new Comment();
        existingComment.setId(1);
        CommentReq commentReq = new CommentReq();
        commentReq.setArticle_id(1);
        commentReq.setClient_id(1);
        Comment updatedComment = modelMapper.map(commentReq, Comment.class);
        updatedComment.setArticle(article);
        updatedComment.setClient(client);
        CommentResp expectedResp = modelMapper.map(updatedComment, CommentResp.class);

        when(commentRepository.findById(1)).thenReturn(Optional.of(existingComment));
        when(articleRepository.findById(1)).thenReturn(Optional.of(article));
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        when(commentRepository.save(any(Comment.class))).thenReturn(updatedComment);

        // Act
        CommentResp result = commentService.update(commentReq, 1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Comment comment = new Comment();
        comment.setId(1);

        when(commentRepository.findById(1)).thenReturn(Optional.of(comment));

        // Act
        Integer result = commentService.delete(1);

        // Assert
        assertEquals(1, result);
        verify(commentRepository, times(1)).delete(comment);
    }

    @Test
    void testGetAll() {
        // Arrange
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        List<Comment> comments = Arrays.asList(comment1, comment2);
        List<CommentResp> expectedResp = comments.stream()
                .map(c -> modelMapper.map(c, CommentResp.class))
                .toList();

        when(commentRepository.findAll()).thenReturn(comments);

        // Act
        List<CommentResp> result = commentService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }

    @Test
    void testGetOne() {
        // Arrange
        Comment comment = new Comment();
        comment.setId(1);
        CommentResp expectedResp = modelMapper.map(comment, CommentResp.class);

        when(commentRepository.findById(1)).thenReturn(Optional.of(comment));

        // Act
        CommentResp result = commentService.getOne(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResp, result);
    }
}
