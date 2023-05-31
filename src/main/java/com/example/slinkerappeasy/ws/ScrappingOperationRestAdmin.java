package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.ScrappingOperation;
import com.example.slinkerappeasy.Service.impl.admin.ScrappingOperationAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/scrappingOperation/")
public class ScrappingOperationRestAdmin {

@GetMapping("affliate/id/{id}")
    public List<ScrappingOperation> findByAffliateId(@PathVariable Long id) {
        return scrappingOperationAdminService.findByAffliateId(id);
    }
@DeleteMapping("affliate/id/{id}")
    public int deleteByAffliateId(@PathVariable Long id) {
        return scrappingOperationAdminService.deleteByAffliateId(id);
    }
@GetMapping("website/id/{id}")
    public List<ScrappingOperation> findByWebSiteId(@PathVariable Long id) {
        return scrappingOperationAdminService.findByWebSiteId(id);
    }
@DeleteMapping("website/id/{id}")
    public int deleteByWebSiteId(@PathVariable Long id) {
        return scrappingOperationAdminService.deleteByWebSiteId(id);
    }
@GetMapping("")
    public List<ScrappingOperation> findAll() {
        return scrappingOperationAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody ScrappingOperation scrappingOperation) {
        return scrappingOperationAdminService.save(scrappingOperation);
    }
@PutMapping("")
    public int update(@RequestBody ScrappingOperation scrappingOperation) {
        return scrappingOperationAdminService.update(scrappingOperation);
    }

    @Autowired
    public ScrappingOperationAdminServiceImpl scrappingOperationAdminService;

}