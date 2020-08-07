package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	// Attributes
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Builders
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Accessor Methods
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// Methods
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		//falta regra
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() { 
		StringBuilder sb = new StringBuilder();
		sb.append("Room " + roomNumber);
		sb.append(", check-in: " + sdf.format(checkIn));
		sb.append(", check-out: " + sdf.format(checkOut));
		sb.append(", " + duration() + " nigths");
		return sb.toString();
	}

}
