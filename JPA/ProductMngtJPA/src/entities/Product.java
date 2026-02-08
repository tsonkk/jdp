package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import daos.CategoryDAO;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int id;

	@Column(name = "Name")
	public String name;

	@Column(name = "Price")
	public int price;

	@ManyToOne
	@JoinColumn(name = "CatID")
	public Category category;

	// constructors
	public Product() {}
	public Product(int id, String name, int price, int catID) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = CategoryDAO.getDetails(catID);
	}

}