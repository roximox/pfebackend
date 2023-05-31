package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.ScrappingOperationItem;
import com.example.slinkerappeasy.Service.facade.admin.ScrappingOperationItemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/scrappingOperationItem/")
public class ScrappingOperationItemRestAdmin {

    @GetMapping("id/{id}")
    public List<ScrappingOperationItem> findByScrappingLinkId(@PathVariable Long id) {
        return scrappingOperationItemAdminService.findByScrappingLinkId(id);
    }

    @DeleteMapping("id/{id}")
    public int deleteByScrappingLinkId(@PathVariable Long id) {
        return scrappingOperationItemAdminService.deleteByScrappingLinkId(id);
    }

    @GetMapping("")
    public List<ScrappingOperationItem> findByTypeProduitId(@PathVariable Long id) {
        return scrappingOperationItemAdminService.findByTypeProduitId(id);
    }

    @DeleteMapping("typeProduit/id/{id}")
    public int deleteByTypeProduitId(@PathVariable Long id) {
        return scrappingOperationItemAdminService.deleteByTypeProduitId(id);
    }

    @GetMapping("operation/id/{id}")
    public List<ScrappingOperationItem> findByScrappingOperationId(@PathVariable Long id) {
        return scrappingOperationItemAdminService.findByScrappingOperationId(id);
    }

    @DeleteMapping("operation/id/{id}")
    public int deleteByScrappingOperationId(@PathVariable Long id) {
        return scrappingOperationItemAdminService.deleteByScrappingOperationId(id);
    }

    @Autowired
    public ScrappingOperationItemAdminService scrappingOperationItemAdminService;
}

