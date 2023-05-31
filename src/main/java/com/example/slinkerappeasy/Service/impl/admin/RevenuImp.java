package com.example.slinkerappeasy.Service.impl.admin;

import com.example.slinkerappeasy.Bean.Client;
import com.example.slinkerappeasy.Bean.Subscription;
import com.example.slinkerappeasy.Dao.SubscriptionDao;
import com.example.slinkerappeasy.Service.facade.admin.ClientAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class RevenuImp {
    public BigDecimal getTotalRevenueByClient(Long id) {
        List<Subscription> subscriptions = subscriptionAdminService.findByClientId(id);
        BigDecimal totalRevenue = BigDecimal.ZERO;
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriptionEtat().getEtat()) {
                totalRevenue = totalRevenue.add(subscription.getMontantPaye());
            }
        }
        return totalRevenue;
    }
    public BigDecimal getTotalRevenue() {
        BigDecimal totalRevenue = BigDecimal.ZERO;
        List<Client> clients = clientService.findAll(); // Récupère tous les clients
        for (Client client : clients) {
            BigDecimal clientRevenue = getTotalRevenueByClient(client.getId());
            totalRevenue = totalRevenue.add(clientRevenue);
        }
        return totalRevenue;
    }
    // Méthode pour calculer le revenu total pour un jour donné
    public BigDecimal getTotalRevenueByDay(LocalDateTime day) {
        BigDecimal totalRevenue = BigDecimal.ZERO;
        List<Subscription> subscriptions = subscriptionAdminService.findByDateDebut(day); // Récupère toutes les transactions pour ce jour
        for (Subscription subscription : subscriptions) {
            totalRevenue = totalRevenue.add(subscription.getMontantPaye());
        }
        return totalRevenue;
    }

    // Méthode pour calculer le revenu total pour un mois donné
    public BigDecimal getTotalRevenueByMonth(Integer month) {
        BigDecimal totalRevenue = BigDecimal.ZERO;
        List<Subscription> subscriptions = subscriptionAdminService.findByMonth(month); // Récupère toutes les transactions pour ce mois
        for (Subscription subscription : subscriptions) {
            totalRevenue = totalRevenue.add(subscription.getMontantPaye());
        }
        return totalRevenue;
    }

    // Méthode pour calculer le revenu total pour une année donnée
    public BigDecimal getTotalRevenueByYear(int year) {
        BigDecimal totalRevenue = BigDecimal.ZERO;
        List<Subscription> subscriptions = subscriptionAdminService.findByYear(year); // Récupère toutes les transactions pour cette année
        for (Subscription subscription : subscriptions) {
            totalRevenue = totalRevenue.add(subscription.getMontantPaye());
        }
        return totalRevenue;
    }

    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private SubscriptionAdminServiceImpl subscriptionAdminService;

}

