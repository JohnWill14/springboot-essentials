package br.com.william.spring_essentials.javaclient;

import java.util.Scanner;

import br.com.william.spring_essentials.model.Student;

public class JavaSpringClienteTest2 {
	private static JavaClientDao  dao = new JavaClientDao();
	private static Scanner sc = new Scanner(System.in);
	
	private static void menu() {
		System.out.println("1- Mostrar tudo");
		System.out.println("2- Consultar ID");
		System.out.println("3- Create Student");
		System.out.println("4- Alterar");
		System.out.println("5- Deletar");
		System.out.println("0- sair");
		System.out.println("--------\n\n");
	}
	private static Student getStudent() {
		System.out.println("Nome:");
		String nome = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		
		Student student = new Student();
		student.setName(nome);
		student.setEmail(email);
		return student;
	}
	public static void main(String[] args) {
		int opcao;
		long id;
		do {
			menu();
			opcao = Integer.parseInt(sc.nextLine());
			switch (opcao) {
			case 1:
				for (Student s : dao.getAll("size=20")) {
					System.out.println(s);
				}
				break;
			case 2:
				id =Long.parseLong(sc.nextLine());
				System.out.println(dao.getById(id));
				break;
			case 3:
				
				System.out.println(dao.save(getStudent()));
				break;
			case 4:
					System.out.println("Digite o ID");
					 id =Long.parseLong(sc.nextLine());
					Student student = getStudent();
					student.setId(id);
					dao.update(student);
					System.out.println("OK");
					break;
			case 5:
				System.out.println("Digite o ID");
				 id =Long.parseLong(sc.nextLine());
				dao.delete(id);
				System.out.println("OK");
				break;
			default:
				break;
			}
		}while(opcao!=0);
	}
}
