package br.com.william.spring_essentials.repositorio;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.william.spring_essentials.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
	List<Student> findByNameIgnoreCaseContaining(String name);
}
