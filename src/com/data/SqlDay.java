package com.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//数据库中的时间 static String time()
//把从当前系统获得时间date型转换为string型
public class SqlDay {
	
	
	public static String time(){
	Date dt =new Date();
	String formatdate=null;
	DateFormat day=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	formatdate=day.format(dt);
	return formatdate;
	}
	//带有一个参数用来接收数据库中的时件
    public static String time(Date dt){
    	String formatdate=null;
    	DateFormat day=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    	//刚好符合数据库中的时间
    	formatdate=day.format(dt);
    	return formatdate;	
    }

    //将字符串的数据改变成时间
    public static Date time(String date){
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    	Date dt=new Date();
    	
    		try {
				dt=format.parse(date);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return dt;
    }
    public static void main(String[] args) {
		System.out.println(SqlDay.time());
	}

}
