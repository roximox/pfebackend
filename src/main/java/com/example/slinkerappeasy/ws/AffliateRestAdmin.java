package com.example.slinkerappeasy.ws;




import com.example.slinkerappeasy.Bean.Affliate;
import com.example.slinkerappeasy.Service.impl.admin.AffliateAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin/affliate/")
public class AffliateRestAdmin   {

    @GetMapping("code/{code}")
    public Affliate findByCode(@PathVariable String code) {
        return affliateAdminService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return affliateAdminService.deleteByCode(code);
    }
    @GetMapping("id/{id}")
    public List<Affliate> findByClientId(@PathVariable Long id) {
        return affliateAdminService.findByClientId(id);
    }
    @DeleteMapping("id/{id}")
    public int deleteByClientId(@PathVariable Long id) {
        return affliateAdminService.deleteByClientId(id);
    }
    @GetMapping("")
    public List<Affliate> findAll() {
        return affliateAdminService.findAll();
    }
    @PutMapping("")
    public int update(@RequestBody Affliate t) {
        return affliateAdminService.update(t);
    }
    @PostMapping("")
    public int save(@RequestBody Affliate affliate) {
        return affliateAdminService.save(affliate);
    }

    @Autowired
    public AffliateAdminServiceImpl affliateAdminService;
}