package com.ghag.rnd.rest.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authorities")
public class Roles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "username",referencedColumnName="username")
	private Users users;
	
	@NotNull
	private String authority;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
}
