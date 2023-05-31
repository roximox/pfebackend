package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WebSiteDao extends JpaRepository<WebSite,Long> {

    List<WebSite> findByStatutWebSiteId(Long id);
    int deleteByStatutWebSiteId(Long id);
    List<WebSite> findByClientsId(Long id);
    int deleteByClientsId(Long id);



}
