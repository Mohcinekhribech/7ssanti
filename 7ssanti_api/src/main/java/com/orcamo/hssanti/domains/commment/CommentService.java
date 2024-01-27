package com.orcamo.hssanti.domains.commment;

import com.orcamo.hssanti.domains.commment.dtos.CommentReq;
import com.orcamo.hssanti.domains.commment.dtos.CommentResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface{
    @Override
    public CommentResp create(CommentReq commentReq) {
        return null;
    }

    @Override
    public CommentResp update(CommentReq commentReq, Integer integer) {
        return null;
    }

    @Override
    public Integer delete(Integer integer) {
        return null;
    }

    @Override
    public List<CommentResp> getAll() {
        return null;
    }

    @Override
    public CommentResp getOne(Integer integer) {
        return null;
    }
}
