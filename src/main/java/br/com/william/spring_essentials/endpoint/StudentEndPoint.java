package br.com.william.spring_essentials.endpoint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.spring_essentials.model.Student;
import br.com.william.spring_essentials.util.DateUtil;

@RestController // @Controller- controler. @ResponseBody- retornar dados pelo corpo da resposta
@RequestMapping("/v1/students")
public class StudentEndPoint {

	private DateUtil dateUtil;

	@Autowired
	public StudentEndPoint(DateUtil dateUtil) {
		super();
		this.dateUtil = dateUtil;
	}




	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<?> getListStudent() {
		System.out.println(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(Student.getStudentList(), HttpStatus.OK);

	}
	@RequestMapping(path ="/{id}" ,method = RequestMethod.GET)
	private ResponseEntity<?> getStudentByID(@PathVariable("id")int id) {
		Student student = new Student();
		student.setId(id);
		int index = Student.getStudentList().indexOf(student);
		
		if(index>=0) student = Student.getStudentList().get(index);
		else student = null;
		return new ResponseEntity<>(student, HttpStatus.OK);

	}
}
