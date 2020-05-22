package application;

import java.util.Arrays;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		List<Integer> listaUnid = Arrays.asList(5,8,9,10,15,5);
		printList(listaUnid);
		
		List<String> nomesGalera = Arrays.asList("Maria", "Jo�o", "Felipe");
		printList(nomesGalera);
	}
	
	public static void printList(List<?> list) {
		for (Object object : list) {
			System.out.print(" " + object + ",");
		}
		// list.add(3); N�o � aceito nenhum m�todo de adi��o, pois o m�todo � gen�rico
	}

}
