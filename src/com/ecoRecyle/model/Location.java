package com.ecoRecyle.model;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION")
public class Location {
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "city")
	private String city;

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
	
	//To string
	//Date times
}
