package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.ScrappingOperation;

import java.util.List;

public interface ScrappingOperationAdminService  {

    List<ScrappingOperation> findByAffliateId(Long id);
    int deleteByAffliateId(Long id);
    List<ScrappingOperation> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);



}
