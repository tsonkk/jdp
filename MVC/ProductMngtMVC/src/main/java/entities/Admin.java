package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@Column(name = "Username")
	public String username;

	@Column(name = "Password")
	public String password;

	// constructors
	public Admin() {
	}

	// getters
	public String getUsername() {
		return username;
	}

}