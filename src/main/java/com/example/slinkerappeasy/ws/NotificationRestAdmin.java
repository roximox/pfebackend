package com.example.slinkerappeasy.ws;




import com.example.slinkerappeasy.Bean.Notification;
import com.example.slinkerappeasy.Service.impl.admin.NotificationAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin/notification/")
public class NotificationRestAdmin  {

    @GetMapping("id/{id}")
    public List<Notification> findByStatutNotificationId(@PathVariable Long id) {
        return notificationAdminService.findByStatutNotificationId(id);
    }
@DeleteMapping("id/{id}")
    public int deleteByStatutNotificationId(@PathVariable Long id) {
        return notificationAdminService.deleteByStatutNotificationId(id);
    }
@GetMapping("notificationDetail/id/{id}")
    public List<Notification> findByNotificationDetailId(@PathVariable Long id) {
        return notificationAdminService.findByNotificationDetailId(id);
    }
@DeleteMapping("notificationDetail/id/{id}")
    public int deleteByNotificationDetailId(@PathVariable Long id) {
        return notificationAdminService.deleteByNotificationDetailId(id);
    }
@GetMapping("")
    public List<Notification> findAll() {
        return notificationAdminService.findAll();
    }
@PostMapping("")
    public int save(@RequestBody Notification notification) {
        return notificationAdminService.save(notification);
    }
@PutMapping("")
    public int update(@RequestBody Notification notification) {
        return notificationAdminService.update(notification);
    }

    @Autowired
    public NotificationAdminServiceImpl notificationAdminService;

}