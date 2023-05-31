package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    Client findByEmailAndPassword(String email , String password);

    List<Client> findByStatutClientId(Long id);

    int deleteByStatutClientId(Long id);
    int deleteByWebSitesId(Long id);


}

