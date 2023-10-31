package com.fixingExercise.entities;

public abstract class GeneralData {
/*	Inicialmente definimos nossos atributos da nossa classe abstrata
	que será usada nas outras entidades.
	ATTRIBUTES */
	private String name;
	private Double annualIncome;
	
	
//	Aqui criamos nossos construtores seguidos dos getters and setters	

	public GeneralData() {
		
	}

	public GeneralData(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public abstract Double TaxPayers();
}
