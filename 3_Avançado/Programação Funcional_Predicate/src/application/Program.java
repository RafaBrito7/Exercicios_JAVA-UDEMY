package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import entities.ProductPredicate;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();

		list.add(new Product("Teclado", 90.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 45.00));
		list.add(new Product("Mouse", 450.00));
		
		list.removeIf(new ProductPredicate());
		
		list.forEach(System.out::println);
		
	}

}
