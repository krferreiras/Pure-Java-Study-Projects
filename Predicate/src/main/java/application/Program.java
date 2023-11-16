package application;

import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;

/*
Fazer um programa que, a partir de uma lista de produtos, remova da
lista somente aqueles cujo preço mínimo seja 100.
 */
public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        list.removeIf(Product::staticProductPredicate);

        for (Product p : list){
            System.out.println(p);
        }
    }
}
