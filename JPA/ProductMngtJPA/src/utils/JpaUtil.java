package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManager em = null;

	public static EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = Persistence.createEntityManagerFactory("ProductMngtJPA").createEntityManager();
		}
		return em;
	}
}