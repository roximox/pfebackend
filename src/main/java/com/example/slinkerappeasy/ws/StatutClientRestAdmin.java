package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.StatutClient;
import com.example.slinkerappeasy.Service.impl.admin.StatutClientAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/statutClient/")
public class StatutClientRestAdmin {

@GetMapping("code/{code}")
    public StatutClient findByCode(@PathVariable String code) {
        return statutClientAdminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return statutClientAdminService.deleteByCode(code);
    }
@GetMapping("")
    public List<StatutClient> findAll() {
        return statutClientAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody StatutClient statutClient) {
        return statutClientAdminService.save(statutClient);
    }
@PutMapping
    public int update(@RequestBody StatutClient statutClient) {
        return statutClientAdminService.update(statutClient);
    }

    @Autowired
    public StatutClientAdminServiceImpl statutClientAdminService;


}