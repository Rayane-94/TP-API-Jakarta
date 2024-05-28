package com.TP_API_Jakarta.TP_API_Jakarta.dto;

public class UpdateOrganisateur {
    private String nom;
    private String prenom;
    private String lieu;

    public UpdateOrganisateur(String nom, String prenom, String lieu) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieu = lieu;
    }

    // Getters et setters
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
}