package com.db;
//sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



//data
import com.data.*;



public class Db {
	private String name;//数据库用户名
	private String url;//数据库的连接地址及其协议
	private String password;//数据库的连接密码
	private Connection con;//获得数据库的句柄
	private Statement state;
	private ResultSet rs;
	private String sql;//sql语句 setSql(String sql);
//	private String table;//数据库的表
	static private List<User> listUser=new ArrayList<User>();
	private List<Fly> listFly=new ArrayList<Fly>();
	
	public Db(){
		name="root";
		url="jdbc:mysql://127.0.0.1:3306/db_flight?characterEncoding=gbk";//解决连接数据库乱码的问题eclispe 
		//编码默认是gbk window--general--workplace--设置编码
		password="";
		init();//执行数据库连接注册驱动
	}
	public Db(String name,String url,String password){//初始化数据库连接的变量
		this.name=name;
		this.url=url;
		this.password=password;
		init(); //同上
	}
	//设置sql语句
	public void setSql(String sql){
		this.sql=sql;
	}
	public void init(){
		try{
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接驱动
			con=DriverManager.getConnection(url,name,password);
			state=con.createStatement();
		}catch(Exception e){
			
		}	
	}
	//数据库查询语句
	public List<User> queryUserSql(){
		setSql("select * from user");
		List<User> listUser=new ArrayList();
		try{
		rs=state.executeQuery(sql);
		int i=0;
		while(rs.next()){
			User user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			listUser.add(user);
		}
		}catch(Exception e){
			if(rs==null){
				System.exit(0);
			}
		}
		return listUser;
	}
	public void insertSqlUser(String id,String name,String password,String sex){
		setSql("insert into User(userId,userName,userPassword,userSex) values('"+id+"','"+name+"','"+password+"','"+sex+"')");
		try {
			boolean b;
			b=state.execute(sql);//执行成功返回false
			if(b==false){
				System.out.println("我不能插入了");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	public List<Fly> queryFlySql(){//获得Fly中的数据
		setSql("select * from Fly");
		List<Fly> l=new ArrayList<Fly>();
		try{
			rs=state.executeQuery(sql);
			while(rs.next()){
				String time5=rs.getDate(5)+" "+rs.getTime(5);
				String time6=rs.getDate(6)+" "+rs.getTime(6);
				Fly f =new Fly(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),SqlDay.time(time5),SqlDay.time(time6),rs.getInt(7),rs.getDouble(8));
				l.add(f);
			}
		}catch(Exception e){}
		return l;
	}
	public void close(){
		if(state!=null || con!=null){
			try{
			state.close();
			con.close();
			}catch(Exception e){
				
			}
		}
	}
	public List<PersonalBook> querySqlBook(String Id){//个人账户的查询用到的
		setSql("select fly.flightName,fly.flightOriginal,fly.flightArrive,fly.flightTimeOn,book.seatId,fly.flightPrice from book,fly where book.userId='"+Id+"' and book.flightId=fly.flightId");
		List<PersonalBook> l = new ArrayList<PersonalBook>();
		try {
			rs=state.executeQuery(sql);
		while(rs.next()){
			String tmp=rs.getDate(4)+" "+rs.getTime(4);
			l.add(new PersonalBook(rs.getString(1),rs.getString(2),rs.getString(3),SqlDay.time(tmp),rs.getInt(5),rs.getDouble(6) ) );
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	public void insertBuy(String userId,String flightId,String dt,int seatId ){//购买用到的
		setSql( "insert into book values('"+userId+"','"+flightId+"',str_to_date( '"+dt+"','%Y-%m-%d %H:%i:%s' ),"+seatId+")" );
		System.out.println(sql);
		try {
			state.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public int getSeatNum(String flightId,String date){
		setSql(" select seatId from book where flightId='"+flightId+"' and str_to_date( '"+date+"','%Y-%m-%d %T')");
		System.out.println(sql);
		boolean[] seatNum=new boolean[180];//false
		try {
			rs=state.executeQuery(sql);
			while(rs.next()){
				int i=rs.getInt(1);//结果只有一个 所以就用一来代替来咯
				System.out.println("rs i"+i);
				for(int j=1;j<=180;j++){
					if(i==j) seatNum[i-1]=true;//说明有人买了这个位子
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k=0;
		while(seatNum[k++]){
			
			if(k==180) return 0;
		}
		System.out.println("seatId "+k);
		return k;//若k 等于 0 则表明飞机人已经坐满人 不能在往里面去了
	}

}
