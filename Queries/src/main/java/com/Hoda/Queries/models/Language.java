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
@Table(name="languages")
public class Language {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String countryCode;
private String language;
private String isOfficial;
private Float percentage;
@Column(updatable=false)
private Date createdAt;
private Date updatedAt;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="country_id")
private Country country;
public Language() {
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getIsOfficial() {
	return isOfficial;
}
public void setIsOfficial(String isOfficial) {
	this.isOfficial = isOfficial;
}
public Float getPercentage() {
	return percentage;
}
public void setPercentage(Float percentage) {
	this.percentage = percentage;
}
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}

}

