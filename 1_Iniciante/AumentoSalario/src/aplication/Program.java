package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many employees will be registered?");
		int n = sc.nextInt();
		
		List<Funcionario> list = new ArrayList<>();
		
		int cont = 0;
		
		do {
			System.out.println("Employees #" + n);
			System.out.println("ID: ");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Name: ");
			String nome = sc.nextLine();
			
			System.out.println("Salary: ");
			double salario = sc.nextDouble();
			
			list.add(new Funcionario(id,nome,salario));
			cont++;
			
		} while (cont < n);
		
		System.out.println("Você possui " + list.size() + " funcionários cadastrados.");
		System.out.println("---------------------------");
		System.out.println("Enter the employee ID that will have salary increase: ");
		int idConsulta = sc.nextInt();
		
		Funcionario func = list.stream().filter(x -> x.getId() == idConsulta).findFirst().orElse(null);
		if (func == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			func.aumentarSalario(sc.nextDouble());
		}
		
		System.out.println("Employee List: ");
		for (Funcionario i : list) {
			System.out.println(i);
		}
		sc.close();
	}

}
