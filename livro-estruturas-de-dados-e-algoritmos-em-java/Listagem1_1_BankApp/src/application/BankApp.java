package application;

import entities.BankAccount;

public class BankApp {
	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount(100.00);
		ba1.display();
		
		ba1.deposit(74.35);
		ba1.withdraw(20);
		
		System.out.println("After transactions, ");
		ba1.display();
		
		 
	}
}
