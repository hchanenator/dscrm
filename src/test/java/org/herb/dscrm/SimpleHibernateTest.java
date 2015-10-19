/**
 * 
 */
package org.herb.dscrm;

import org.herb.dscrm.domain.entity.Employee;
import org.herb.dscrm.system.util.HibernateUtil;
import org.hibernate.Session;

/**
 * @author herb
 *
 */
public class SimpleHibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Employee emp1 = new Employee();
		emp1.setFirstName("Tony");
		emp1.setLastName("Stark");
		emp1.setAlias("Iron Man");
		
		Employee emp2 = new Employee();
		emp2.setFirstName("Steve");
		emp2.setLastName("Rogers");
		emp2.setAlias("Captain America");
		
		Employee emp3 = new Employee();
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
