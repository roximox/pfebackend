package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.Subscription;
import com.example.slinkerappeasy.Bean.SubscriptionType;
import com.example.slinkerappeasy.Dao.SubscriptionDao;
import com.example.slinkerappeasy.Service.facade.admin.SubscriptionAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscriptionAdminServiceImpl implements SubscriptionAdminService {


    private final Map<String, Subscription> subscriptions;

    @Autowired
    public SubscriptionAdminServiceImpl() {
        this.subscriptions = new HashMap<>();
        initializeSubscriptions();
    }

    @Override
    public Subscription getSubscriptionByType(String subscriptionType) {
        return subscriptions.get(subscriptionType);
    }

    public static LocalDateTime calculateEndDate(LocalDateTime startDate, String subscriptionType) {
        LocalDateTime endDate;

        switch (subscriptionType) {
            case "Silver":
                endDate = startDate.plusMonths(1);
                break;
            case "Gold":
                endDate = startDate.plusMonths(6);
                break;
            case "Platinum":
                endDate = startDate.plusYears(1);
                break;
            default:
                throw new IllegalArgumentException("Type d'abonnement invalide : " + subscriptionType);
        }

        return endDate;
    }

    @Override
    public void initializeSubscriptions() {
        SubscriptionType subscriptionType1 = new SubscriptionType();
        subscriptionType1.setLibelle("Silver");
        Subscription silverSubscription = new Subscription();

        silverSubscription.setSubscriptionType(subscriptionType1);
        silverSubscription.setMontantPaye(new BigDecimal(10.99));
        silverSubscription.setDateDebut(LocalDateTime.now());
        silverSubscription.setDateFin(calculateEndDate(LocalDateTime.now(), "Silver"));
        SubscriptionType subscriptionType2 = new SubscriptionType();
        subscriptionType1.setLibelle("Gold");
        Subscription goldSubscription = new Subscription();
        silverSubscription.setSubscriptionType(subscriptionType2);
        silverSubscription.setMontantPaye(new BigDecimal(19.99));
        silverSubscription.setDateDebut(LocalDateTime.now());
        silverSubscription.setDateFin(calculateEndDate(LocalDateTime.now(), "Gold"));
        SubscriptionType subscriptionType3 = new SubscriptionType();
        subscriptionType3.setLibelle("Platinum");
        Subscription platinumSubscription = new Subscription();
        silverSubscription.setSubscriptionType(subscriptionType3);
        silverSubscription.setMontantPaye(new BigDecimal(29.99));
        silverSubscription.setDateDebut(LocalDateTime.now());
        silverSubscription.setDateFin(calculateEndDate(LocalDateTime.now(), "Platinum"));

        subscriptions.put(subscriptionType1.getLibelle(), silverSubscription);
        subscriptions.put(subscriptionType2.getLibelle(), goldSubscription);
        subscriptions.put(subscriptionType3.getLibelle(), platinumSubscription);
    }

    @Override
    public List<Subscription> findBySubscriptionTypeId(Long id) {
        return subscriptionDao.findBySubscriptionTypeId(id);
    }

    @Override
    public int deleteBySubscriptionTypeId(Long id) {
        return subscriptionDao.deleteBySubscriptionTypeId(id);
    }

    @Override
    public List<Subscription> findBySubscriptionPackId(Long id) {
        return subscriptionDao.findBySubscriptionPackId(id);
    }

    @Override
    public int deleteBySubscriptionPackId(Long id) {
        return subscriptionDao.deleteBySubscriptionPackId(id);
    }

    @Override
    public List<Subscription> findBySubscriptionEtatId(Long id) {
        return subscriptionDao.findBySubscriptionEtatId(id);
    }

    @Override
    public int deleteBySubscriptionEtatId(Long id) {
        return subscriptionDao.deleteBySubscriptionEtatId(id);
    }

    @Override
    public List<Subscription> findByClientId(Long id) {
        return subscriptionDao.findByClientId(id);
    }

    @Override
    public int deleteByClientId(Long id) {
        return subscriptionDao.deleteByClientId(id);
    }

    @Override
    public List<Subscription> findByTypePaiementId(Long id) {
        return subscriptionDao.findByTypePaiementId(id);
    }

    @Override
    public int deleteByTypePaiementId(Long id) {
        return subscriptionDao.deleteByTypePaiementId(id);
    }

    public List<Subscription> findAll() {
        return subscriptionDao.findAll();
    }

    public int save(Subscription subscription) {
        //ajouter le code
        return 1;
    }

    public int update(Subscription subscription) {
        if (subscriptionDao.findById(subscription.getId()) == null) {
            return -1;
        }
        Subscription subscription1 = subscriptionDao.findById(subscription.getId()).orElse(null);
        subscription1.setClient(subscription.getClient());
        subscription1.setSubscriptionPack(subscription.getSubscriptionPack());
        subscription1.setSubscriptionEtat(subscription.getSubscriptionEtat());
        subscription1.setSubscriptionType(subscription.getSubscriptionType());
        subscription1.setDateDebut(subscription.getDateDebut());
        subscription1.setDateFin(subscription.getDateFin());
        subscription1.setDatePaiement(subscription.getDatePaiement());
        subscription1.setMontantPaye(subscription.getMontantPaye());
        subscription1.setNombrePage(subscription.getNombrePage());
        subscription1.setTypePaiement(subscription.getTypePaiement());
        subscription1.setDelai(subscription.getDelai());
        subscriptionDao.save(subscription1);
        return 1;
    }


       /* @Override
        public List<Subscription> findByDate(int date) {
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
            return dao.findByDateDebutBetween(startOfDay, endOfDay);
        }*/

    @Override
    public List<Subscription> findByMonth(int month) {
        LocalDateTime startOfMonth = LocalDateTime.of(LocalDate.now().getYear(), month, 1, 0, 0);
        LocalDateTime endOfMonth = LocalDateTime.of(LocalDate.now().getYear(), month, 1, 23, 59, 59)
                .with(TemporalAdjusters.lastDayOfMonth());
        return subscriptionDao.findByDateDebutBetween(startOfMonth, endOfMonth);
    }

    @Override
    public List<Subscription> findByYear(Integer year) {
        LocalDateTime startOfYear = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime endOfYear = LocalDateTime.of(year, 12, 31, 23, 59, 59);
        return subscriptionDao.findByDateDebutBetween(startOfYear, endOfYear);
    }

    public static LocalDateTime stringEnLocalDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }


    @Autowired
    private SubscriptionDao subscriptionDao;

    @Override
    public List<Subscription> findByDateDebut(LocalDateTime dateTime) {
        return subscriptionDao.findByDateDebut(dateTime);
    }
}