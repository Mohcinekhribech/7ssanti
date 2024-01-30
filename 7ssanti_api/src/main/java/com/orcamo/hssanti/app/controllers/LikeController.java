package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.implimentation.LikeService;
import com.orcamo.hssanti.shareable.ResponseMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("like")
@AllArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final ResponseMessage responseMessage;
    @PostMapping("/{articleId}/{clientId}")
    public ResponseEntity<ResponseMessage> addLiketoAnArticle(@PathVariable Integer articleId, @PathVariable Integer clientId)
    {
        likeService.addLiketoAnArticle(articleId,clientId);
        responseMessage.setMessage("article liked");
        return ResponseEntity.ok().body(responseMessage);
    }
    @DeleteMapping("/{articleId}/{clientId}")
    public ResponseEntity<ResponseMessage> removeLikeFromAPost(@PathVariable Integer articleId, @PathVariable Integer clientId)
    {
        likeService.removeLikeFromAPost(articleId,clientId);
        responseMessage.setMessage("like removed from post");
        return ResponseEntity.ok().body(responseMessage);
    }
}