package com.orcamo.hssanti.app.services.interfaces;

public interface LikeServiceInterface {
    public void addLiketoAnArticle(Integer articleId,Integer clientId);
    public void removeLikeFromAPost(Integer articleId,Integer clientId);
}
