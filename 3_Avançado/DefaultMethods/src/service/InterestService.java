package service;

import java.security.InvalidParameterException;

public interface InterestService {
	
	double getInterestRate();
	
	default double payment(double amount, int mounth)  {
		if (mounth < 1) {
			throw new InvalidParameterException("Number Invalid!");
		}
		if (amount <= 0) {
			throw new InvalidParameterException("Number Invalid!");
		}
		return amount * Math.pow(1 + getInterestRate()/100, mounth);
	}

}
