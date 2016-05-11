/**
 * 
 */
package org.herb.dscrm.system.persistence;

import org.herb.dscrm.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author herb
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByLastName(String lastName);
}
