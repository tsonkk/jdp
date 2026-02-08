package daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import entities.Customer;
import utils.JpaUtil;

public class CustomerDAO {

	public static List<Customer> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT c FROM Customer c"; // Customer is Entity object (is not Table in RDBMS)
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		List<Customer> custs = query.getResultList();
		em.close();
		return custs;
	}

	public static boolean insert(Customer newCust) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newCust);
			em.getTransaction().commit();
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		return result;
	}

	public static boolean update(Customer newCust) { // newCust is transient object
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		Customer dbCust = em.find(Customer.class, newCust.id); // dbCust is persistent object
		if (dbCust != null) {
			try {
				em.getTransaction().begin();
				em.merge(newCust);
				em.getTransaction().commit();
				result = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		em.close();
		return result;
	}

	public static boolean delete(int id) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		Customer dbCust = em.find(Customer.class, id);
		if (dbCust != null) {
			try {
				em.getTransaction().begin();
				em.remove(dbCust);
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