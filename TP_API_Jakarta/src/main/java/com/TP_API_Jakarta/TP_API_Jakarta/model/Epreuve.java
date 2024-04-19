package com.TP_API_Jakarta.TP_API_Jakarta.model;

public class Epreuve {

    private String nom_epreuve;
    private Date date;
    private String adresse ;

    public CreateEpreuve(String nom_epreuve, Date date) {
		this.nom_epreuve = nom_epreuve;
		this.Date = date;
	}

    public String getEpreuve() {
		return nom_epreuve;
	}

}
