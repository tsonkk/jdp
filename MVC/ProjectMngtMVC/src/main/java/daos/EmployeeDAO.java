package daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import entities.Employee;
import utils.JpaUtil;

public class EmployeeDAO {

	public static List<Employee> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT e FROM Employee e";
		TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
		List<Employee> emps = query.getResultList();
		em.close();
		return emps;
	}
	
	public static List<Employee> getByProjID(int projID) {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT e FROM Employee e WHERE e.project.id=:projID";
		TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
		query.setParameter("projID", projID);
		List<Employee> emps = query.getResultList();
		em.close();
		return emps;
	}

	public static boolean insert(Employee newEmp) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newEmp);
			em.getTransaction().commit();
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		return result;
	}
	
	public static boolean delete(int id) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		Employee dbEmp = em.find(Employee.class, id);
		if (dbEmp != null) {
			try {
				em.getTransaction().begin();
				em.remove(dbEmp);
				em.getTransaction().commit();
				result = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		em.close();
		return result;
	}

}