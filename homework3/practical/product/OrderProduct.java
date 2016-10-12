package homework3.practical.product;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by roma on 12.10.2016.
 */
public class OrderProduct {
    // sorted products by the field price in descending order
    public static Comparator<Product> ProductPrice = new Comparator<Product>() {
        @Override
        public int compare(Product product1, Product product2) {
            int price1 = (int) product1.getPrice();
            int price2 = (int) product2.getPrice();

            if( price1 < price2) { return 1; }
            else if( price1 > price2 ) { return -1; }
            else { return 0; }
        }
    };

    // Sorted products by the field quantity in descending order
    public static Comparator<Product> ProductQuantity = new Comparator<Product>() {
        @Override
        public int compare(Product product1, Product product2) {

            int quantity1 = (int) product1.getQuantity();
            int quantity2 = (int) product2.getQuantity();

            if (quantity1  < quantity2){ return 1; }
            else if ( quantity1 > quantity2 ) { return -1; }
            else { return 0;}

        }
    };
    // Get cost most expensive buy
    public static Product getMostExpensiveBuy(ArrayList<Product> products){
        double mostExpensive = 0;
        Product result = null;

        for(Product product: products){
            if(product.getCostBuy() > mostExpensive){
                mostExpensive = product.getCostBuy();
                result = product;
            }
        }
        return result;
    }
}
