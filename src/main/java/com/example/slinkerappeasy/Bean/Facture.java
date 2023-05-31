package com.example.slinkerappeasy.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Facture {

    Long id;
    Date dateFacture;
    Client client;

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    List<Subscription> subscriptions;
    BigDecimal montantTotal;
    EtatPaiement etatPaiement;

    public EtatPaiement getEtatPaiement() {
        return etatPaiement;
    }

    public void setEtatPaiement(EtatPaiement etatPaiement) {
        this.etatPaiement = etatPaiement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
}
