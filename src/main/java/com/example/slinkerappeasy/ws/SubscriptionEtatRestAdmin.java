package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.SubscriptionEtat;
import com.example.slinkerappeasy.Service.impl.admin.SubscriptionEtatAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/subscriptionEtat/")
public class SubscriptionEtatRestAdmin {



@GetMapping("code/{code}")
    public SubscriptionEtat findByCode(@PathVariable String code) {
        return subscriptionEtatAdminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return subscriptionEtatAdminService.deleteByCode(code);
    }
@GetMapping("")
    public List<SubscriptionEtat> findAll() {
        return subscriptionEtatAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody SubscriptionEtat subscriptionEtat) {
        return subscriptionEtatAdminService.save(subscriptionEtat);
    }
@PutMapping("")
    public int update(@RequestBody SubscriptionEtat subscriptionEtat) {
        return subscriptionEtatAdminService.update(subscriptionEtat);
    }

    @Autowired
    public SubscriptionEtatAdminServiceImpl subscriptionEtatAdminService;

}