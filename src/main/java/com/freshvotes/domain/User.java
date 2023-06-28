package com.freshvotes.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.freshvotes.security.Authority;

@Entity
@Table(name = "users")
public class User 
{
	
	
	private Long id;
	private String name;
	private String username;
	private String password;
//	@OneToMany(targetEntity = Authority.class, mappedBy="user", fetch=FetchType.EAGER, cascade = CascadeType.ALL) 
	private Set<Authority> authorities = new HashSet<>();
	
//	@OneToMany(targetEntity = Product.class, mappedBy="user", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST) 
	private Set<Product> products = new HashSet<>();

	private Set<Feature> features = new HashSet<>();
	
	
	@OneToMany(targetEntity = Product.class, mappedBy="user", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST) 
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	@OneToMany(targetEntity = Authority.class, mappedBy="user", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", authorities=" + authorities + "]";
	}
	@OneToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy="user")
	public Set<Feature> getFeatures(){
		return features;
	}
	public void setFeatures(Set<Feature> features){
		this.features = features;
	}
	
	
	
} // end class
