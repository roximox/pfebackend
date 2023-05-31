package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.SubscriptionEtat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubscriptionEtatDao extends JpaRepository<SubscriptionEtat,Long> {
    SubscriptionEtat findByCode(String code);
    int deleteByCode(String code);



}
