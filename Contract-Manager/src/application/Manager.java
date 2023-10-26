package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Manager {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try (Scanner sc = new Scanner(System.in)){
			
			System.out.print("Enter departament's name: ");
			String departamentName = sc.nextLine();
			System.out.println("===ENTER WORKER DATA===");
			System.out.print("Name: ");
			String workerName = sc.nextLine();
			System.out.print("Level: ");
			String workerLevel = sc.next();
			System.out.print("Base salary: U$ ");
			double baseSalary = sc.nextDouble();
			
			Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary, new Departament(departamentName));
			
			System.out.println();
			
			System.out.print("How many contracts to this worker? ");
			int quantityOfContracts = sc.nextInt();
			
			for (int i = 1; i <= quantityOfContracts; i++) {
				System.out.println();
				System.out.println("===ENTER CONTRACT #" + i + " DATA===");
				System.out.println();
				System.out.print("Date (DD/MM/YYYY): ");
				Date dateContract = dateFormat.parse(sc.next());
				System.out.print("Value Per Hour: U$ ");
				double valuePerHour = sc.nextDouble();
				System.out.print("Duration (hours): ");
				int duration = sc.nextInt();
				
				HourContract contract = new HourContract(dateContract, valuePerHour, duration);
				
				worker.addContract(contract);
			}
			
			System.out.println();
			System.out.print("Enter month and year to calculate income (MM/YYYY): ");
			String monthAndYear = sc.next();
			int month = Integer.parseInt(monthAndYear.substring(0,2));
			int year = Integer.parseInt(monthAndYear.substring(3));
			
			System.out.println();
			
			System.out.println(worker + "Income for " + monthAndYear + ": U$ " + String.format("%.2f", worker.income(year, month)));
			
			
			
			sc.close();
		}
	}
}
