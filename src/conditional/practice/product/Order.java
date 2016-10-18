package conditional.practice.product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.10.16.
 */
public class Order {

    private static List<Product> products = new ArrayList<>();

    public static void addProduct(Product product){
        for (int i = 0; i < products.size(); i++){
            if(product.equals(products.get(i))){
                products.get(i).setQuantity(products.get(i).getQuantity() + product.getQuantity());
                return;
            }
        }
        products.add(product);
    }

    public static Product mostExpensive(){
        Product result = products.get(0);

        for (Product product : products) {
            if(product.getPrice() > result.getPrice()){
                result = product;
            }
        }

        return result;
    }

    public static Product biggestQuantity(){
        Product result = products.get(0);

        for (Product product : products) {
            if(product.getQuantity() > result.getQuantity()){
                result = product;
            }
        }

        return result;
    }

    public static List<Product> gerProducts(){
        return products;
    }
}
