package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.ScrappingLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScrappingLinkDao extends JpaRepository<ScrappingLink,Long> {
    ScrappingLink findByCode(String code);
    int deleteByCode(String code);

    List<ScrappingLink> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);


}
