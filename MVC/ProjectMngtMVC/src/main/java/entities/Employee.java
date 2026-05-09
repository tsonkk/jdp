package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import daos.ProjectDAO;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "fullname")
	public String fullname;

	@Column(name = "gen")
	public boolean gen;

	@ManyToOne
	@JoinColumn(name = "project_id")
	public Project project;

	// constructors
	public Employee() {}
	public Employee(int id, String fullname, boolean gen, int projID) {
		this.id = id;
		this.fullname = fullname;
		this.gen = gen;
		this.project = ProjectDAO.getDetails(projID);
	}
	
	// getters
	public int getId() {
		return this.id;
	}
	public String getFullname() {
		return this.fullname;
	}
	public boolean getGen() {
		return this.gen;
	}
	public Project getProject() {
		return this.project;
	}

}