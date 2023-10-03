package com.jnu.student.data;

public class ShopItem {
    public int getImageResourceId() {
        return imageResourceId;
    }

    private int imageResourceId;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    private String name;
    private double price;

    public ShopItem(String name_, double price_, int imageResourceId_) {
        this.name=name_;
        this.price=price_;
        this.imageResourceId =imageResourceId_;
    }

}
