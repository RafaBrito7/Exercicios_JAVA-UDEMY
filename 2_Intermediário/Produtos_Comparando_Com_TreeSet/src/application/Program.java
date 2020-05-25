package application;

import java.util.Set;
import java.util.TreeSet;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Set<Product> set = new TreeSet<>();
		
		set.add(new Product("Televisão", 900.50));
		set.add(new Product("Notebook", 500.90));
		set.add(new Product("Abaju", 50.50));
		set.add(new Product("Geladeira", 1550.50));
		
		for (Product p : set) {
			System.out.println(p);
		}
		
	}

}
