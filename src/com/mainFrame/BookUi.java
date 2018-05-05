package com.mainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.data.PersonalBook;
import com.data.SqlDay;
import com.db.Db;
import com.login.login;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookUi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;


	/**
	 * Create the frame.
	 */
	public BookUi() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 600);
		setLocation(600,200);
		this.setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 105, 821, 381);
		contentPane.add(scrollPane);
		Object[]name=new Object[]{"\u98DE\u673A\u540D", "\u51FA\u53D1\u5730\u70B9", "\u5230\u8FBE\u5730\u70B9", "\u51FA\u53D1\u65F6\u95F4", "\u5EA7\u4F4D\u53F7", "\u4EF7\u683C"};
		model=new DefaultTableModel(name,0);
		//添加数据的内容到model中去
		Db db=new Db();
		List<PersonalBook> list=new ArrayList<PersonalBook>();
		list=db.querySqlBook(login.userId);
		for(PersonalBook p :list){
			
			model.addRow(new Object[]{p.getFlightName(),p.getFlightOriginal(),p.getFlightArrive(),SqlDay.time(p.getFlightTimeOn()),p.getSeatId(),p.getFlightPrice()});
		}
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(194);
		table.getColumnModel().getColumn(4).setPreferredWidth(74);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel(login.userName);
		label.setBounds(361, 49, 81, 21);
		contentPane.add(label);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u9875");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUi.this.setVisible(false);
				BookUi.this.dispose();
				new Ui().setVisible(true);
			}
		});
		button.setBounds(623, 49, 137, 29);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u6B22\u8FCE\u7528\u6237");
		label_1.setBounds(245, 49, 81, 21);
		contentPane.add(label_1);
		this.setAlwaysOnTop(true);
	}
}
