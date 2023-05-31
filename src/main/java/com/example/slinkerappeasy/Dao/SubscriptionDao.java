package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SubscriptionDao extends JpaRepository<Subscription,Long> {

    List<Subscription> findBySubscriptionTypeId(Long id);
    int deleteBySubscriptionTypeId(Long id);
    List<Subscription> findBySubscriptionPackId(Long id);
    int deleteBySubscriptionPackId(Long id);
    List<Subscription> findBySubscriptionEtatId(Long id);
    int deleteBySubscriptionEtatId(Long id);
    List<Subscription> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Subscription> findByTypePaiementId(Long id);
    List<Subscription> findByDateDebut(LocalDateTime dateTime);

    List<Subscription>  findByDateDebutBetween(LocalDateTime startOfMonth, LocalDateTime endOfMonth);
    int deleteByTypePaiementId(Long id);


}
