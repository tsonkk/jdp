package daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import entities.Product;
import utils.JpaUtil;

public class ProductDAO {

	public static List<Product> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT p FROM Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		List<Product> prods = query.getResultList();
		em.close();
		return prods;
	}

	public static Product getDetails(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		Product prod = em.find(Product.class, id);
		em.close();
		return prod;
	}

	public static List<Product> search(String keyword) {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT p FROM Product p WHERE p.name LIKE :keyword";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("keyword", "%" + keyword + "%");
		List<Product> prods = query.getResultList();
		em.close();
		return prods;
	}

	public static boolean insert(Product newProd) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newProd);
			em.getTransaction().commit();
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		return result;
	}

	public static boolean update(Product newProd) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		Product dbProd = em.find(Product.class, newProd.id);
		if (dbProd != null) {
			try {
				em.getTransaction().begin();
				em.merge(newProd);
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
		Product dbProd = em.find(Product.class, id);
		if (dbProd != null) {
			try {
				em.getTransaction().begin();
				em.remove(dbProd);
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