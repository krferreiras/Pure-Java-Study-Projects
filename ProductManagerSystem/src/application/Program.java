package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try(Scanner sc = new Scanner(System.in)){
			
			System.out.print("Enter the number of products: ");
			int numberOfProducts = sc.nextInt();
			
			for(int i = 1; i <= numberOfProducts; i++) {
				System.out.println("PRODUCT #" + i + " data:" );
				System.out.print("Common, used or imported (c/u/i)? ");
				char ch = sc.next().charAt(0);
				
				if(ch == 'c') {
					System.out.print("Name: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Price: ");
					double price = sc.nextDouble();
					
					list.add(new Product(name, price));
				}else if (ch == 'u') {
					System.out.print("Name: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Price: ");
					double price = sc.nextDouble();
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufacuteDate = sdf.parse(sc.next());
					
					list.add(new UsedProduct(name, price, manufacuteDate));
				}else {
					System.out.print("Name: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Price: ");
					double price = sc.nextDouble();
					System.out.print("Customs fee: ");
					double customsFee = sc.nextDouble();
					
					list.add(new ImportedProduct(name, price, customsFee));
				}
			}
			
			System.out.println();
			System.out.println("PRICE TAGS");
			for(Product product:list) {
				System.out.println(product.priceTag());
			}
			
			sc.close();
		}
	}
}
