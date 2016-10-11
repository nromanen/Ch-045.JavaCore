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
    public List<Product> products;

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

    public void input(){

        Product product1 = new Product("cup", 123, 10);
        Product product2 = new Product("pen", 100, 26);
        Product product3 = new Product("clock", 111, 11);
        Product product4 = new Product("book", 11, 77);

        products = new ArrayList<Product>();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }

    public void output(){

        System.out.println("Name and quantity of the most expensive item");
        System.out.print("Name       Price      Quantity\n");
        System.out.println(getMostExpensive()+"\n");

        System.out.println("Name of the items, which has the biggest quantity");
        System.out.print("Name       Price      Quantity\n");
        System.out.println(getBiggestQuantity());


        System.out.println("\nList products:");
        System.out.print("Name       Price      Quantity\n");
        for (Product product: products){
            System.out.println(product);
        }
    }

    public double getSum(){
        return (double) price * quantity;
    }

    public Product getMostExpensive(){
        double mostExpensive = 0;
        Product result = null;

        for(Product product: products){
            if(product.getSum() > mostExpensive){
                mostExpensive = product.getSum();
                result = product;
            }
        }
        return result;
    }

    public Product getBiggestQuantity(){

        int biggestQuantity = 0;
        Product result = null;
        for (Product product: products){
            if(product.getQuantity() > biggestQuantity ){
                biggestQuantity = product.getQuantity();
                result = product;
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return String.format("%-10s %-6.3f %5d",name,price,quantity);
    }

}
