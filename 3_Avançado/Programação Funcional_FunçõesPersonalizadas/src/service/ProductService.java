package service;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {
	
	public double sumPrices(List<Product> list, Predicate<Product> p2) {
		double sum = 0;
		
		for (Product p : list) {
			if (p2.test(p)) {
				sum += p.getPrice();
			}
		}
		return sum;
	}

}
