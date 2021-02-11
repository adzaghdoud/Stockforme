package com.stockforme.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

@Entity
@Table(name="produit")
public class Produit {
	@Id
	@Column(name = "code_produit")
	private int codeproduit;
	@CsvBindByName(column = "libproduit")
	@Column(name = "lib_produit")
	private String libproduit;
	@CsvBindByName(column = "stock")
	@Column(name = "stock")
	private int stock;
	@CsvBindByName(column = "pua")
	@Column(name = "pua")
	private double pua ;
	@CsvBindByName(column = "puv")
	@Column(name = "puv")
	private double puv ;
	@CsvBindByName(column = "fournisseur")
	@Column(name = "fournisseur")
	private int fournisseur;

	public void setCodeproduit(int code) {
		
	this.codeproduit=code;	
		
	}

	public void setLibproduit(String libproduit) {
		
	this.libproduit=libproduit;	
		
	}

	public void setStock(int stock) {
		
	this.stock=stock;	
		
	}


	public void setPua (double pua) {
		
	this.pua=pua;	
		
	}


	public void setPuv (double puv) {
		
	this.puv=puv;	
		
	}


	public void setFournisseur (int  fournisseur) {
		
	this.fournisseur=fournisseur;	
		
	}

	public double getPua() {
		return pua;
		
	}


	public double getPuv() {
		return puv;
		
	}


	public int getFournisseur() {
		return fournisseur;
		
	}




	public int getCodeproduit() {
		return codeproduit;
		
	}

	public int getStock() {
		return stock;
		
	}

	public String getLibproduit() {
		
		return libproduit;
	}
 

}
