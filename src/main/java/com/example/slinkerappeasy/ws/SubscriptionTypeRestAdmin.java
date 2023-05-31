package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.SubscriptionType;
import com.example.slinkerappeasy.Service.impl.admin.SubscriptionTypeAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/subscriptionType/")
public class SubscriptionTypeRestAdmin  {
@GetMapping("ref/{ref}")
    public SubscriptionType findByReferenceEntity(@PathVariable SubscriptionType t) {
        return subscriptionTypeAdminService.findByReferenceEntity(t);
    }
@GetMapping("code/{code}")
    public SubscriptionType findByCode(@PathVariable String code) {
        return subscriptionTypeAdminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return subscriptionTypeAdminService.deleteByCode(code);
    }
@PostMapping("")
    public int save(@RequestBody SubscriptionType subscriptionType) {
        return subscriptionTypeAdminService.save(subscriptionType);
    }
@PutMapping("")
    public int update(SubscriptionType subscriptionType) {
        return subscriptionTypeAdminService.update(subscriptionType);
    }

    @Autowired
    public SubscriptionTypeAdminServiceImpl subscriptionTypeAdminService;

}