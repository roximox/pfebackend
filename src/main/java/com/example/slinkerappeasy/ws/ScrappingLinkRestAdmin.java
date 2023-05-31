package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.ScrappingLink;
import com.example.slinkerappeasy.Service.impl.admin.ScrappingLinkAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/scrappingLink/")
public class ScrappingLinkRestAdmin  {

    @GetMapping("code/{code}")
    public ScrappingLink findByCode(@PathVariable String code) {
        return adminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return adminService.deleteByCode(code);
    }
@GetMapping("id/{id}")
    public List<ScrappingLink> findByWebSiteId(@PathVariable Long id) {
        return adminService.findByWebSiteId(id);
    }
@DeleteMapping("id/{id}")
    public int deleteByWebSiteId(@PathVariable Long id) {
        return adminService.deleteByWebSiteId(id);
    }
@GetMapping("")
    public List<ScrappingLink> findAll() {
        return adminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody ScrappingLink scrappingLink) {
        return adminService.save(scrappingLink);
    }
@PutMapping("")
    public int update(@RequestBody ScrappingLink scrappingLink) {
        return adminService.update(scrappingLink);
    }

    @Autowired
    public ScrappingLinkAdminServiceImpl adminService;

}