/**
 * 
 */
package org.herb.dscrm;

import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author herb
 *
 */
@ActiveProfiles("test")
public class SimpleHibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Hero emp1 = new Hero();
		emp1.setFirstName("Tony");
		emp1.setLastName("Stark");
		emp1.setAlias("Iron Man");
		
		Hero emp2 = new Hero();
		emp2.setFirstName("Steve");
		emp2.setLastName("Rogers");
		emp2.setAlias("Captain America");
		
		Hero emp3 = new Hero();
		emp3.setFirstName("Natasha");
		emp3.setLastName("Romanoff");
		emp3.setAlias("Black Widow");
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
		
	}

}
