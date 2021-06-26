package com.Hoda.Queries.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String country_code;
private String district;
private Integer population;
@Column(updatable=false)
private Date createdAt;
private Date updatedAt;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="country_id")
private Country country;
public City() {
}
public City(String country_code, String district, int population, Country country) {
	super();
	this.country_code = country_code;
	this.district = district;
	this.population = population;
	this.country = country;
}
public String getCountry_code() {
	return country_code;
}
public void setCountry_code(String country_code) {
	this.country_code = country_code;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public Integer getPopulation() {
	return population;
}
public void setPopulation(Integer population) {
	this.population = population;
}
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}

}
