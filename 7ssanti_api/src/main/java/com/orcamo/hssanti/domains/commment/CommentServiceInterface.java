package com.orcamo.hssanti.domains.commment;

import com.orcamo.hssanti.domains.commment.dtos.CommentReq;
import com.orcamo.hssanti.domains.commment.dtos.CommentResp;
import com.orcamo.hssanti.shareable.CrudInterface;

public interface CommentServiceInterface extends CrudInterface<CommentReq, CommentResp,Integer> {
}
