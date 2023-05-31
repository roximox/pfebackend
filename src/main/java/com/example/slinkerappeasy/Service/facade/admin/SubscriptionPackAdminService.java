package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.SubscriptionPack;

public interface SubscriptionPackAdminService   {


    SubscriptionPack findByCode(String code);
    int deleteByCode(String code);



}
