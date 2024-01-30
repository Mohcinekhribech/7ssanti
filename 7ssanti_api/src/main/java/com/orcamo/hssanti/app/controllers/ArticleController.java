package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.interfaces.ArticleServiceInterface;
import com.orcamo.hssanti.app.dtos.request.ArticleReq;
import com.orcamo.hssanti.app.dtos.response.ArticleResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController extends CrudController<ArticleReq, ArticleResp,Integer, ArticleServiceInterface> {
    public ArticleController(ArticleServiceInterface articleServiceInterface, ResponseMessage responseMessage) {
        super(articleServiceInterface, responseMessage);
    }
}
