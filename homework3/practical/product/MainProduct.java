package homework3.practical.product;

import java.util.*;

/**
 * Created by roma on 07.10.2016.
 */
public class MainProduct {
    public static void main(String[] args){

        Product product1 = new Product("cup", 3, 10);
        Product product2 = new Product("box", 9, 10);
        Product product3 = new Product("clock", 4, 11);
        Product product4 = new Product("book", 6, 7);
        Product product5 = new Product("tester", 5, 7);

        ArrayList<Product> products = new ArrayList<Product>();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        System.out.println("List products:");
        System.out.print("Name       Price      Quantity\n");
        for (Product product: products){
            System.out.println(product);
        }

        Collections.sort(products,OrderProduct.ProductPrice);
        System.out.println("\nName and quantity of the most expensive item:");
        System.out.print("Name       Price      Quantity\n");
        System.out.println(products.get(0));

        Collections.sort(products,OrderProduct.ProductQuantity);
        System.out.println("\nName of the items, which has the biggest quantity");
        System.out.print("Name       Price      Quantity\n");
        System.out.println(products.get(0));

        System.out.println("\nCost most expensive buy: ");
        System.out.print("Name       Price      Quantity\n");
        System.out.println(OrderProduct.getMostExpensiveBuy(products));
    }
}
