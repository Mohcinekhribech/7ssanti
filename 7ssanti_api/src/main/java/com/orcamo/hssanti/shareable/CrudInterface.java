package com.orcamo.hssanti.shareable;

import java.util.List;

public interface CrudInterface <DTOReq,DTOResp,id>{
    DTOResp create(DTOReq dtoReq);
    DTOResp update(DTOReq dtoReq,id id);
    Integer delete(id id);
    List<DTOResp> getAll();
    DTOResp getOne(id id);
}
