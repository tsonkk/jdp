import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
		// b1
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Connect2DB");
		EntityManager em = emf.createEntityManager();
		// b2
		String jpql = "SELECT c FROM Customer c"; // Customer is Entity object (is not Table in RDBMS)
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		// b3
		List<Customer> custs = query.getResultList();
		// b4
		for (Customer cust : custs) {
			System.out.println(cust.getId() + "\t" + cust.name + "\t" + cust.getAge());
		}
		// b5
		em.close();
		emf.close();
	}

}