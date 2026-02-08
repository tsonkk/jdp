package daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import entities.Category;
import utils.JpaUtil;

public class CategoryDAO {

	public static List<Category> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT c FROM Category c"; // Category is Entity object (is not Table in RDBMS)
		TypedQuery<Category> query = em.createQuery(jpql, Category.class);
		List<Category> cats = query.getResultList();
		em.close();
		return cats;
	}

	public static Category getDetails(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		Category cat = em.find(Category.class, id); // return null if object is not found
		em.close();
		return cat;
	}

	public static List<Category> search(String keyword) {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT c FROM Category c WHERE c.name LIKE :keyword";
		TypedQuery<Category> query = em.createQuery(jpql, Category.class);
		query.setParameter("keyword", "%" + keyword + "%");
		List<Category> cats = query.getResultList();
		em.close();
		return cats;
	}

	public static boolean insert(Category newCat) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newCat);
			em.getTransaction().commit();
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		return result;
	}

	public static int insert2newID(Category newCat) {
		int result = 0;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newCat);
			em.getTransaction().commit();
			result = newCat.id;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		return result;
	}

	public static boolean update(Category newCat) { // newCat is transient object
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		Category dbCat = em.find(Category.class, newCat.id); // dbCat is persistent object
		if (dbCat != null) {
			try {
				em.getTransaction().begin();
				em.merge(newCat);
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
		Category dbCat = em.find(Category.class, id);
		if (dbCat != null) {
			try {
				em.getTransaction().begin();
				em.remove(dbCat);
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