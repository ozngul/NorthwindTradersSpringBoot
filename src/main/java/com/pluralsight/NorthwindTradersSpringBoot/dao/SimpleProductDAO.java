package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {
    private List<Product> products;

    public SimpleProductDAO() {
        products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 1200.00));
        products.add(new Product(2, "Coffee Mug", "Kitchen", 8.99));
        products.add(new Product(3, "Notebook", "Stationery", 3.50));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
