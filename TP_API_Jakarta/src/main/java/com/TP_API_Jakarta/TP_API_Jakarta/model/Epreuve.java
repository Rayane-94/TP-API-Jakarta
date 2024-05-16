package com.TP_API_Jakarta.TP_API_Jakarta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Epreuve {
@Id
    private String nom_epreuve;
    private String date;
    private String adresse;

    public void CreateEpreuve (String nom_epreuve, String date, String adresse) {

		this.nom_epreuve = nom_epreuve;
		this.date = date;
    this.adresse = adresse;
	}

    public String getEpreuve() {
		return nom_epreuve;
	}

    public String getDate() {
		return date;
	}
    public String getAdresse() {
		return adresse;
	}

}
