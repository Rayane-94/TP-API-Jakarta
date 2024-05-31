package com.TP_API_Jakarta.TP_API_Jakarta.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CreateBillet {
    @NotNull
    @Min(1)
    @Max(25)
    private Integer nbBillet;

    @NotNull
    @Positive
    private Float prix;

    @NotNull
    private String epreuveUuid;

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

    public String getEpreuveUuid() {
        return epreuveUuid;
    }

    public void setEpreuveUuid(String epreuveUuid) {
        this.epreuveUuid = epreuveUuid;
    }
}
