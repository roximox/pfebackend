package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.NotificationDetail;

import java.util.List;

public interface NotificationDetailAdminService  {

    List<NotificationDetail> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<NotificationDetail> findByNotificationId(Long id);
    int deleteByNotificationId(Long id);



}
