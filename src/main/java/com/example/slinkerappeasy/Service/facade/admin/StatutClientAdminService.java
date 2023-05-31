package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.StatutClient;

public interface StatutClientAdminService  {

    StatutClient findByCode(String code);
    int deleteByCode(String code);

}
