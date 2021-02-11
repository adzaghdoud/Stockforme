package com.stockforme.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Client")
public class Client {
	@Column(name="nom")
	private String nom;
	@Column(name="email")
    private String email;
	@Column(name="date_inscription")
    private Timestamp  datesouscr;
    @Id
    private int id;
    @Column(name="adresse")
    private String adresse;
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;	

}
    
    public String getadresse () {
    	
    	return adresse;
    }
    public void setadresse(String adresse) {
        this.adresse = adresse;	

}

    
    
    

    public Timestamp getdatesouscr() {
        return datesouscr;
    } 
    
   public void setdatesouscr(Timestamp timestamp) {
       this.datesouscr = timestamp;	

}
    
    
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;	

}

}
