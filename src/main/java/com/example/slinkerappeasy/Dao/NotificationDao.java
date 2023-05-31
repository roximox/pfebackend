package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotificationDao extends JpaRepository<Notification,Long> {

    List<Notification> findByStatutNotificationId(Long id);
    int deleteByStatutNotificationId(Long id);
    List<Notification> findByNotificationDetailId(Long id);
    int deleteByNotificationDetailId(Long id);

}
