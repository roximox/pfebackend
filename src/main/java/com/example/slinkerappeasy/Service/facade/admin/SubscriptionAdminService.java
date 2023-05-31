package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.Subscription;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SubscriptionAdminService   {

    Subscription getSubscriptionByType(String subscriptionType);

    List<Subscription> findBySubscriptionTypeId(Long id);
    int deleteBySubscriptionTypeId(Long id);
    List<Subscription> findBySubscriptionPackId(Long id);
    int deleteBySubscriptionPackId(Long id);
    List<Subscription> findBySubscriptionEtatId(Long id);
    int deleteBySubscriptionEtatId(Long id);
    List<Subscription> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Subscription> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);

     void initializeSubscriptions() ;


    List<Subscription> findByYear(Integer year);

    List<Subscription> findByDateDebut(LocalDateTime dateTime);
    List<Subscription> findByMonth(int month);

}
