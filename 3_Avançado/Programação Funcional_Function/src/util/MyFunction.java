package util;

import java.util.function.Function;

import entities.Product;

// O Function terá como Argumento de entrada (T) o objeto q eu quero manipular e terá como Saída (R) o que eu quero transformar
// No Exemplo abaixo eu Quero Manipular um Objeto Product e transformar as Strings dele em Caixa Alta

public class MyFunction implements Function<Product, String>{

	@Override
	public String apply(Product t) {
		return t.getName().toUpperCase();
	}

}
