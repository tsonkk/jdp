package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int id;

	@Column(name = "Name")
	public String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category") // mapped by Product.category
	public List<Product> products;

	// constructors
	public Category() {}
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

}