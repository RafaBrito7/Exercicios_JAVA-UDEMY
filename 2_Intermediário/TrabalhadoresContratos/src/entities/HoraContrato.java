package entities;

import java.util.Date;

public class HoraContrato {
	private Date date;
	private Double valorPorHora;
	private Double horas;
	
	public HoraContrato() {
		
	}

	public HoraContrato(Date date, Double valorPorHora, Double horas) {
		super();
		this.date = date;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}
	
	public Double valorTotal() {
		return this.valorPorHora * this.horas;
	}
	
	
}
