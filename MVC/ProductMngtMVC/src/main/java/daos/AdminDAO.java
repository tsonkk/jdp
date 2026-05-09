package daos;

import entities.Admin;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class AdminDAO {
	
	public static Admin getDetails(String username) {
		EntityManager em = JpaUtil.getEntityManager();
		Admin admin = em.find(Admin.class, username);
		em.close();
		return admin;
	}
	
}