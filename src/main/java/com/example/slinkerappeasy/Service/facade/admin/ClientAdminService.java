package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.Client;

import java.util.List;

public interface ClientAdminService  {

    List<Client> findByStatutClientId(Long id);
    int deleteByStatutClientId(Long id);

    Client findById(Long id);
    Client findByEmailAndPassword(String email , String password);
    int deleteByWebSitesId(Long id);
    List<Client> findAll();



}
