package entities;

public class Category {

	public int id;
	public String name;

	// constructors
	public Category() {
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// getters
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
}