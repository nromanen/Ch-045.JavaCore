package conditional.practice.product;

/**
 * Created by Admin on 18.10.16.
 */
public class Product {

    private String name;
    private double price = 1;
    private int quantity = 1;

    public Product(String name, double price, int quantity) {
        this.name = name;
        if (price > 0){
            this.price = price;
        }
        if ( quantity > 0){
            this.quantity = quantity;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if ( quantity > 0){
            this.quantity = quantity;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        return !(getName() != null ? !getName().equals(product.getName()) : product.getName() != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", price: " + price + ", quantity: " + quantity;
    }
}
