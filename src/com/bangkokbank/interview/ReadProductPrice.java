package com.bangkokbank.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ReadProductPrice {

    public static void main(String[] args) throws IOException {
        String file = "src/com/bangkokbank/interview/product.dat";
        List<Product> productList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.ready()) {
            String currentLine = reader.readLine();
            String[] row = currentLine.split("\\|");
            Product p = new Product(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
            productList.add(p);
        }

        reader.close();

        // output 1
        List<Product> productWithPriceMoreThan5000 = productList
                .stream()
                .filter(p -> p.getPrice() > 5000)
                .collect(Collectors.toList());

        System.out.println("Product Report (Price > 5000");
        System.out.println("Product Name    Price   Amount");
        System.out.println("*******************************");

        for (Product p : productWithPriceMoreThan5000) {
            System.out.println(String.format("%s        %s      %s", p.getName(), p.getPrice(), p.getAmount()));
        }

        // output 2
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        String productName = sc.nextLine();

        List<Product> enterProduceName = productList
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .collect(Collectors.toList());

        if (!enterProduceName.isEmpty()) {
            Product p = enterProduceName.get(0);
            System.out.println(String.format("%s - %s bahts", p.getName(), p.getPrice()));
            System.out.println(String.format("%s units", p.getAmount()));
        }

        // output 3

        List<Product> purchaseProduct = productList
                .stream()
                .filter(p -> p.getAmount() <= p.getPurchaseAmount() )
                .collect(Collectors.toList());

        if (!purchaseProduct.isEmpty()) {

            System.out.println("Purchase Report");
            System.out.println("ID  Product Name    Price   Amount to buy");
            System.out.println("*******************************");

            for (Product p : purchaseProduct) {
                System.out.println(String.format("%s    %s  %s  %s", p.getId(), p.getName(), p.getPrice(), p.getAmount() + 5));
            }


        }
    }
}
