package com.mainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.data.SqlDay;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.*;
import com.db.Db;
import com.login.login;

public class Buy extends JFrame {

	private boolean flag=false; //按钮 为真才能买票
	private JTable tab;
	private DefaultTableModel model;
	private JPanel contentPane;
	JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Create the frame.
	 */
	public Buy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); //设置标题的风格
		this.setAlwaysOnTop(true);

		setBounds(100, 100, 584, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 101, 521, 202);
		contentPane.add(scrollPane);

	
		
		JLabel label = new JLabel("\u51FA\u53D1\u5730");
		label.setBounds(15, 50, 66, 21);
		contentPane.add(label);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=true;
				Object[] name=new Object[]{"id号","飞机名字 ","起飞地点"," 到达地点 "," 起飞时间  ","降落时间","座位数","机票价格"};
				model=new DefaultTableModel(name,0);
				tab=new JTable(model);
				tab.getColumnModel().getColumn(0).setPreferredWidth(80);
				tab.getColumnModel().getColumn(1).setPreferredWidth(130);
				tab.getColumnModel().getColumn(2).setPreferredWidth(130);
				tab.getColumnModel().getColumn(3).setPreferredWidth(130);
				tab.getColumnModel().getColumn(4).setPreferredWidth(300);
				tab.getColumnModel().getColumn(5).setPreferredWidth(300);
				tab.getColumnModel().getColumn(6).setPreferredWidth(100);
				tab.getColumnModel().getColumn(7).setPreferredWidth(110);
				Db db=new Db();
				List<Fly> list=new ArrayList<Fly>();
				list=db.queryFlySql();
				for(Fly fly :list){
					String tmp1=String.valueOf(SqlDay.time(fly.getFlightTimeOn()));
					String tmp2=String.valueOf(SqlDay.time(fly.getFlightTimeOff()));
					if(textField.getText().equals(fly.getFlightOrignal())&&textField_1.getText().equals(fly.getFlightArrive( ) ) ){
					
						Object[] name1=new Object[]{fly.getFlightId(),fly.getFlightName(),fly.getFlightOrignal(),fly.getFlightArrive(),tmp1,tmp2,fly.getFlightSeat(),fly.getFlightPrice()};
						
						model.addRow(name1);
					}
				
					System.out.println(fly.getFlightOrignal());
				}
				db.close();

	    	//	tab.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				scrollPane =new JScrollPane(tab);
				
				
				scrollPane.setBounds(10, 101, 530, 202);		
				contentPane.add(scrollPane);
			}
		});
		button.setBounds(448, 46, 81, 29);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u76EE\u7684\u5730");
		label_1.setBounds(223, 50, 66, 21);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(77, 47, 135, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 47, 119, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("id\u53F7");
		lblId.setBounds(55, 401, 49, 21);
		contentPane.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 398, 184, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("\u8D2D\u4E70");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==false) {
					javax.swing.JOptionPane.showMessageDialog(Buy.this, "请先查询 再买票");
					
					return ;//如果 flag 为假的 那么不能买票
				}
				if(textField_2.getText().equals("")){
					javax.swing.JOptionPane.showMessageDialog(Buy.this, "请输入Id号");
					return ;
				}
				Object n=new Object();
				
				for(int i=0;i<tab.getRowCount();i++){
					if(textField_2.getText().equals(tab.getValueAt(i, 0))){
						 n=tab.getValueAt(i, 4);
						break;
					}
				}//找到tab中相应的时间的值
				int seatNum;
				
				Db db=new Db();
				seatNum=db.getSeatNum(textField_2.getText(),String.valueOf(n));//获得一个座位号 unique 
				System.out.println(seatNum);
				db.insertBuy(login.userId, textField_2.getText(),String.valueOf(n), seatNum);
				System.out.println("buy");
			}
		});
		button_1.setBounds(318, 397, 81, 29);
		contentPane.add(button_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buy.this.setVisible(false);
				Buy.this.dispose();
				new Ui().setVisible(true);
			}
		});
		btnNewButton.setBounds(416, 397, 81, 29);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel(SqlDay.time());
	
		lblNewLabel.setBounds(198, 454, 228, 48);
		contentPane.add(lblNewLabel);
		setLocation(800,200);
	}

	 
	 
	 
}
