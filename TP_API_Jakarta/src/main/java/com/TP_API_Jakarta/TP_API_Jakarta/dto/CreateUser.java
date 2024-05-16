package com.TP_API_Jakarta.TP_API_Jakarta.dto;

import java.lang.String;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUser {

	@NotBlank
	@Size(min = 1, max = 25)
	private String nom;

	@NotBlank
	private String prenom;

	@NotBlank
	private String email;

	@NotBlank
	private String mdp;

	public CreateUser(String nom, String prenom, String email, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getMdp() {
		return mdp;
	}
}
