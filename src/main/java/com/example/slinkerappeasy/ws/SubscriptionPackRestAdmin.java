package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.SubscriptionPack;
import com.example.slinkerappeasy.Service.impl.admin.SubscriptionPackAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/subscriptionPack/")
public class SubscriptionPackRestAdmin {

@GetMapping("ref/{ref}")
    public SubscriptionPack findByReferenceEntity(@PathVariable SubscriptionPack t) {
        return subscriptionPackAdminService.findByReferenceEntity(t);
    }
@PostMapping("")
    public int save(@RequestBody SubscriptionPack subscriptionEtat) {
        return subscriptionPackAdminService.save(subscriptionEtat);
    }
@PutMapping("")
    public int update(@RequestBody SubscriptionPack subscriptionPack) {
        return subscriptionPackAdminService.update(subscriptionPack);
    }
@GetMapping("code/{code}")
    public SubscriptionPack findByCode(@PathVariable String code) {
        return subscriptionPackAdminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return subscriptionPackAdminService.deleteByCode(code);
    }

    @Autowired
    public SubscriptionPackAdminServiceImpl subscriptionPackAdminService;

}