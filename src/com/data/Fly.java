package com.data;

import java.util.Date;

public class Fly {
	private String flightId;//�ɻ���Id��
	private String flightName;//�ɻ�������
	private String flightOrignal;//�ɻ���ɵĵص�
	private String flightArrive;//�ɻ�����ĵص�
	private Date flightTimeOn;//�ɻ���ɵ�ʱ��
	private Date flightTimeOff;//�ɻ������ʱ��
	private int flightSeat;//��λ��
	private double flightPrice;//��Ʊ�۸�
	
	public Fly(){
		
	}
	
	//Date ���Ϳ���ͨ��SqlDay.time(String format)����ֵ "yyyy-mm-yy HH:mm:ss"
	public Fly(String flightId, String flightName, String flightOrignal,
			String flightArrive, Date flightTimeOn, Date flightTimeOff,
			int flightSeat, double flightPrice) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightOrignal = flightOrignal;
		this.flightArrive = flightArrive;
		this.flightTimeOn = flightTimeOn;
		this.flightTimeOff = flightTimeOff;
		this.flightSeat = flightSeat;
		this.flightPrice = flightPrice;
	}
	
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightOrignal() {
		return flightOrignal;
	}
	public void setFlightOrignal(String flightOrignal) {
		this.flightOrignal = flightOrignal;
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
	public Date getFlightTimeOff() {
		return flightTimeOff;
	}
	public void setFlightTimeOff(Date flightTimeOff) {
		this.flightTimeOff = flightTimeOff;
	}
	public int getFlightSeat() {
		return flightSeat;
	}
	public void setFlightSeat(int flightSeat) {
		this.flightSeat = flightSeat;
	}
	public double getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}


	
	
	
	
}
