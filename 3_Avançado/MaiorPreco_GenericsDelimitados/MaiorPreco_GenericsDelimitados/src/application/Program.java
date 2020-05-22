package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import service.CalculationService;

public class Program {

	public static void main(String[] args) {
		List<Product> lista = new ArrayList<>();
		Locale.setDefault(Locale.US);
		
		String path = "D:\\Documentos\\_DesenvolvedorArquivos\\_Exercicios Java - Udemy\\Repositorio\\3_Avançado\\MaiorPreco_GenericsDelimitados\\Preços.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String fields[] = line.split(",");
				lista.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			Product x = CalculationService.max(lista);
			System.out.println("Max: ");
			System.out.println(x);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
