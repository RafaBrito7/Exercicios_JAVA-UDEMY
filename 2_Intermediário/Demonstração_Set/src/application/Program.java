package application;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {

		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10)); 
		Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));
		
		/*
		 * HashSet = Mais rápido e não ordenado
		 * linkedHashSet = Velocidade intermediária e os elementos continuam na ordem que foram adicionados
		 * TreeSet = Mais lento e ordenado pelo CompareTo automaticamente (Obs: Para Classes Personalizadas Implementar o CompareTo)
		 */
		
		//union = Une os elementos de ambos conjuntos sem repetição
		Set<Integer> c = new TreeSet<>(a); // Instanciando um set c com uma cópia do Set a
		c.addAll(b);
		System.out.println(c);
		
		//intersection = Os elementos em comum entre ambos os conjuntos
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		//difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);
	}

}
