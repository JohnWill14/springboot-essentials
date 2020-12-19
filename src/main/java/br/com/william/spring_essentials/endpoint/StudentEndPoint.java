package br.com.william.spring_essentials.endpoint;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.william.spring_essentials.model.Student;
import br.com.william.spring_essentials.util.DateUtil;

@RestController // @Controller- controler. @ResponseBody- retornar dados pelo corpo da resposta
@RequestMapping("/v1/student")
public class StudentEndPoint {

	private DateUtil dateUtil;

	@Autowired
	public StudentEndPoint(DateUtil dateUtil) {
		super();
		this.dateUtil = dateUtil;
	}




	@RequestMapping(path = "/list", method = RequestMethod.GET)
	private List<?> getListStudent() {
		System.out.println(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
		return Arrays.asList(new Student("John William"), new Student("John Wick"), new Student("William Suane"),
				new Student("Brennon"));

	}
}
