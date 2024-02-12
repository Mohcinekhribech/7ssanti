package com.orcamo.hssanti.app.services.interfaces;

import com.orcamo.hssanti.app.dtos.request.MediaReq;
import com.orcamo.hssanti.app.dtos.response.MediaResp;
import com.orcamo.hssanti.shareable.CrudInterface;

import java.util.List;

public interface MediaServiceInterface extends CrudInterface<MediaReq, MediaResp , Integer> {
    List<MediaResp> saveAll(List<MediaReq> mediaReqs);
}
