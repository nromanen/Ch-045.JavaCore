package net.gavrilyuk.products;

import java.util.UUID;

/**
 * Product Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class Product {

    private UUID mId; //product id
    private String mName;
    private double mPrice;
    private long mQuantity;

    public Product() {
        this("", 0, 0);
    }

    public Product(String name, double price, int quantity) {
        mId = UUID.randomUUID();
        mName = name;
        mPrice = price;
        mQuantity = quantity;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(long quantity) {
        mQuantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name='" + mName + '\'' +
                ", Price=" + String.format("%,.2f", mPrice) +
                ", Quantity=" + mQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getQuantity() == product.getQuantity();
    }


}
