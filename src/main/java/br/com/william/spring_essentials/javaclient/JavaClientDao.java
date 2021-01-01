package br.com.william.spring_essentials.javaclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.william.spring_essentials.handler.RestResponseExceptionHandler;
import br.com.william.spring_essentials.model.PageableResponse;
import br.com.william.spring_essentials.model.Student;

public class JavaClientDao {
	private static final String USER = "mito";
	private static final String PASSWORD = "qwe123";
	private static RestTemplate restTemplateUSER;
	private static RestTemplate restTemplateADM;

	static {
		restTemplateUSER = getRestTemplateByRootURI("http://localhost:8080/v1/user/students");
		restTemplateADM = getRestTemplateByRootURI("http://localhost:8080/v1/admin/students");
	}

	private static RestTemplate getRestTemplateByRootURI(String rootUri) {
		RestTemplate restTemplate = new RestTemplateBuilder().rootUri(rootUri).basicAuthorization(USER, PASSWORD)
				.errorHandler(new RestResponseExceptionHandler())
				.build();
		return restTemplate;
	}

	private static HttpHeaders createJSONHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return headers;
	}

	public Student getById(Long id) {
		return restTemplateUSER.getForObject("/{id}", Student.class, id);

	}

	public List<Student> getAll(String pageable) {
		return restTemplateUSER
				.exchange("/?"+pageable, HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Student>>() {
				}).getBody().getContent();

	}public List<Student> getAll() {
		return getAll("");

	}
	public Student save(Student student) {
		ResponseEntity<Student> studentPost = restTemplateADM.exchange("/", HttpMethod.POST, new HttpEntity<>(student, createJSONHeader()), 
				Student.class);
		return studentPost.getBody();
	}
	public void update(Student student) {
		 restTemplateADM.put("/", student);
	}
	public void delete(Long id) {
		 restTemplateADM.delete("/{id}",id);
		
	}

}
