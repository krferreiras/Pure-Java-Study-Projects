package com.fixingExercise.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.fixingExercise.entities.Corporate;
import com.fixingExercise.entities.GeneralData;
import com.fixingExercise.entities.Individual;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<GeneralData> list = new ArrayList<>();
		try(Scanner sc = new Scanner(System.in)){
 			
			System.out.print("Enter the number of tax payers: ");
			int numberOfTaxes = sc.nextInt();
			System.out.println();
			
			for(int i = 1; i <= numberOfTaxes; i++) {
				System.out.println("Tax payer#" + i + " data:");
				System.out.println();
				System.out.print("Individual or company (i/c)? ");
				char ch = sc.next().charAt(0);
				
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.print("Annual income: U$ ");
				double annualIncome = sc.nextDouble();
				
				if (ch == 'i') {
					System.out.print("Health expenditures: U$ ");
					double healthSpending = sc.nextDouble();
					
					list.add(new Individual(name, annualIncome, healthSpending));
				}else if(ch == 'c') {
					System.out.print("Number of employees: ");
					int numberOfEmployees = sc.nextInt();
					
					list.add(new Corporate(name, annualIncome, numberOfEmployees));
				}
			}
			
			System.out.println();
			System.out.println("TAXES PAID:");
			
			double sum = 0.0;
			
			for(GeneralData generalData : list) {
				System.out.println(generalData.getName() + ": U$ " + String.format("%.2f", generalData.TaxPayers()));
				sum += generalData.TaxPayers();
			}
			
			System.out.println();
			System.out.println("TOTAL TAXES: U$ " + String.format("%.2f", sum));
			
			sc.close();
		}

	}

}
