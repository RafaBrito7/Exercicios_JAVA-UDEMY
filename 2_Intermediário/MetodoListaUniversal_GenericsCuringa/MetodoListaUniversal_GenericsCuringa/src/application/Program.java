package application;

import java.util.Arrays;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		List<Integer> listaUnid = Arrays.asList(5,8,9,10,15,5);
		printList(listaUnid);
		
		List<String> nomesGalera = Arrays.asList("Maria", "João", "Felipe");
		printList(nomesGalera);
	}
	
	public static void printList(List<?> list) {
		for (Object object : list) {
			System.out.print(" " + object + ",");
		}
		// list.add(3); Não é aceito nenhum método de adição, pois o método é genérico
	}

}
