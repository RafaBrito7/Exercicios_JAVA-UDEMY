package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.Contract;
import model.services.Installments;
import model.services.PayPalTaxService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data");
		System.out.print("Number:");
		int contractNumber = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy):");
		Date contractDate = sdf.parse(sc.next());
		System.out.print("Contract value:");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, contractDate, contractValue);
		
		System.out.print("Enter number of installments: ");
		int installmentsNumber = sc.nextInt();
		
		List<Installments> installments = new ArrayList<>();
		
		for (int i = 1; i <= installmentsNumber; i++) {
			Installments temp = new Installments(contract.generateParcelsDate(i), contractValue/installmentsNumber, new PayPalTaxService());
			temp.setAmount(temp.getTax().simpleInterest(temp.getAmount(),i) );
			temp.setAmount(temp.getAmount() + (temp.getTax().paymentTax(temp.getAmount())));
			installments.add(temp);
		}
		
		System.out.println("Installments:");
		
		for (Installments inst: installments) {
			System.out.println(inst.toString());
		}
		
		sc.close();
	}

}
