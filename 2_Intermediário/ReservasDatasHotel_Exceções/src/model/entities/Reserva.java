package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reserva {

	private Integer numQuarto;
	private Date checkin;
	private Date checkout; 
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numQuarto, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("A data de Check-out precisa ser posterior a de Check-in");
		}
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {
		long diferenca = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void updateDatas(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();

		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("As datas para atualização necessitam ser datas futuras");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("A data de Check-out precisa ser posterior a de Check-in");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva: Quarto " + getNumQuarto());
		sb.append(", Check-in: " + sdf.format(checkin));
		sb.append(", Check-out: " + sdf.format(checkout));
		sb.append(", " + duracao() + " dias");
		
		return sb.toString();
	}
	
}
