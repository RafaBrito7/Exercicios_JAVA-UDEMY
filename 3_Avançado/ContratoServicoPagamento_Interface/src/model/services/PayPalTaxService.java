package model.services;

public class PayPalTaxService implements TaxService {

	@Override
	public double simpleInterest(double amount, int installmentsNumber) {
		return amount + (amount * 0.01 * installmentsNumber);
	}

	@Override
	public double paymentTax(double amount) {
		return amount * 0.02;
		 
	}

}
