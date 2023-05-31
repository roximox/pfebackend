package com.example.slinkerappeasy.ws;




import com.example.slinkerappeasy.Bean.StatutNotification;
import com.example.slinkerappeasy.Service.impl.admin.StatutNotificationAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/statutNotification/")
public class StatutNotificationRestAdmin {

@GetMapping("code/{code}")
    public StatutNotification findByCode(@PathVariable String code) {
        return statutNotificationAdminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return statutNotificationAdminService.deleteByCode(code);
    }
@GetMapping("")
    public List<StatutNotification> findAll() {
        return statutNotificationAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody StatutNotification statutNotification) {
        return statutNotificationAdminService.save(statutNotification);
    }
@PutMapping
    public int update(@RequestBody StatutNotification statutNotification) {
        return statutNotificationAdminService.update(statutNotification);
    }

    @Autowired
    public StatutNotificationAdminServiceImpl statutNotificationAdminService;


}