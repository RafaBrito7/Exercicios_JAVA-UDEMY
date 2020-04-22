package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental data: ");
		System.out.print("Car model:");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm):");
		Date dateStart = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm):");
		Date dateFinish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(dateStart, dateFinish, new Vehicle(model));
		
		System.out.print("Enter price per hour:");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day:");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		rentalService.processInvoice(cr);
		
		sc.close();
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
	}

}
