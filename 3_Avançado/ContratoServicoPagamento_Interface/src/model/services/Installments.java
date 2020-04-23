package model.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date data;
	private double amount;
	private TaxService tax;
	
	public Installments(Date data, double amount, TaxService tax) {
		this.data = data;
		this.amount = amount;
		this.tax = tax;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TaxService getTax() {
		return tax;
	}

	public void setTax(TaxService tax) {
		this.tax = tax;
	}
	
	public String toString() {
		return sdf.format(data) + " - " + String.format("$ %.2f", amount);
	}
	
}
