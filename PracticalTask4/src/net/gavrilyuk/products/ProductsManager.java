package net.gavrilyuk.products;

/**
 * ProductsStore Manager Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class ProductsManager {

    public static void main(String[] args) {
        ProductsStore products = new ProductsStore();
        // fill store products
        products.addProduct(new Product("Product1", 2.5, 4));
        products.addProduct(new Product("Product2", 20, 153));
        products.addProduct(new Product("Product3", 21.5, 18));
        products.addProduct(new Product("Product4", 10, 2));
        products.addProduct(new Product("product5", 20, 153));

        System.out.println("The most expensive item:Name="+products.getMostExpensive().getName()+" quantity="+products.getMostExpensive().getQuantity());
        System.out.println("The biggest quantity:");
        for (Product product : products.getBiggestQuantity()) {
            System.out.println("Name="+product.getName());
        }
    }
}
