package model.entities;

import model.exception.DomainException;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public double depositar(double valor) {
		return this.saldo + valor;
	}
	
	public double sacar(double valor) throws DomainException {
		if (saldo < valor) {
			throw new DomainException("Saldo insuficiente!");
		}
		if (valor > this.limiteSaque) {
			throw new DomainException("Valor acima do Limite para Saque!");
		}
		return this.saldo - valor;
	}
	
	

}
