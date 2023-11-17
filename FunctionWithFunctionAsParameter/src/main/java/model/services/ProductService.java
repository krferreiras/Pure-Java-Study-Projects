package model.services;

import entities.Product;

import java.util.List;

public class ProductService {

    public double filteredSum(List<Product> list) {
        double sum = 0.0;
        for(Product product : list) {
            if (product.getName().charAt(0) == 'T'){
                sum += product.getPrice();
            }
        }
        return sum;
    }
}
