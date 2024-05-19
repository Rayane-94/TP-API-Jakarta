package com.TP_API_Jakarta.TP_API_Jakarta.dto;

public class UpdateBillet {
    private Integer nbBillet;

	private float prix;

	public UpdateBillet(Integer nbBillet, float prix) {
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
