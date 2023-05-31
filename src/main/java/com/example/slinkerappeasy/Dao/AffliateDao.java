package com.example.slinkerappeasy.Dao;



import com.example.slinkerappeasy.Bean.Affliate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AffliateDao extends JpaRepository<Affliate,Long> {
    Affliate findByCode(String code);
    int deleteByCode(String code);
    List<Affliate> findByClientId(Long id);
    int deleteByClientId(Long id);


}
