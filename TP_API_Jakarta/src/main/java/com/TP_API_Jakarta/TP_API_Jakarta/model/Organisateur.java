package com.TP_API_Jakarta.TP_API_Jakarta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Organisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String nom;
    private String prenom;
    private String lieu;
    private LocalDateTime deletedAt;

    public Organisateur() {}

    public Organisateur(String nom, String prenom, String lieu) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieu = lieu;
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
