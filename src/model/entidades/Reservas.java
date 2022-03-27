package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservas {
	
	private Integer numeroQuartos;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	public Reservas(Integer numeroQuartos, Date checkIn, Date checkOut) throws DomainException {
	if (!checkOut.after(checkIn)) {
		throw new DomainException("check-out date must be after check-in date");
	}
		this.numeroQuartos = numeroQuartos;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumeroQuartos() {
		return numeroQuartos;
	}
	public void setNumeroQuartos(Integer numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now)|| checkOut.before(now)) {
			throw new DomainException("reservation dates for update must be future dates");
		}if (!checkOut.after(checkIn)) {
			throw new DomainException("check-out date must be after check-in date");
		}
		this.checkIn=checkIn;
		this.checkOut=checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+numeroQuartos
				+", check-in: "
				+ sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+" noites";
	}
	
	
	
	

}
