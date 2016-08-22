/**
 * 
 */
package org.herb.dscrm.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author herb
 *
 */
@Entity
@Table(name="HERO")
public class Hero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3587786807705161664L;
	
	@Id
	@Column(name="hero_id", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long heroId;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="alter_ego")
	private String alias;
	
	public Hero() {
		
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param alias
	 */
	public Hero(String firstName, String lastName, String alias) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.alias = alias;
	}

	public Long getEmployeeId() {
		return heroId;
	}

	public void setEmployeeId(Long employeeId) {
		this.heroId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((heroId == null) ? 0 : heroId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (heroId == null) {
			if (other.heroId != null)
				return false;
		} else if (!heroId.equals(other.heroId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + heroId + ", firstName=" + firstName + ", lastName=" + lastName + ", alias="
				+ alias + "]";
	}

}
