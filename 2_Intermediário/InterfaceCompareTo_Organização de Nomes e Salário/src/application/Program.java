package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;

/*
 * Para Mudar o crit�rio de compara��o, para o sal�rio, � s� trocar a vari�vel do m�todo
 * compareTo da classe Employee, estabelecendo o sal�rio como vari�vel comparada.
 * Caso queira fazer em ordem descrescente (Maior sal�rio -> Menor sal�rio) � s� colocar
 * um sinal de - na frente da seten�a do retorno do met�do compareTo
 */

public class Program {
	
	public static void main(String[] args) {
		
		List<Employee> listEmployee = new ArrayList<>();
		String path = "D:\\\\Documentos\\\\_DesenvolvedorArquivos\\\\_Exercicios Java - Udemy\\\\listNames.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String employee = br.readLine();
			
			while (employee != null) {
				String[] fields = employee.split(",");
				listEmployee.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employee = br.readLine();
			}
			
			Collections.sort(listEmployee);
			for (Employee e : listEmployee) {
				System.out.println(e.getName() + "," + e.getSalary());
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
