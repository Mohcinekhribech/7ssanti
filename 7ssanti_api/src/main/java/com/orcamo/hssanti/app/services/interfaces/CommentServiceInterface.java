package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.CommentReq;
import com.orcamo.hssanti.app.dtos.response.CommentResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface CommentServiceInterface extends CrudInterface<CommentReq, CommentResp,Integer> {
}
