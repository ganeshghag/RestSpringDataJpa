package com.ghag.rnd.rest.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private Boolean enabled;
	

	@OneToMany(mappedBy="users", cascade=CascadeType.ALL)
	private Set<Roles> authorities;
	
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Roles> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Roles> authorities) {
		this.authorities = authorities;
	}
	
	
	
}
