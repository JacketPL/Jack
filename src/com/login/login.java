package com.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import com.db.*;
import com.data.*;
import com.mainFrame.*;

import javax.swing.JPasswordField;
public class login extends JFrame {

	static public String userId;//登录的时候记住用户的Id
	static public String userName;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JPasswordField textFieldPassword;
	static private Font font;
	private String user;
	private String password;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					login log=new login();
					log.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public String getUser(){
		return user;
	}
	public String getPassword(){
		return password;
	}
	public login() {
		
		this.setIconImage(Toolkit.getDefaultToolkit().createImage("D:\\Java\\workspace\\flight\\imgs\\login.PNG"));
		setAutoRequestFocus(false);
		setTitle("\u673A\u7968\u9884\u5B9A\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		
		contentPane.setLayout(null);
	//位置
		this.setLocation(600,200);
		JLabel labelUser = new JLabel("\u8D26\u53F7");
		labelUser.setBounds(108, 72, 44, 21);
		contentPane.add(labelUser);
		
		JLabel labelPassword = new JLabel("\u5BC6\u7801");
		labelPassword.setBounds(108, 128, 44, 21);
		contentPane.add(labelPassword);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldId.getText().equalsIgnoreCase("") || textFieldPassword.getText().equalsIgnoreCase("")){
					javax.swing.JOptionPane.showMessageDialog(login.this, "密码、账号不能为空 重新输入");
					return;					
				}
				List<User> list=new ArrayList<User>();
				list=new Db().queryUserSql();
				boolean flag=false;//用来判断是否输入的密码出现了错误
				for(User user :list){
			//	System.out.println(user.getUserName()+user.getUserId()+user.getUserPassword());测试代码	
			//	System.out.println(textFieldUser.getText()+textFieldPassword.getText());
				if(textFieldId.getText().equals(user.getUserId())&&textFieldPassword.getText().equals(user.getUserPassword()) ){
					
					userId=user.getUserId();
					userName=user.getUserName();
					new Ui().setVisible(true);//打开Ui框架
				    login.this.setVisible(false);//不让登录界面显示出来
				    login.this.dispose();//关闭登录界面
				    flag=true;
				    break;//终止for循环
				}
				}//for循环
				if(flag==false){
					javax.swing.JOptionPane.showMessageDialog(login.this, "密码不对 重新输入");
					return;
				}
				
			}
		});
		btnLogin.setBounds(118, 187, 97, 29);
		btnLogin.setFont(font);
		contentPane.add(btnLogin);
		
		JButton btnRegiste = new JButton("\u6CE8\u518C");
		btnRegiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register().setVisible(true);
			}
		});
		btnRegiste.setBounds(299, 187, 86, 29);
		contentPane.add(btnRegiste);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(155, 69, 230, 27);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(153, 125, 230, 27);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
	
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldId, textFieldPassword, btnLogin, btnRegiste, labelUser, labelPassword}));
	    this.setResizable(false);
		setVisible(true);
		         	
	}
}
