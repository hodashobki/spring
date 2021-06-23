package com.Hoda.dojoNinja.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dojos")
public class Dojo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotNull
private String name;
@Column(updatable=false)
private Date createdAt;
private Date updatedAt;
@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
private List<Ninja> ninjas;

public Dojo() {
}
public Dojo(@NotNull String name, List<Ninja> ninjas) {
	super();
	this.name = name;
	this.ninjas = ninjas;
}


public Long getId() {
	return id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Ninja> getNinjas() {
	return ninjas;
}
public void setNinjas(List<Ninja> ninjas) {
	this.ninjas = ninjas;
}
@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}
}
