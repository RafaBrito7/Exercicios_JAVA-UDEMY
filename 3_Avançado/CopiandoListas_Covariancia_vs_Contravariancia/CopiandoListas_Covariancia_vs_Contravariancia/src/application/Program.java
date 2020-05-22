package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<Integer> listInt = Arrays.asList(10,15,20,25,30);
		List<Double> listDb = Arrays.asList(2.25,3.32,5.5);
		List<Object> listObj = new ArrayList<>();
		
		copy(listInt, listObj);
		print(listObj);
		System.out.println();
		System.out.println("---------------");
		copy(listDb, listObj);
		print(listObj);
	}
	
	public static void copy(List<? extends Number> copiada, List<? super Number> destiny) {
		for (Number ob : copiada) {
			destiny.add(ob);
		}
	}

	public static void print(List<?> list) {
		for (Object object : list) {
			System.out.print(object + "  ");
		}
	}
}
