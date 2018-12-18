package com.airline.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="airport")
public class Airport  implements Serializable {


    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id = null;
    
	@Column(name="code", unique=true)
	private String code;
    
	@Column(name="name")
	private String name;
	
	@Column(name="city")
	private String city;

	public Airport( String code, String name, String city) {
		this.code = code;
		this.name = name;
		this.city = city;
	}
	public Airport() {
		
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Airport [code=" + code + ", name=" + name + ", city=" + city + "]";
	}
	
	
	
	
}
