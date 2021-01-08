package br.com.william.spring_essentials.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.spring_essentials.error.exception.ResourceNotFoundException;
import br.com.william.spring_essentials.model.Student;
import br.com.william.spring_essentials.repositorio.StudentRepository;

@RestController // @Controller- controler. @ResponseBody- retornar dados pelo corpo da resposta
@RequestMapping("/v1")
public class StudentEndPoint {

	private final StudentRepository dao;

	@Autowired
	public StudentEndPoint(StudentRepository dao) {
		super();
		this.dao = dao;
	}

//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = "/user/students")
	public ResponseEntity<?> getListStudent(Pageable pg) {
		//localhost:8080/v1/students?page=3&size=3
		//localhost:8080/v1/students?sort=camp,asc/desc
//		System.out.println(dao.findAll());
		return new ResponseEntity<>(dao.findAll(pg), HttpStatus.OK);

	}

//	@RequestMapping(path ="/{id}" ,method = RequestMethod.GET)
	@GetMapping(path = "/user/students/{id}")
	public ResponseEntity<?> getStudentByID(@PathVariable("id") Long id) {
		verifyIfStudentExists(id);
		Student student = dao.findOne(id);
		return new ResponseEntity<>(student, HttpStatus.OK);

	}

	@GetMapping(path = "/user/students/findByName/{name}")
	public ResponseEntity<?> findStudentByName(@PathVariable("name") String name) {
		List<Student> listaStudentWithName = dao.findByNameIgnoreCaseContaining(name);
		return new ResponseEntity<>(listaStudentWithName, HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping(path = "/admin/students/")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) {
		dao.save(student);

		return new ResponseEntity<>(student, HttpStatus.CREATED);

	}

//	@RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping(path = "/admin/students/{id}")
//	@PreAuthorize("hasRole('ADM')")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		
		verifyIfStudentExists(id);
		dao.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

//	@RequestMapping(method = RequestMethod.PUT)
	@PutMapping(path = "/admin/students/")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		verifyIfStudentExists(student.getId());
		dao.save(student);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	private void verifyIfStudentExists(Long id) {
		Student student = dao.findOne(id);
		if (student == null)
			throw new ResourceNotFoundException("Student not found for ID: " + id);

	}
}
