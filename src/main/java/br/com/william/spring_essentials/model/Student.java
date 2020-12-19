package br.com.william.spring_essentials.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
	private int id;
	private String name;
	private static List<Student> studentList;
	static {
		studentList = new ArrayList<Student>(
				Arrays.asList(new Student(0,"John William"), new Student(1,"John Wick"), new Student(2,"William Suane"),
						new Student(3,"Brennon"))
				);
	}
	public Student(String name) {
		super();
		this.name = name;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name) {
		this(name);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static List<Student> getStudentList() {
		return studentList;
	}

	public static void setStudentList(List<Student> studentList) {
		Student.studentList = studentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
