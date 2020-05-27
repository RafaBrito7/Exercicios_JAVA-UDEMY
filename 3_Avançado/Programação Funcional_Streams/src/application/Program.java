package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3,4,5,10,7);
		Stream<Integer> streamInt = list.stream();
		System.out.println(Arrays.toString(streamInt.toArray()));
		
		Stream<String> nomes = Stream.of("João, Maria, Lucas");
		System.out.println(Arrays.toString(nomes.toArray()));
		
		Stream<Integer> str1 = Stream.iterate(2, x -> x * 2);
		System.out.println(Arrays.toString(str1.limit(10).toArray()));
		
		// Fibonnaci = Somar o Antecessor com o Atual para resultar no posterior
		
		Stream<Long> str2 = 
				Stream.iterate(new Long[] {0L, 1L}, x -> new Long[] {x[1], x[0] + x[1]}).map(x -> x[0]);
		System.out.println(Arrays.toString(str2.limit(10).toArray()));
	}

}
