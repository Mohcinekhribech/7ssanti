package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.CommentReq;
import com.orcamo.hssanti.app.dtos.response.CommentResp;
import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.Client;
import com.orcamo.hssanti.app.entities.Comment;
import com.orcamo.hssanti.app.repositories.ArticleRepository;
import com.orcamo.hssanti.app.repositories.ClientRepository;
import com.orcamo.hssanti.app.repositories.CommentRepository;
import com.orcamo.hssanti.app.services.interfaces.CommentServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService implements CommentServiceInterface {
    private final CommentRepository commentRepository;
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    @Override
    public CommentResp create(CommentReq commentReq) {
        return getCommentResp(commentReq);
    }

    @Override
    public CommentResp update(CommentReq commentReq, Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(comment2 -> {
            return getCommentResp(commentReq);
        }).orElse(null);
    }

    private CommentResp getCommentResp(CommentReq commentReq) {
        Optional<Article> article = articleRepository.findById(commentReq.getArticle_id());
        Optional<Client> client = clientRepository.findById(commentReq.getClient_id());
        return article.flatMap(article1 -> client.map(client1 -> {
            Comment comment1 = modelMapper.map(commentReq, Comment.class);
            comment1.setArticle(article1);
            comment1.setClient(client1);
            return modelMapper.map(commentRepository.save(comment1), CommentResp.class);
        })).orElse(null);
    }

    @Override
    public Integer delete(Integer id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        return commentOptional.map(comment -> {
                    commentRepository.delete(comment);
                    return 1;
                })
                .orElse(0);
    }

    @Override
    public List<CommentResp> getAll() {
        return commentRepository.findAll().stream().map(comment -> modelMapper.map(comment, CommentResp.class)).collect(Collectors.toList());
    }

    @Override
    public CommentResp getOne(Integer id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        return modelMapper.map(commentOptional.orElse(null),CommentResp.class);
    }
}
