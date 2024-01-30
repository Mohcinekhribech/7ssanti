package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.services.interfaces.CommentServiceInterface;
import com.orcamo.hssanti.app.dtos.request.CommentReq;
import com.orcamo.hssanti.app.dtos.response.CommentResp;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController extends CrudController<CommentReq, CommentResp,Integer, CommentServiceInterface> {
    public CommentController(CommentServiceInterface commentServiceInterface, ResponseMessage responseMessage) {
        super(commentServiceInterface, responseMessage);
    }
}
