package com.example.slinkerappeasy.Bean;



import javax.persistence.*;
import java.util.List;

@Entity
public class Client  {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String password;
    @Column(length = 500)
    private String email;
    @ManyToOne
    private StatutClient statutClient ;

    @OneToMany(mappedBy = "client")
    private List<Affliate> affliates ;
    @OneToMany
    private List<WebSite> webSites ;
    @OneToMany
    private List<NotificationDetail> notificationDetails ;
    @OneToMany
    private List<Subscription> subscriptions ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatutClient getStatutClient() {
        return statutClient;
    }

    public void setStatutClient(StatutClient statutClient) {
        this.statutClient = statutClient;
    }

    public List<Affliate> getAffliates() {
        return affliates;
    }

    public void setAffliates(List<Affliate> affliates) {
        this.affliates = affliates;
    }

    public List<WebSite> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<WebSite> webSites) {
        this.webSites = webSites;
    }

    public List<NotificationDetail> getNotificationDetails() {
        return notificationDetails;
    }

    public void setNotificationDetails(List<NotificationDetail> notificationDetails) {
        this.notificationDetails = notificationDetails;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}

