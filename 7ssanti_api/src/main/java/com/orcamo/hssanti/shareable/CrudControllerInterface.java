package com.orcamo.hssanti.shareable;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrudControllerInterface <DTOReq,DTOResp,Id> {
    @PostMapping
    ResponseEntity<DTOResp> create(@Valid @RequestBody DTOReq dtoReq) ;
    @PutMapping("/{id}")
    ResponseEntity<DTOResp> update(@Valid @RequestBody DTOReq dtoReq,@PathVariable Id id) ;

    @DeleteMapping("/{id}")
    ResponseEntity<Object> delete(@PathVariable Id id) ;

    @GetMapping
    ResponseEntity<List<DTOResp>> getAll() ;

    @GetMapping("/{id}")
    ResponseEntity<DTOResp> getOne(@PathVariable Id id) ;
}
