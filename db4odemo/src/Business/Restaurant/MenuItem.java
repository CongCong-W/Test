/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package Business.Restaurant;

/**
 * @author zhicheng.czc
 * @version $ Id: MenuItem.java, v 0.1 2020年11月08日 12:05 PM zhicheng.czc Exp $
 */
public class MenuItem {

    private String name;

    private int price;

    private Restaurant restaurant;

    public MenuItem(String name, int price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
