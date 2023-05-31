package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.StatutClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatutClientDao extends JpaRepository<StatutClient,Long> {
    StatutClient findByCode(String code);
    int deleteByCode(String code);



}
