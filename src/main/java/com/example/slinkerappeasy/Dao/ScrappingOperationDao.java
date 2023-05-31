package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.ScrappingOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScrappingOperationDao extends JpaRepository<ScrappingOperation,Long> {

    List<ScrappingOperation> findByAffliateId(Long id);
    int deleteByAffliateId(Long id);
    List<ScrappingOperation> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);

}
