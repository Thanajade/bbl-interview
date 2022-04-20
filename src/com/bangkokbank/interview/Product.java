package com.bangkokbank.interview;

public class Product {

    private int id;
    private String name;
    private int price;
    private int amount;
    private int purchaseAmount;

    public Product(int id, String name, int price, int amount, int purchaseAmount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.purchaseAmount = purchaseAmount;
    }

    public boolean hasOverFiveThousand() {
        return this.price > 5000;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int getId() {
        return this.id;
    }
}
