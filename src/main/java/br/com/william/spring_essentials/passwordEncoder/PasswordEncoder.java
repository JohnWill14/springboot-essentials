package br.com.william.spring_essentials.passwordEncoder;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	private static String encoder(String str) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.encode(str);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String codigoDeSeguranca = encoder(sc.next());
			System.out.println(codigoDeSeguranca);
		}
		sc.close();
	}

}
