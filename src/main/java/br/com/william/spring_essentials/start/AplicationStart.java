package br.com.william.spring_essentials.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;

@EnableAutoConfiguration // Auto configuração do projeto com base nas suas dependencias
@ComponentScan(basePackages = "br.com.william.spring_essentials.endpoint")
public class AplicationStart {
	public static void main(String[] args) {
		SpringApplication.run(AplicationStart.class, args);
	}
}
