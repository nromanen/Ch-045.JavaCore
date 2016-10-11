package oddnumber;

//import java.util.Comparator;

public class Product {
	String name;
	double price;
	int quantity;

	public static void main(String[] args) {
		Product p1 = new Product("Black Pepper", 3.70, 30);
		Product p2 = new Product("Pepper chilli", 6.40, 12);
		Product p3 = new Product("Paprika", 11.30, 8);
		Product p4 = new Product("Mandarin", 16.00, 10);
		if (p1.price > p2.price && p1.price > p3.price && p1.price>p4.price) {
		System.out.println("Most expensive is " + p1.name);
		}
		if (p2.price > p1.price && p2.price > p3.price && p2.price>p4.price) {
			System.out.println("Most expensive is " + p2.name);
			}
		if (p3.price > p2.price && p3.price > p1.price && p3.price>p4.price) {
			System.out.println("Most expensive is " + p3.name);
			}
		if (p4.price > p2.price && p4.price > p3.price && p4.price>p1.price) {
			System.out.println("Most expensive is " + p4.name);
			}
		
		if (p1.quantity > p2.quantity && p1.quantity > p3.quantity && p1.quantity>p4.quantity) {
			System.out.println(p1.name + "has the biggest quantity(" + p1.quantity + ")");
			}
			if (p2.quantity > p1.quantity && p2.quantity > p3.quantity && p2.quantity>p4.quantity) {
				System.out.println(p2.name + "has the biggest quantity(" + p2.quantity + ")");
				}
			if (p3.quantity > p2.quantity && p3.quantity > p1.quantity && p3.quantity>p4.quantity) {
				System.out.println(p3.name + "has the biggest quantity(" + p3.quantity + ")");
				}
			if (p4.quantity > p2.quantity && p4.quantity > p3.quantity && p4.quantity>p1.quantity) {
				System.out.println(p4.name + "has the biggest quantity (" + p4.quantity + ")");
				}
	}
	
	
	
	

	public Product() {
	}

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;

	}

	
	


	}

