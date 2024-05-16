package com.TP_API_Jakarta.TP_API_Jakarta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Billet {
@Id
    private String prix;
    private String nbBillet;

    public String GetPrix(){
        return prix;
    }
    public String GetNbBillet(){
        return nbBillet ;
    }

}
