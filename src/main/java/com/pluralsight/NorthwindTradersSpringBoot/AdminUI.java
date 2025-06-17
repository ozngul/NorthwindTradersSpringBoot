package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class AdminUI implements CommandLineRunner {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                \n1. List Products
                2. Add Product
                0. Exit
                """);

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    List<Product> products = productDAO.getAll();
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case "2":
                    System.out.print("Product ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(id, name, category, price);
                    productDAO.add(product);
                    System.out.println("Product added.");
                    break;
                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
