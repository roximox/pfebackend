package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.NotificationDetail;
import com.example.slinkerappeasy.Service.impl.admin.NotificationDetailAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/notificationDetail/")
public class NotificationDetailRestAdmin  {

@GetMapping("client/id/{id}")
    public List<NotificationDetail> findByClientId(@PathVariable Long id) {
        return notificationDetailAdminService.findByClientId(id);
    }
@DeleteMapping("/client/id/{id}")
    public int deleteByClientId(@PathVariable Long id) {
        return notificationDetailAdminService.deleteByClientId(id);
    }
@GetMapping("id/{id}")
    public List<NotificationDetail> findByNotificationId(@PathVariable Long id) {
        return notificationDetailAdminService.findByNotificationId(id);
    }
@DeleteMapping("id/{id}")
    public int deleteByNotificationId(@PathVariable Long id) {
        return notificationDetailAdminService.deleteByNotificationId(id);
    }
@GetMapping("")
    public List<NotificationDetail> findAll() {
        return notificationDetailAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody NotificationDetail notificationDetail) {
        return notificationDetailAdminService.save(notificationDetail);
    }
@PutMapping("")
    public int update(@RequestBody NotificationDetail notificationDetail) {
        return notificationDetailAdminService.update(notificationDetail);
    }

    @Autowired
    public NotificationDetailAdminServiceImpl notificationDetailAdminService;
}