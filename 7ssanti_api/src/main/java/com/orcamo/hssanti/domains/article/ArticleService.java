package com.orcamo.hssanti.domains.article;

import com.orcamo.hssanti.domains.article.dtos.ArticleReq;
import com.orcamo.hssanti.domains.article.dtos.ArticleResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements ArticleServiceInterface{
    @Override
    public ArticleResp create(ArticleReq articleReq) {
        return null;
    }

    @Override
    public ArticleResp update(ArticleReq articleReq, Integer integer) {
        return null;
    }

    @Override
    public Integer delete(Integer integer) {
        return null;
    }

    @Override
    public List<ArticleResp> getAll() {
        return null;
    }

    @Override
    public ArticleResp getOne(Integer integer) {
        return null;
    }
}
