package application;

import entities.Product;
import model.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
    Programa que a partir de um lista de produtos, calcule a
    soma dos preços somente dos produtos cujo nome começa com "T"
 */
public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        ProductService productService = new ProductService();

        double sum = productService.filteredSum(list);

        System.out.println("Sum = R$ " + String.format("%.2f", sum));

    }
}
