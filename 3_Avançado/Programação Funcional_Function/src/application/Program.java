package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Teclado", 90.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 45.00));
		list.add(new Product("Mouse", 450.00));
		
		/*
		 * Obs: A função map é Diferente do Collection Map
		 * a função map serve para aplicar uma determinada função em todos os elementos de uma STREAM
		 * Obs: Não funciona com list
		 * Obs: Necessário converter de stream para map ( Collect(Collectors.toList()))
		 */
		
		List<String> names = 
				list.stream()
				.map(Product::staticUpperCaseNames)
				.collect(Collectors.toList());
		
		names.forEach(System.out::println);

	}

}
