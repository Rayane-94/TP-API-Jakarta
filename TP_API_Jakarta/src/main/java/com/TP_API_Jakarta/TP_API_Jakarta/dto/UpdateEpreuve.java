package com.TP_API_Jakarta.TP_API_Jakarta.dto;

import java.time.LocalDate;

public class UpdateEpreuve {
    private String nomEpreuve;
    private LocalDate date;
    private String adresse;

    public UpdateEpreuve(String nomEpreuve, LocalDate date, String adresse) {
        this.nomEpreuve = nomEpreuve;
        this.date = date;
        this.adresse = adresse;
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
}
