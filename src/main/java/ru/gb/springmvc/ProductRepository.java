package ru.gb.springmvc;

import java.util.ArrayList;
import java.util.List;


public class ProductRepository {

    public List productRepository(){
        List<Product> productList = List.of(
        new Product(1, "Apple", 10),
        new Product(2, "Orange", 10),
        new Product(3, "Cherry", 10),
        new Product(4, "Peach", 10),
        new Product(5, "Banana", 10));

        return productRepository();
    }

    public List addProd(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        return productList;
    }
}

