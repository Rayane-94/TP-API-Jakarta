package com.TP_API_Jakarta.TP_API_Jakarta.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private Float prix;
    private Integer nbBillet;
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "epreuve_uuid", nullable = false)
    private Epreuve epreuve;

    @ManyToOne
    @JoinColumn(name = "utilisateur_uuid", nullable = false)
    private Utilisateur utilisateur;

    public Billet() {}

    public Billet(Float prix, Integer nbBillet) {
        this.prix = prix;
        this.nbBillet = nbBillet;
    }

    public String getUuid() {
        return uuid;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
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

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
