package model.services;

public interface TaxService {
	
	public double simpleInterest(double amount, int installmentsNumber);
	public double paymentTax(double amount);

}
