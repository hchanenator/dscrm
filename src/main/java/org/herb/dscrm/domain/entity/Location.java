/**
 * 
 */
package org.herb.dscrm.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author hchan
 *
 */
@Entity
@Table(name="LOCATION")
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2257273865607168919L;
	
	@Id
	@Column(name="location_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long locationId;
	
	@Column(name="location_name", nullable=false)
	private String locationName;
	
	@OneToMany(mappedBy="location")
	private Set<Team> teams = new HashSet<>();

	/**
	 * 
	 */
	public Location() {	}
	
	

	/**
	 * @param locationName
	 */
	public Location(String locationName) {
		this.locationName = locationName;
	}



	/**
	 * @return the locationId
	 */
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	/**
	 * @return the teams
	 */
	public Set<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams the teams to set
	 */
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + "]";
	}
	
	

}
