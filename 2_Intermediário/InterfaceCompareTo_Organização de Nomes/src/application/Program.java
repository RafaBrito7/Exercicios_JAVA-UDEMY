package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		List <String> listPersons = new ArrayList<>();
		String path = "D:\\Documentos\\_DesenvolvedorArquivos\\_Exercicios Java - Udemy\\listNames.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String name = br.readLine();
			
			while (name != null) {
				listPersons.add(name);
				name = br.readLine();
			}
			Collections.sort(listPersons);
			for (String s : listPersons) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("Alex".compareTo("César"));
		
	}

}
