package com.example.slinkerappeasy.Bean;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ScrappingOperationItem   {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal prix = BigDecimal.ZERO;
    @Column(length = 500)
    private String stock;
    @Column(length = 500)
    private String image;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String review;
    @ManyToOne
    private ScrappingLink scrappingLink ;
    @ManyToOne
    private TypeProduit typeProduit ;
    @ManyToOne
    private ScrappingOperation scrappingOperation ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public ScrappingLink getScrappingLink() {
        return scrappingLink;
    }

    public void setScrappingLink(ScrappingLink scrappingLink) {
        this.scrappingLink = scrappingLink;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }

    public ScrappingOperation getScrappingOperation() {
        return scrappingOperation;
    }

    public void setScrappingOperation(ScrappingOperation scrappingOperation) {
        this.scrappingOperation = scrappingOperation;
    }
}

