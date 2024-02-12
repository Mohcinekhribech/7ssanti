package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.MediaReq;
import com.orcamo.hssanti.app.dtos.response.MediaResp;
import com.orcamo.hssanti.app.services.interfaces.MediaServiceInterface;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController extends CrudController<MediaReq, MediaResp,Integer, MediaServiceInterface> {
    public MediaController(MediaServiceInterface mediaServiceInterface, ResponseMessage responseMessage) {
        super(mediaServiceInterface, responseMessage);
    }
    @PostMapping("/all")
    public ResponseEntity<List<MediaResp>> create(@Valid @RequestBody List<MediaReq> mediaReq) {
        return ResponseEntity.ok().body(service.saveAll(mediaReq));
    }
}
