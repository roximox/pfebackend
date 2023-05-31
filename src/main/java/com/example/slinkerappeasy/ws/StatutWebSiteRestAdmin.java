package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.StatutWebSite;
import com.example.slinkerappeasy.Service.impl.admin.StatutWebSiteAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/statutWebSite/")
public class StatutWebSiteRestAdmin  {

    @GetMapping("code/{code}")
    public StatutWebSite findByCode(@PathVariable String code) {
        return statutWebSiteAdminService.findByCode(code);
    }
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return statutWebSiteAdminService.deleteByCode(code);
    }
    @GetMapping("")
    public List<StatutWebSite> findAll() {
        return statutWebSiteAdminService.findAll();
    }
    @PostMapping("")
    public int save(@RequestBody StatutWebSite statutWebSite) {
        return statutWebSiteAdminService.save(statutWebSite);
    }
    @PutMapping("")
    public int update(@RequestBody StatutWebSite statutWebSite) {
        return statutWebSiteAdminService.update(statutWebSite);
    }

    @Autowired
    public StatutWebSiteAdminServiceImpl statutWebSiteAdminService;


}