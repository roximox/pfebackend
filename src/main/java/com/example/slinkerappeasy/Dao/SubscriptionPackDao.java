package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.SubscriptionPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubscriptionPackDao extends JpaRepository<SubscriptionPack,Long> {
    SubscriptionPack findByCode(String code);
    int deleteByCode(String code);


   }
