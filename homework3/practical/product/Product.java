package homework3.practical.product;

import java.util.*;

/**
 * Created by roma on 05.10.2016.
 * Create class Product with fields name, price and quantity.
 * Create four instances of type Product.
    * Display the name and quantity of the most expensive item.
    * Display the name of the items, which has the biggest quantity.

 */
public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(){
    }
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCostBuy(){
        return (double) price * quantity;
    }

    @Override
    public String toString(){
        return String.format("%-10s %-6.2f %5d",name,price,quantity);
    }

}
