package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypePaiementDao extends JpaRepository<TypePaiement,Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);

}
