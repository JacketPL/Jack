package com.data;

import java.util.Date;

/**
 * @author ������ү
 *
 */
public class Book {
	private String userId;
	private String flightId;
	private Date beginTime;
	private int seat;
	public Book(){
		
	}//���������Ĺ��췽��
	public Book(String userId, String flightId, Date beginTime, int seat) {
		super();
		this.userId = userId;
		this.flightId = flightId;
		this.beginTime = SqlDay.time("2018-4-29 12:00:00");//��ǰϵͳ��ʱ��
		this.seat = seat;
	}//�������Ĺ��췽��

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}

	
}
