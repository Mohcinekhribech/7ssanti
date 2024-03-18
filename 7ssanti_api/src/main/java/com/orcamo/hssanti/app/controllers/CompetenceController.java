package com.orcamo.hssanti.app.controllers;

import com.orcamo.hssanti.app.dtos.request.CompetenceReq;
import com.orcamo.hssanti.app.dtos.response.CompetenceResp;
import com.orcamo.hssanti.app.services.interfaces.CompetenceServiceInterface;
import com.orcamo.hssanti.shareable.CrudController;
import com.orcamo.hssanti.shareable.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competence")
public class CompetenceController extends CrudController<CompetenceReq, CompetenceResp , Integer , CompetenceServiceInterface> {
    public CompetenceController(CompetenceServiceInterface competenceServiceInterface, ResponseMessage responseMessage) {
        super(competenceServiceInterface, responseMessage);
    }

    @PutMapping("/verfied/{id}")
    public ResponseEntity<Boolean> competenceVerified(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(this.service.competenceVerified(id));
    }
}
