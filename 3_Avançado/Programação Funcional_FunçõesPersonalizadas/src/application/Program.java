package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import service.ProductService;

public class Program {
	
	// Somar valores dos Produtos que Começam com T

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Teclado", 90.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 45.00));
		list.add(new Product("Mouse", 450.00));
		
		ProductService ps = new ProductService();
		
		double totalSum = ps.sumPrices(list, p -> p.getName().charAt(0)== 'T');
		System.out.println("PREÇO TOTAL COM LETRA T: " + String.format("R$ %.2f", totalSum));
		
		Double totalSum2 = ps.sumPrices(list, p -> p.getPrice() >= 100);
		System.out.println("PREÇO TOTAL MAIORES QUE R$100: " + String.format("R$ %.2f", totalSum2));
		
		Double totalSum3 = ps.sumPrices(list, p -> p.getPrice() <= 100);
		System.out.println("PREÇO TOTAL MENORES QUE R$100: " + String.format("R$ %.2f", totalSum3));
		
	}

}
