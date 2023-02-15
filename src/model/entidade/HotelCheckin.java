package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class HotelCheckin {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public HotelCheckin() {
	}

	public HotelCheckin(Integer numeroDoQuarto, Date checkin, Date checkout) throws DomainException {
		if(!checkout.after(checkin)) {
			throw new DomainException("erro: check-out antes do ckeck-in");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) throws DomainException {
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			throw new DomainException("erro: para atualizar data, deve atualizar para datas futuras!");
		} if(!checkOut.after(checkIn)) {
			throw new DomainException("erro: check-out antes do ckeck-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reserva: quarto "
				+ numeroDoQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", duração: "
				+ duracao()
				+ " noites.";
	}
}
