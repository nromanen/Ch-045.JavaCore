package net.gavrilyuk.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ProductsStore Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class ProductsStore {

      private List<Product> products;

    public ProductsStore() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int index) {
        products.remove(index);
    }

    //find product of the most expensive item
    public Product getMostExpensive() {
        return Collections.max(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() < p2.getPrice())
                    return -1; // highest value first
                if (p1.getPrice() == p2.getPrice())
                    return 0;
                return 1;

            }
        });
    }

   //find one or more product(s) which has the biggest quantity
    public List<Product> getBiggestQuantity() {

        ArrayList<Product> result = new ArrayList<>();
        Product max = Collections.max(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getQuantity() < p2.getQuantity())
                    return -1;
                if (p1.getQuantity() == p2.getQuantity())
                    return 0;
                return 1;

            }
        });
        for (Product product : products) {
            if (product.equals(max)) {
                result.add(product);
            }
           /* if (product.getQuantity()==max.getQuantity()) {
                result.add(product);
            }*/
        }

        return result;

    }
}
