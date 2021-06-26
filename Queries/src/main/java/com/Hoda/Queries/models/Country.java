package com.Hoda.Queries.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String name;
	private String continent;
	private String region;
	private Double surfacearea;
	private Short indepyear;
	private Integer population;
	private  Double expectancy;
	private Double gnp_old;
	private String localname;
	private String governmentForm;
	private String headOfState;
	private Integer capital;
	private String code2;
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cities;
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> languages;
	public Country() {

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Double getSurfacearea() {
		return surfacearea;
	}
	public void setSurfacearea(Double surfacearea) {
		this.surfacearea = surfacearea;
	}
	public Short getIndepyear() {
		return indepyear;
	}
	public void setIndepyear(Short indepyear) {
		this.indepyear = indepyear;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Double getExpectancy() {
		return expectancy;
	}
	public void setExpectancy(Double expectancy) {
		this.expectancy = expectancy;
	}
	public Double getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(Double gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocalname() {
		return localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getGovernmentForm() {
		return governmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
}
