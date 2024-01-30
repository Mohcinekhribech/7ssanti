package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.ArticleReq;
import com.orcamo.hssanti.app.dtos.response.ArticleResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface ArticleServiceInterface extends CrudInterface<ArticleReq, ArticleResp,Integer> {
}
