package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		Set<Integer> setC = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How Many students for course A?");
		int temp = sc.nextInt();
		for (int i = 0; i < temp; i++) {
			System.out.print("ID Student " + (i + 1) + ": ");
			setA.add(sc.nextInt());
		}
		System.out.println();
		
		System.out.print("How Many students for course B?");
		temp = sc.nextInt();
		for (int i = 0; i < temp; i++) {
			System.out.print("ID Student " + (i + 1) + ": ");
			setB.add(sc.nextInt());
		}
		System.out.println();
		
		System.out.print("How Many students for course C?");
		temp = sc.nextInt();
		for (int i = 0; i < temp; i++) {
			System.out.print("ID Student " + (i + 1) + ": ");
			setC.add(sc.nextInt());
		}
		System.out.println();
		
		Set<Integer> total = new HashSet<>(setA);
		total.addAll(setB);
		total.addAll(setC);
		
		System.out.print("Total Students: " + total.size());
		
		sc.close();
		
	}
}
