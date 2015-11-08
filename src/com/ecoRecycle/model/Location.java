package com.ecoRecycle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOCATION")
public class Location {
	@Id 
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "city", unique = true)
	private String city;
	
	@Column(name = "createDateTime")
	private Date createDateTime;
	
	@Column(name = "updateDateTime")
	private Date updateDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + "]";
	}
		
}
