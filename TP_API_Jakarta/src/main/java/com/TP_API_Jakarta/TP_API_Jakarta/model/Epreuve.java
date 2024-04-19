package com.TP_API_Jakarta.TP_API_Jakarta.model;

public class Epreuve {

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

}
