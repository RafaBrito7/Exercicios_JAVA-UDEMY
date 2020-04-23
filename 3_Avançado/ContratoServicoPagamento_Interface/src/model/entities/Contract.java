package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.services.Installments;

public class Contract {
	
	private int contractNumber;
	private Date contractDate;
	private double contractValue;
	
	private Installments installment;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Contract() {}
	
	public Contract(int contractNumber, Date contractDate, double contractValue) {
		this.contractNumber = contractNumber;
		this.contractDate = contractDate;
		this.contractValue = contractValue;
	}

	public int getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public double getContractValue() {
		return contractValue;
	}

	public void setContractValue(double contractValue) {
		this.contractValue = contractValue;
	}

	public Installments getInstallment() {
		return installment;
	}

	public void setInstallment(Installments installment) {
		this.installment = installment;
	}
	
	public Date generateParcelsDate (int cont) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(contractDate);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + cont);
		
		return c.getTime();
	}
	

}
