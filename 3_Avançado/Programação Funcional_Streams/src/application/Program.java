package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
		
		System.out.println("--------------------PIPELINE--------------------------");
		//Pipeline = operações em streams retornam novas streams. Então é possível
		//			 criar uma cadeia de operações (fluxo de processamento)
		
		Stream<Integer> str3 = list.stream().map(x -> x * 2);
		System.out.println(Arrays.toString(str3.toArray()));
		
		int sum = list.stream().reduce(0, (x,y) -> x + y);
		System.out.println("Sum = " + sum);
		
		List<Integer> list2 = list.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * 10)
				.collect(Collectors.toList());
		
		System.out.println(Arrays.toString(list2.toArray()));
		
	}
	

}
