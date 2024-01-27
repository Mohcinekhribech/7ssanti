package com.orcamo.hssanti.shareable;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public abstract class CrudController<DTOReq,DTOResp,Id,Service extends CrudInterface<DTOReq,DTOResp,Id>> {
    protected Service service;
    protected ResponseMessage responseMessage;

    @PostMapping
    public ResponseEntity<DTOResp> create(@Valid @RequestBody DTOReq dtoReq) {
        DTOResp dtoResp = service.create(dtoReq);
        if(dtoResp != null)
        {
            return ResponseEntity.ok().body(dtoResp);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOResp> update(@Valid @RequestBody DTOReq dtoReq,@PathVariable Id id) {
        DTOResp dtoResp = service.update(dtoReq,id);
        if(dtoResp != null)
        {
            return ResponseEntity.ok().body(dtoResp);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Id id) {
        Integer deleted = service.delete(id);
        if(deleted == 1)
        {
            this.responseMessage.setMessage("deleted");
            return ResponseEntity.ok().body(this.responseMessage);
        }
        this.responseMessage.setMessage("not deleted");
        return ResponseEntity.badRequest().body(this.responseMessage);
    }


    @GetMapping
    public ResponseEntity<List<DTOResp>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOResp> getOne(@PathVariable Id id) {
        return ResponseEntity.ok().body(service.getOne(id));
    }
}
