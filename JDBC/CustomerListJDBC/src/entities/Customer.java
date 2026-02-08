package entities;

public class Customer {

	public int id;
	public String name;
	public int age;

	// constructors
	public Customer() {
	}

	public Customer(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	// getters
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

}