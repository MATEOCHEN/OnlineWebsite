package account;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Composite.Component;
import Composite.Spcart_Composite;
public class Account extends Account_Observer{
	private String email;
	private String passwd;
	private String name;
	private String phoneNumber;
	private String address;
	ArrayList<String> notify_list = new ArrayList<String>(); 
	
	private double accumulate_spend  = 0;
	public Account(String email,String passwd,String name,String address,String phoneNumber){
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber; 
	}
	
	public String getName() {
		return this.name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public void addAccumulate(double spend) {
		accumulate_spend = spend + 0;
	}
	
	public void setAccumulate(double spend) {
		this.accumulate_spend = spend;
	}
	public double getAccumulate() {
		return this.accumulate_spend;
	}
	
	public void update(String product_name) {
		String Help=product_name + "商品以更新 ，已經發送消息給訂閱者";
		JOptionPane.showMessageDialog(null, Help,"通知",JOptionPane.INFORMATION_MESSAGE);
		notify_list.add(product_name+"商品 已經有存貨，現在可以前往購買");   
		
	}
	
	public ArrayList<String> get_notify_list(){
		return notify_list;
	}
	
}
