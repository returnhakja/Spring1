package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;

public class JPA01Update {
	public static void Update(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step11_JPA_Pratice");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		User user1 = em.find(User.class, id);
		tx.begin();
		try {
			
			user1.setAge(200);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback(); // 실행되기 전으로 돌려줘야함
		} finally {
			em.close();
		}
		emf.close();	
		}
	

}