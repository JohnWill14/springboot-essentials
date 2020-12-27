package br.com.william.spring_essentials.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User extends AbstractEntity {
	@NotBlank
	@Column(unique = true)
	private String username;
	@NotEmpty
	@JsonIgnore
	private String password;
	private String name;
	@NotEmpty
	private boolean adimin;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String name, boolean adimin) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.adimin = adimin;
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
	public boolean isAdimin() {
		return adimin;
	}
	public void setAdimin(boolean adimin) {
		this.adimin = adimin;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", adimin=" + adimin + "]";
	}
	
	
}
