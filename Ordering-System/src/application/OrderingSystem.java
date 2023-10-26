package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class OrderingSystem {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		try (Scanner scanner = new Scanner(System.in)){
			
			System.out.println("=================================");
			System.out.println("========Enter client data========");
			System.out.println("=================================");
			
			System.out.print("Name: ");
			String name = scanner.nextLine();
		
			System.out.print("E-mail: ");
			String email = scanner.nextLine();
			
			System.out.print("Birth date(DD/MM/YYYY): ");
			Date birthDate = sdf.parse(scanner.next());
			
			Client client = new Client(name, email, birthDate);
			
			System.out.println(); 
			
			System.out.println("=================================");
			System.out.println("=========Enter order data========");
			System.out.println("=================================");
			
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(scanner.next());
			
			Order order = new Order(new Date(), status, client);
			
			System.out.print("How many items to this order? ");
			int n = scanner.nextInt();
			
			for (int i = 1; i <= n; i++) {
				System.out.println();
				System.out.println("Enter #"+i+" item data: ");
				System.out.print("Product name: ");
				scanner.nextLine();
				String productName = scanner.nextLine();
				System.out.print("Product price: U$ ");
				double productPrice = scanner.nextDouble();
				
				Product product = new Product(productName, productPrice);
				
				System.out.print("Quantity: ");
				int quantity = scanner.nextInt();
				
				OrderItem orderitem = new OrderItem(quantity, productPrice, product);
				
				order.addItem(orderitem);
			}
			
			System.out.println();
			System.out.println("ORDER SUMMARY");
			System.out.println(order);
			
		scanner.close();
		}
	}
}

























