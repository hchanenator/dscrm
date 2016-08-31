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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hchan
 *
 */
@Entity
@Table(name="TEAM")
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6082707979932853934L;
	
	@Id
	@Column(name="team_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long teamId;
	
	@Column(name="team_name")
	private String teamName;
	
	@ManyToOne(targetEntity=Universe.class)
	@JoinColumn(name="location_Id")
	private Universe location;

	/**
	 * 
	 */
	public Team() {
	}
	
	
	/**
	 * @param teamName
	 */
	public Team(String teamName) {
		this.teamName = teamName;
	}
	
	
	/**
	 * @param teamName
	 * @param location
	 */
	public Team(String teamName, Universe location) {
		this.teamName = teamName;
		this.location = location;
	}



	/**
	 * @return the teamId
	 */
	public Long getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the location
	 */
	public Universe getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Universe location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
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
		Team other = (Team) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", location=" + location + "]";
	}

	
	
}
