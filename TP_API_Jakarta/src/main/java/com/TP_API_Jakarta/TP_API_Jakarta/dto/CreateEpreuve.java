package com.TP_API_Jakarta.TP_API_Jakarta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CreateEpreuve {

    @NotBlank
    @Size(max = 100)
    private String nomEpreuve;

    @NotNull
    private LocalDate date;

    @NotBlank
    @Size(max = 255)
    private String adresse;

    public CreateEpreuve(String nomEpreuve, LocalDate date, String adresse) {
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
