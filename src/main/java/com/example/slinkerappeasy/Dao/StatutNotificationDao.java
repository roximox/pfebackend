package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.StatutNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatutNotificationDao extends JpaRepository<StatutNotification,Long> {
    StatutNotification findByCode(String code);

    int deleteByCode(String code);
}
