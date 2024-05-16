package com.TP_API_Jakarta.TP_API_Jakarta.dto;

public class UpdateUser {


	private String nom;

	private String prenom;

	public UpdateUser(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
}
