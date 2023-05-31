package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.StatutWebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface StatutWebSiteDao extends JpaRepository<StatutWebSite,Long> {
    StatutWebSite findByCode(String code);
    int deleteByCode(String code);



}
