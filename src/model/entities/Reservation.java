package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
	private Integer roonNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation () {		
	}

	public Reservation(Integer roonNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw  new DomainException ("Check-out date must be after check-in date.");
		}
		this.roonNumber = roonNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoonNumber() {
		return roonNumber;
	}

	public void setRoonNumber(Integer roonNumber) {
		this.roonNumber = roonNumber;
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
	
	public void updateDates (Date checkIn, Date checkOut) throws DomainException {
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException ("Reservation dates for updates must be future.") ;
		}
		if(!checkOut.after(checkIn)) {
			throw  new DomainException ("Check-out date must be after check-in date.") ;
		}
		
		
	}
	@Override
	public String toString () {
		
		return "Room " + roonNumber + ", check-in: " + format.format(checkIn) + ", check-out: " + format.format(checkOut) + ", " + duration() + " nights";
	}
	
	
	
}
