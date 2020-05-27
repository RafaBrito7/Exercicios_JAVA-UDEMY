package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> listEm = new ArrayList<>();
		
		System.out.println("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				
				listEm.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.println("Enter salary base: ");
		double baseSalary = sc.nextDouble();
		
		List<String> emailEmployee = listEm.stream()
									 .filter(x -> x.getSalary() >= baseSalary)
									 .map(x -> x.getEmail())
									 .sorted()
									 .collect(Collectors.toList());
		
		System.out.println("Email of people whose salary is more than the 'Base Salary': ");
		emailEmployee.forEach(System.out::println);
		
		double totalSum = listEm.stream() 
						.filter(x -> x.getName().charAt(0) == 'M')
						.map(x -> x.getSalary())
						.reduce(0.0, (x,y) -> x + y);
		
		System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("R$ %.2f", totalSum));
		
		sc.close();
		
		//D:\Documentos\_DesenvolvedorArquivos\_Exercicios Java - Udemy\Repositorio\3_Avançado\Programação Funcional_Exercicio-FuncionariosSalariosEmails\Funcionarios.txt

	}

}
