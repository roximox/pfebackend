package com.example.slinkerappeasy.Bean;



import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Subscription  {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    private BigDecimal delai = BigDecimal.ZERO;
    private Integer nombrePage = 0;
    private BigDecimal montantPaye = BigDecimal.ZERO;
    private LocalDateTime datePaiement ;
    @ManyToOne
    private SubscriptionType subscriptionType ;
    @ManyToOne
    private SubscriptionPack subscriptionPack ;
    @ManyToOne
    private SubscriptionEtat subscriptionEtat ;
    @ManyToOne
    private Client client ;
    @ManyToOne
    private TypePaiement typePaiement ;

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getDelai() {
        return delai;
    }

    public void setDelai(BigDecimal delai) {
        this.delai = delai;
    }

    public Integer getNombrePage() {
        return nombrePage;
    }

    public void setNombrePage(Integer nombrePage) {
        this.nombrePage = nombrePage;
    }

    public BigDecimal getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public SubscriptionPack getSubscriptionPack() {
        return subscriptionPack;
    }

    public void setSubscriptionPack(SubscriptionPack subscriptionPack) {
        this.subscriptionPack = subscriptionPack;
    }

    public SubscriptionEtat getSubscriptionEtat() {
        return subscriptionEtat;
    }

    public void setSubscriptionEtat(SubscriptionEtat subscriptionEtat) {
        this.subscriptionEtat = subscriptionEtat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }
}

