package com.fixingExercise.entities;

public class Individual extends GeneralData{

	private Double healthSpending;
	
	public Individual() {
		
	}
	
	public Individual(String name, Double annualIncome, Double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public Double TaxPayers() {
		double TaxPayers = 0;
		if(super.getAnnualIncome() < 20000.0) {
			TaxPayers = (super.getAnnualIncome()*0.15)-(getHealthSpending()*0.50);
		}else if(super.getAnnualIncome() >= 20000.0){
			TaxPayers = (super.getAnnualIncome()*0.25)-(getHealthSpending()*0.50);
		}
		return TaxPayers;
	}
	
}
