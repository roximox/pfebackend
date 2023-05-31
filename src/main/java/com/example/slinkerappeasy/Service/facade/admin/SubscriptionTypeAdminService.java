package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.SubscriptionType;

public interface SubscriptionTypeAdminService   {
    SubscriptionType findByCode(String code);

    int deleteByCode(String code);




}
