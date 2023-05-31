package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.Notification;

import java.util.List;

public interface NotificationAdminService   {

    List<Notification> findByStatutNotificationId(Long id);
    int deleteByStatutNotificationId(Long id);
    List<Notification> findByNotificationDetailId(Long id);
    int deleteByNotificationDetailId(Long id);



}
