package br.com.william.spring_essentials.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {
	
	@Column(length = 100)
	@NotBlank(message = "Campo nome não pode ser vazio ou nulo")
	private String name;
	@NotEmpty(message = "Campo email não pode ser vazio")
	@Email
	private String email;
	
	
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private Student(String name) {
		super();
		this.name = name;
	}

	public Student(Long id, String name) {
		this(name);
		this.id = id;
	}
	
	
	public Student(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", id=" + id + "]";
	}
	
}
