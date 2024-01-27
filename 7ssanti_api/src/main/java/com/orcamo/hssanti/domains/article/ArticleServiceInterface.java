package com.orcamo.hssanti.domains.article;

import com.orcamo.hssanti.domains.article.dtos.ArticleReq;
import com.orcamo.hssanti.domains.article.dtos.ArticleResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface ArticleServiceInterface extends CrudInterface<ArticleReq, ArticleResp,Integer> {
}
