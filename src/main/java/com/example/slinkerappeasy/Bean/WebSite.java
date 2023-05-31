package com.example.slinkerappeasy.Bean;



import javax.persistence.*;
import java.util.List;

@Entity
public class WebSite    {
@Id
@GeneratedValue
    private Long id;

    @Column(length = 500)
    private String url;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String jsonSummary;
    @ManyToOne
    private StatutWebSite statutWebSite ;
    @OneToMany
    private List<Client> clients ;

    @ManyToOne
    private ScrappingLink scrappingLinks ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getJsonSummary() {
        return jsonSummary;
    }

    public void setJsonSummary(String jsonSummary) {
        this.jsonSummary = jsonSummary;
    }

    public StatutWebSite getStatutWebSite() {
        return statutWebSite;
    }

    public void setStatutWebSite(StatutWebSite statutWebSite) {
        this.statutWebSite = statutWebSite;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public ScrappingLink getScrappingLinks() {
        return scrappingLinks;
    }

    public void setScrappingLinks(ScrappingLink scrappingLinks) {
        this.scrappingLinks = scrappingLinks;
    }
}

