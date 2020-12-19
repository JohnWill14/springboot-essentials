package br.com.william.spring_essentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication//Autoconfiguravel - componentScan
//@EnableAutoConfiguration // Auto configuração do projeto com base nas suas dependencias
//@ComponentScan
//Configuration - Encontrar classes que vão ser reconhecidas como configuradoras do projeto
public class AplicationStart {
	public static void main(String[] args) {
		SpringApplication.run(AplicationStart.class, args);
	}
}
