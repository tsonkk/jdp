package entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "name")
	public String name;
	
	@Column(name = "deadline")
	public Date deadline;

	@OneToMany(mappedBy = "project") // mapped by Employee.project
	public List<Employee> employees;

	// constructors
	public Project() {}
	public Project(int id, String name, Date deadline) {
		this.id = id;
		this.name = name;
		this.deadline = deadline;
	}
	
	// getters
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public Date getDeadline() {
		return this.deadline;
	}
	public List<Employee> getEmployees() {
		return this.employees;
	}

}