package daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import entities.Project;
import utils.JpaUtil;

public class ProjectDAO {

	public static List<Project> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "SELECT p FROM Project p";
		TypedQuery<Project> query = em.createQuery(jpql, Project.class);
		List<Project> projs = query.getResultList();
		em.close();
		return projs;
	}

	public static Project getDetails(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		Project proj = em.find(Project.class, id);
		em.close();
		return proj;
	}
	
	public static boolean insert(Project newProj) {
		boolean result = false;
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newProj);
			em.getTransaction().commit();
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		return result;
	}

}