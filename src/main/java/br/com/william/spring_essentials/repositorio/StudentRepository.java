package br.com.william.spring_essentials.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.william.spring_essentials.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findByName(String name);
}
