package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.NotificationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotificationDetailDao extends JpaRepository<NotificationDetail,Long> {

    List<NotificationDetail> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<NotificationDetail> findByNotificationId(Long id);
    int deleteByNotificationId(Long id);

}
