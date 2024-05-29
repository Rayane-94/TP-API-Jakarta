package com.TP_API_Jakarta.TP_API_Jakarta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Epreuve {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String nomEpreuve;
    private LocalDate date;
    private String adresse;
    private LocalDateTime deletedAt;  // Ajoutez cette ligne

    @OneToMany(mappedBy = "epreuve")
    private List<Billet> billets;
    
    public Epreuve() {}

    public Epreuve(String nomEpreuve, LocalDate date, String adresse) {
        this.nomEpreuve = nomEpreuve;
        this.date = date;
        this.adresse = adresse;
    }

    // Getters et setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNomEpreuve() {
        return nomEpreuve;
    }

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
