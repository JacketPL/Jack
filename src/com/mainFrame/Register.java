package com.mainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import com.db.*;

import com.data.*;
public class Register extends JFrame {
	private Db db=new Db();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//
//	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("\u6CE8\u518C\u7528\u6237");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(199, 57, 121, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 141, 121, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 99, 121, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pattern="\\d{8}";//正则匹配8为数字组成的字符串
			
				List<User> list=new ArrayList<User>();
				list=new Db().queryUserSql();
				boolean flag=false;
				for(User user : list){
					if(user.getUserId().equals(textField.getText()))
						flag=true;
				}//判断输入的数据是否已经存在了
				if(flag==true){
					javax.swing.JOptionPane.showMessageDialog(Register.this, "用户已经存在了");
					return; //重新输入
				}
				
				if(!Pattern.matches(pattern,textField.getText() )){//匹配数字 看是不是由8位数字组成的
				javax.swing.JOptionPane.showMessageDialog(Register.this,"不是8位数字id 请按要求填写");
					return ;
				}
				if(textField_3.getText().equalsIgnoreCase("")){//用户名不能为空
					javax.swing.JOptionPane.showMessageDialog(Register.this, "用户名不能为空");
					return;
				}
			
				String patternPassword="\\w{8,16}";//匹配任何[a-zA-Z0-9]字符类8到16个
				if(!Pattern.matches(patternPassword, textField_1.getText())){
					javax.swing.JOptionPane.showMessageDialog(Register.this, "请输入8-16个数字字母");
					return ;
				}
				String radios=" ";
				if(rdbtnNewRadioButton.isSelected()){
					radios=rdbtnNewRadioButton.getSelectedObjects()[0].toString();
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					radios=rdbtnNewRadioButton_1.getSelectedObjects()[0].toString();
				}
				db.insertSqlUser(textField.getText(), textField_3.getText(),textField_1.getText(),radios);
				db.close();
				javax.swing.JOptionPane.showMessageDialog(Register.this, "你已成功注册");
				return;
			}
		});
		btnNewButton.setBounds(135, 271, 75, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("id\u53F7");
		lblNewLabel.setBounds(135, 59, 57, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setBounds(135, 102, 57, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setBounds(135, 144, 57, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u6027\u522B");
		label.setBounds(135, 209, 57, 21);
		contentPane.add(label);
		
		rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.setBounds(199, 205, 57, 29);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		rdbtnNewRadioButton_1.setBounds(263, 205, 57, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.this.dispose();
			}
		});
		button.setBounds(225, 271, 75, 29);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(332, 39, 186, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("id\u75318\u4F4D\u6570\u5B57\u7EC4\u6210");
		lblNewLabel_3.setBounds(15, 15, 156, 21);
		panel.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("\u5BC6\u78018-16\u4F4D\u5B57\u6BCD\u6570\u5B57");
		label_1.setBounds(15, 101, 171, 21);
		panel.add(label_1);
		
	}
}
