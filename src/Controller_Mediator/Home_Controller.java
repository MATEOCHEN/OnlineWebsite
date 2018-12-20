package Controller_Mediator;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Composite.Component;
import View.Home_View;

public class Home_Controller{
	public Controller_mediator cm;
	private String Help; 
	private String mark;
	private Home_View home_View;
	
	public Home_Controller(Controller_mediator cm, Home_View home_View) {
		this.cm=cm;
		this.home_View=home_View;
	}
	//---------呼叫mediator 轉換介面------------------
	public void CallHome1() {
		cm.homeCloseView();
		cm.home1OpenView();
	}	
	
	public void CallLogin() {
		cm.homeCloseView();
		cm.loginOpenView();
	}
	
	public void CallShop() {
		cm.shopOpenView();
	}
	//---------結束------------------
	
	//-----------View open and close-----------

	public void Openhome_view() {
		home_View.setVisible(true);
	}
	public void Closehome_view() {
		home_View.setVisible(false);
	}
	//-----------View open and close-----------
	
	public void ShowHelpMessage() {
		String Help="1: Login與Register按鈕進行登入與註冊\n2: 下方可以點選衣服、褲子、鞋子";
		JOptionPane.showMessageDialog(null, Help,"操作流程",JOptionPane.INFORMATION_MESSAGE);
	}	
	
	public void setMark(String mark) {
		this.mark=mark;
	}

	public void Callhome1_setMark() {
		cm.Callhome1_setMark(mark);
	}
	public String getMark() {
		return mark;
	}
	
	//------Change the elements of the view------
	public void setName(String name) {
		home_View.setName(name);
	}
	
	public void SetLoginBtn_name(String name) {
		home_View.SetLoginBtn_name(name);
	}
	
	//------Change the all  label and login name------
	public void changeNameLabel(String name) {
		cm.changeNameLabel(name);
	}
	
	public void changeLoginButton(String name) {
		cm.changeLoginButton(name);
	}
	
	public void setGuestAccount() {
		cm.setGuestAccount();
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		home_View.SetNotifyImage(icon);
	}
	
	
}
