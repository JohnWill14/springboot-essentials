package br.com.william.spring_essentials.javaclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.william.spring_essentials.model.PageableResponse;
import br.com.william.spring_essentials.model.Student;

public class javaSpringClientTest {
	private static RestTemplate getRestTemplateByRootURI(String rootUri) {
		RestTemplate restTemplate = new RestTemplateBuilder()
				.rootUri(rootUri)
				.basicAuthorization("mito", "qwe123").build();
		return restTemplate;
	}
	private static HttpHeaders createJSONHeader() {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return headers;
	}
	private static void requestGet(RestTemplate restTemplate) {

		Student student = restTemplate.getForObject("/{id}", Student.class, 6);
		ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 6);
		
		System.out.println(student);
		System.out.println(forEntity);
		//Sem o pageable
//		Student[] studentArray = restTemplate.getForObject("/", Student[].class);
//		
//		System.out.println(studentArray.getClass().getSimpleName()+":\nArray: "+Arrays.toString(studentArray));
//		//exchange
//		
//		ResponseEntity<List<Student>> studentList = restTemplate.exchange("/", HttpMethod.GET, null, 
//				new ParameterizedTypeReference<List<Student>>() {});
//		
//		System.out.println(studentList.getClass().getSimpleName()+":\nLista: "+studentList.getBody());
		//Com o pageable
		
		ResponseEntity<PageableResponse<Student>> studentListPageable = restTemplate.exchange("/?sort=email,desc", HttpMethod.GET, null, 
				new ParameterizedTypeReference<PageableResponse<Student>>() {});
		System.out.println(studentListPageable);
	}
	private static void requestPost(RestTemplate restTemplate) {
		Student student = new Student();
		student.setName("John Wick");
		student.setEmail("johnwick@gmail.tapa.com");
		ResponseEntity<Student> studentPost = restTemplate.exchange("/", HttpMethod.POST, new HttpEntity<>(student, createJSONHeader()), 
				Student.class);
		System.out.println("Exchange "+studentPost);
		Student postForObject = restTemplate.postForObject("/", student, Student.class);

		System.out.println("Post "+postForObject);
		
		ResponseEntity<Student> postForEntity = restTemplate.postForEntity("/", student, Student.class);

		System.out.println("Entity "+postForEntity);
		
	}
	public static void main(String[] args) {
		String uri = "http://localhost:8080/v1/user/students";
		RestTemplate restTemplate = getRestTemplateByRootURI(uri);
//		requestGet(restTemplate);
		String uriAdm =  "http://localhost:8080/v1/admin/students";
		requestPost(getRestTemplateByRootURI(uriAdm));
	}
}
