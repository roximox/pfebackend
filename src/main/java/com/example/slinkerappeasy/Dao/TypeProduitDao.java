package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.TypeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeProduitDao extends JpaRepository<TypeProduit,Long> {
    TypeProduit findByCode(String code);
    int deleteByCode(String code);


}
