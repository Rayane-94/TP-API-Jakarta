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

    public CreateBillet(Integer nbBillet, Float prix) {
        this.nbBillet = nbBillet;
        this.prix = prix;
    }

    public Integer getNbBillet() {
        return nbBillet;
    }

    public Float getPrix() {
        return prix;
    }
}
