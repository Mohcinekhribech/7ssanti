package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.CommentReq;
import com.orcamo.hssanti.app.dtos.response.CommentResp;
import com.orcamo.hssanti.app.services.interfaces.CommentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface {
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
