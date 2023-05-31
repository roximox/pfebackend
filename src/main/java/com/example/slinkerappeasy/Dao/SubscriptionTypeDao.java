package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriptionTypeDao extends JpaRepository<SubscriptionType,Long> {
    SubscriptionType findByCode(String code);

    int deleteByCode(String code);


}
