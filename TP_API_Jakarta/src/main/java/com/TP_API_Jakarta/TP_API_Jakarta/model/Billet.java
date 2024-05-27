package com.TP_API_Jakarta.TP_API_Jakarta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private Float prix;
    private Integer nbBillet;
    private LocalDateTime deletedAt;

    public Billet() {}

    public Billet(Float prix, Integer nbBillet) {
        this.prix = prix;
        this.nbBillet = nbBillet;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Integer getNbBillet() {
        return nbBillet;
    }

    public void setNbBillet(Integer nbBillet) {
        this.nbBillet = nbBillet;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
 