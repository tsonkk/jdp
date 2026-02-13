package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int id;

	@Column(name = "Name")
	public String name;
	
	@Column(name = "Age")
	public int age;
	
	// constructors
	public Customer() {}
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