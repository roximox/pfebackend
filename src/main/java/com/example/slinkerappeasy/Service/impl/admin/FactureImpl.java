package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.Client;
import com.example.slinkerappeasy.Bean.EtatPaiement;
import com.example.slinkerappeasy.Bean.Facture;
import com.example.slinkerappeasy.Bean.Subscription;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class FactureImpl {
    private SubscriptionAdminServiceImpl subscriptionService;
    private ClientAdminServiceImpl clientService;

    public FactureImpl(SubscriptionAdminServiceImpl subscriptionService, ClientAdminServiceImpl clientService) {
        this.subscriptionService = subscriptionService;
        this.clientService = clientService;
    }

    public Facture getFactureForClient(Long clientId) {
        Client client = clientService.findById(clientId);
        List<Subscription> subscriptions = subscriptionService.findByClientId(clientId);

        // Calculer le montant total payé par le client pour tous ses abonnements
        BigDecimal totalAmountPaid = BigDecimal.ZERO;
        for (Subscription subscription : subscriptions) {
            totalAmountPaid = totalAmountPaid.add(subscription.getMontantPaye());
        }

        // Créer la facture pour le client
        Facture facture = new Facture();
        facture.setClient(client);
        facture.setSubscriptions(subscriptions);
        facture.setMontantTotal(totalAmountPaid);
        facture.setDateFacture(new Date());
        facture.setEtatPaiement(EtatPaiement.PAYE);

        return facture;
    }
}
