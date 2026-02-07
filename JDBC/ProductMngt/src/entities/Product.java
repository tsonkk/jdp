package entities;

public class Product {

	public int id;
	public String name;
	public int price;
	public int catID;

	// constructors
	public Product() {
	}

	public Product(int id, String name, int price, int catID) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.catID = catID;
	}

}