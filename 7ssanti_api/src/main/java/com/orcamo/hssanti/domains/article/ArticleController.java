package com.orcamo.hssanti.domains.article;

import com.orcamo.hssanti.domains.article.dtos.ArticleReq;
import com.orcamo.hssanti.domains.article.dtos.ArticleResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController extends CrudController<ArticleReq, ArticleResp,Integer,ArticleServiceInterface> {
    public ArticleController(ArticleServiceInterface articleServiceInterface, ResponseMessage responseMessage) {
        super(articleServiceInterface, responseMessage);
    }
}
