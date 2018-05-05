package com.data;

import java.util.Date;
//用来个人账单的数据的接收的

//fly.flightName,fly.flightOriginal,fly.flightArrive,fly.flightTimeOn,book.seatId,fly.flightPrice from book,fly where book.userId='"+Id+"' and book.flightId=fly.flightId
public class PersonalBook {
	private String flightName;
	private String flightOriginal; 
	private String flightArrive;
	private Date flightTimeOn;
	private int seatId;
	private double flightPrice;
	public PersonalBook(){
		
	}
	
	public PersonalBook(String flightName,String flightOriginal, String flightArrive, Date flightTimeOn,
			int seatId, double flightPrice) {
		super();
		this.flightName = flightName;
		this.flightPrice = flightPrice;
		this.flightOriginal = flightOriginal;
		this.flightArrive = flightArrive;
		this.flightTimeOn = flightTimeOn;
		this.seatId = seatId;
	}

	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public double getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}
	public String getFlightOriginal() {
		return flightOriginal;
	}
	public void setFlightOriginal(String flightOriginal) {
		this.flightOriginal = flightOriginal;
	}
	public String getFlightArrive() {
		return flightArrive;
	}
	public void setFlightArrive(String flightArrive) {
		this.flightArrive = flightArrive;
	}
	public Date getFlightTimeOn() {
		return flightTimeOn;
	}
	public void setFlightTimeOn(Date flightTimeOn) {
		this.flightTimeOn = flightTimeOn;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	
	
}
