package application;

import java.util.Scanner;

import service.BrazilInterestService;
import service.InterestService;
import service.UsaInterestService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Mounths: ");
		int mounth = sc.nextInt();
		
		InterestService is = new BrazilInterestService(2.0);
		InterestService us = new UsaInterestService(1.0);
		
		double payment = is.payment(amount, mounth);
		
		System.out.println("Payment after " + mounth + " months: ");
		System.out.println(String.format("Brazil Interest: %.2f", payment));
		
		payment = us.payment(amount, mounth);
		System.out.println(String.format("USA Interest: %.2f", payment));
		
		sc.close();
		
	}

}
