package conditional.practice.product;

 /*
  * Create class Product with fields name, price and quantity.
  * Create four instances of type Product.
  * Display the name and quantity of the most expensive item.
  * Display the name of the items, which has the biggest quantity.
  */

import static conditional.practice.product.Order.*;
import static util.Print.println;

public class Main {
 public static void main(String[] args) {
  addProduct(new Product("Milk", 12.45, 4));
  addProduct(new Product("Bread", 8.45, 2));
  addProduct(new Product("Beer", 15.0, 5));
  addProduct(new Product("Milk", 12.45, 3));

  println("Order list: ");

  for (Product product : gerProducts()) {
   println(product);
  }
  println();
  println("The most expensive product is ", mostExpensive().getName(), ", quantity is ", mostExpensive().getQuantity(), "." );
  println("The biggest quantity has ", biggestQuantity().getName(), ", price is ", biggestQuantity().getPrice(), ".");

 }
}
