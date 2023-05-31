package com.example.slinkerappeasy.Bean;


import javax.persistence.Column;
import java.math.BigDecimal;

public class Result {
   /* @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
    private BigDecimal prix = BigDecimal.ZERO;
    @Column(length = 500)
    private String stock;
    @Column(length = 500)
    private String image;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String review;



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
}
