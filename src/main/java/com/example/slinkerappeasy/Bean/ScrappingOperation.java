package com.example.slinkerappeasy.Bean;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ScrappingOperation     {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dateDebutScrappingOperation ;
    private LocalDateTime dateFinScrappingOperation ;
    @Column(length = 500)
    private String url;
    @ManyToOne
    private Affliate affliate ;
    @ManyToOne
    private WebSite webSite ;
    @OneToMany
    private List<ScrappingOperationItem> scrappingOperationItems ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDebutScrappingOperation() {
        return dateDebutScrappingOperation;
    }

    public void setDateDebutScrappingOperation(LocalDateTime dateDebutScrappingOperation) {
        this.dateDebutScrappingOperation = dateDebutScrappingOperation;
    }

    public LocalDateTime getDateFinScrappingOperation() {
        return dateFinScrappingOperation;
    }

    public void setDateFinScrappingOperation(LocalDateTime dateFinScrappingOperation) {
        this.dateFinScrappingOperation = dateFinScrappingOperation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Affliate getAffliate() {
        return affliate;
    }

    public void setAffliate(Affliate affliate) {
        this.affliate = affliate;
    }

    public WebSite getWebSite() {
        return webSite;
    }

    public void setWebSite(WebSite webSite) {
        this.webSite = webSite;
    }

    public List<ScrappingOperationItem> getScrappingOperationItems() {
        return scrappingOperationItems;
    }

    public void setScrappingOperationItems(List<ScrappingOperationItem> scrappingOperationItems) {
        this.scrappingOperationItems = scrappingOperationItems;
    }
}

