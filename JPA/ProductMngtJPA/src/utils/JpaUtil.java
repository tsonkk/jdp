package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = null;
	
	private static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("ProductMngtJPA");
		}
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
}