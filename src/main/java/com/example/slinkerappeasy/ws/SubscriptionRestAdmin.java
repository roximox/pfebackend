package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.Subscription;
import com.example.slinkerappeasy.Service.impl.admin.SubscriptionAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/admin/subscription/")
public class SubscriptionRestAdmin {
@GetMapping("id/{id}")
    public List<Subscription> findBySubscriptionTypeId(@PathVariable Long id) {
        return subscriptionAdminService.findBySubscriptionTypeId(id);
    }
@DeleteMapping("id/{id}")
    public int deleteBySubscriptionTypeId(@PathVariable Long id) {
        return subscriptionAdminService.deleteBySubscriptionTypeId(id);
    }
@GetMapping("pack/id/{id}")
    public List<Subscription> findBySubscriptionPackId(@PathVariable Long id) {
        return subscriptionAdminService.findBySubscriptionPackId(id);
    }
@DeleteMapping("pack/id/{id}")
    public int deleteBySubscriptionPackId(@PathVariable Long id) {
        return subscriptionAdminService.deleteBySubscriptionPackId(id);
    }
@GetMapping("etat/id/{id}")
    public List<Subscription> findBySubscriptionEtatId(@PathVariable Long id) {
        return subscriptionAdminService.findBySubscriptionEtatId(id);
    }
@DeleteMapping("etat/id/{id}")
    public int deleteBySubscriptionEtatId(Long id) {
        return subscriptionAdminService.deleteBySubscriptionEtatId(id);
    }
@GetMapping("client/id/{id}")
    public List<Subscription> findByClientId(@PathVariable Long id) {
        return subscriptionAdminService.findByClientId(id);
    }
@DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id) {
        return subscriptionAdminService.deleteByClientId(id);
    }
@GetMapping("paiement/id/{id}")
    public List<Subscription> findByTypePaiementId(@PathVariable Long id) {
        return subscriptionAdminService.findByTypePaiementId(id);
    }
@DeleteMapping("paiement/id/{id}")
    public int deleteByTypePaiementId(@PathVariable Long id) {
        return subscriptionAdminService.deleteByTypePaiementId(id);
    }
@GetMapping("")
    public List<Subscription> findAll() {
        return subscriptionAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody Subscription subscription) {
        return subscriptionAdminService.save(subscription);
    }
@PutMapping("")
    public int update(@RequestBody Subscription subscription) {
        return subscriptionAdminService.update(subscription);
    }
@GetMapping("calculdate")
    public static LocalDateTime calculateEndDate(LocalDateTime startDate, String subscriptionType) {
        return SubscriptionAdminServiceImpl.calculateEndDate(startDate, subscriptionType);
    }
@PostMapping("intializa")
    public void initializeSubscriptions() {
        subscriptionAdminService.initializeSubscriptions();
    }

    @Autowired
    public SubscriptionAdminServiceImpl subscriptionAdminService;


}