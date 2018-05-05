package com.data;

import java.util.Date;

/**
 * @author 湘西红爷
 *
 */
public class Book {
	private String userId;
	private String flightId;
	private Date beginTime;
	private int seat;
	public Book(){
		
	}//不带参数的构造方法
	public Book(String userId, String flightId, Date beginTime, int seat) {
		super();
		this.userId = userId;
		this.flightId = flightId;
		this.beginTime = SqlDay.time("2018-4-29 12:00:00");//当前系统的时间
		this.seat = seat;
	}//带参数的构造方法

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
