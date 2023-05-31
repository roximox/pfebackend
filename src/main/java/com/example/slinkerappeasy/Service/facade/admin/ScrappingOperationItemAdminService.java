package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.ScrappingOperationItem;

import java.util.List;

public interface ScrappingOperationItemAdminService  {

    List<ScrappingOperationItem> findByScrappingLinkId(Long id);
    int deleteByScrappingLinkId(Long id);
    List<ScrappingOperationItem> findByTypeProduitId(Long id);
    int deleteByTypeProduitId(Long id);
    List<ScrappingOperationItem> findByScrappingOperationId(Long id);
    int deleteByScrappingOperationId(Long id);



}
