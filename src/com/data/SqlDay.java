package com.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//���ݿ��е�ʱ�� static String time()
//�Ѵӵ�ǰϵͳ���ʱ��date��ת��Ϊstring��
public class SqlDay {
	
	
	public static String time(){
	Date dt =new Date();
	String formatdate=null;
	DateFormat day=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	formatdate=day.format(dt);
	return formatdate;
	}
	//����һ�����������������ݿ��е�ʱ��
    public static String time(Date dt){
    	String formatdate=null;
    	DateFormat day=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    	//�պ÷������ݿ��е�ʱ��
    	formatdate=day.format(dt);
    	return formatdate;	
    }

    //���ַ��������ݸı��ʱ��
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
