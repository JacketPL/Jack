package com.mainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.Fly;
import com.data.SqlDay;
import com.data.User;
import com.db.*;//数据库部分
import com.login.*;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;//登录Ui部分

public class Ui extends JFrame {

	private JPanel contentPane;
	//private static login log;
	JScrollPane scrollPane;
	private static  Db db=new Db();
	
	/**
	 * Create the frame.
	 */
	private JTable tab;
	private DefaultTableModel model;
	JLabel lblNewLabel;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	
	public Ui() {

	
		setTitle("\u673A\u7968\u8BA2\u8D2D\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 603);
		setLocation(600,200);
		setResizable(false);
		this.setAutoRequestFocus(false);
		this.setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("\u673A\u7968\u67E5\u8BE2\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
     			scrollPane = new JScrollPane();
				scrollPane.setBounds(293, 36, 556, 471);
				contentPane.add(scrollPane);

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
				for(Fly fly: list){
					//获得飞机的时间和日期
								
					Object[] name1=new Object[]{fly.getFlightId(),fly.getFlightName(),fly.getFlightOrignal(),fly.getFlightArrive(),SqlDay.time(fly.getFlightTimeOn()),SqlDay.time(fly.getFlightTimeOff()),fly.getFlightSeat(),fly.getFlightPrice()};
			
					model.addRow(name1);
				}
				db.close();
				
				tab.setBounds(0, 0, 200, 200);
				tab.getColumnModel().getColumn(5).setResizable(true);
				scrollPane =new JScrollPane(tab);
				
				scrollPane.setBounds(287, 37, 563, 471);
			
				//scrollPane.setColumnHeaderView(tab);
				
				contentPane.add(scrollPane);
			}
		});
		btnNewButton.setBounds(91, 105, 123, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u8D2D\u7968");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ui.this.setVisible(false);
				Ui.this.dispose();
				new Buy().setVisible(true);;
				
				
			}
		});
		btnNewButton_1.setBounds(91, 203, 123, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\u4E2A\u4EBA\u8D26\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {//需要有一个UserId的变量好用于个人账单的查询
				Ui.this.setVisible(false);
				Ui.this.dispose();
				new BookUi().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(91, 413, 123, 29);
		contentPane.add(btnNewButton_2);
			
		JButton button = new JButton("\u9000\u7968");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(91, 303, 123, 29);
		contentPane.add(button);
		
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(307, 90, 530, 403);
		contentPane.add(lblNewLabel);
		//其实在这里还可以做一个Thread 来不停的更换图片的背景 
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u6E58\u897F\u7EA2\u7237\\Desktop\\\u6570\u636E\u5E931.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
