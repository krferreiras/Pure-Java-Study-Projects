package com.fixingExercise.entities;

public class Corporate extends GeneralData{

	private Integer quantityEmployees;
	
	public Corporate() {
		
	}
	
	public Corporate(String name, Double annualIncome, Integer quantityEmployees) {
		super(name, annualIncome);
		this.quantityEmployees = quantityEmployees;
	}

	public Integer getQuantityEmployees() {
		return quantityEmployees;
	}

	public void setQuantityEmployees(Integer quantityEmployees) {
		this.quantityEmployees = quantityEmployees;
	}

	@Override
	public Double TaxPayers() {
		double TaxPayers = 0;
		if(quantityEmployees > 10) {
			TaxPayers = super.getAnnualIncome()*0.14;
		}else {
			TaxPayers = super.getAnnualIncome()*0.16;
		}
		return TaxPayers;
	}
	
	
}
