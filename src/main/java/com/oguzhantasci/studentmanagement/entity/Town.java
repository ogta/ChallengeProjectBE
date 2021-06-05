package com.oguzhantasci.studentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TOWN")
public class Town {

	@Id
	@GeneratedValue
	@Column(name = "TOWN_ID")
	private Long townId;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
