package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.ScrappingOperationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScrappingOperationItemDao extends JpaRepository<ScrappingOperationItem,Long> {

    List<ScrappingOperationItem> findByScrappingLinkId(Long id);
    int deleteByScrappingLinkId(Long id);
    List<ScrappingOperationItem> findByTypeProduitId(Long id);
    int deleteByTypeProduitId(Long id);
    List<ScrappingOperationItem> findByScrappingOperationId(Long id);
    int deleteByScrappingOperationId(Long id);

}
