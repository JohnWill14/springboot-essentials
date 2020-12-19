package br.com.william.spring_essentials.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component//Adiciona na lista de objetos instanciaveis do spring
//@Repository
//@Service
public class DateUtil {
	public String formatLocalDateTimeToDataBaseStyle(LocalDateTime ldt) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt);
	}
}
