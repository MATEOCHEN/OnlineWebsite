package Controller_Mediator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import View.Home1_View;
import View.Home_View;

public class Home1_Controller {
	public Controller_mediator cm;
	private String Help; 
	private String mark;
	private Home1_View home1_View;

	public Home1_Controller(Controller_mediator cm,Home1_View home1_View) {
		this.cm=cm;
		this.home1_View=home1_View;
	}
	//---------呼叫mediator 轉換介面------------------
	public void CallProductList() {
		cm.home1CloseView();
		cm.pdListOpenView();
	}
	
	public void CallHome() {
		cm.home1CloseView();
		cm.HomeOpenView();
	}
	
	public void CallLogin() {
		cm.loginOpenView();
		cm.home1CloseView();
	}
	
	public void CallCart() {
		cm.shopOpenView();
		cm.home1CloseView();
	}
	//---------結束------------------
	//-----------View open and close-----------
	public void Openhome_view() {
		home1_View.setVisible(true);
	}
	public void Closehome_view() {
		home1_View.setVisible(false);
	}
	//-----------View open and close-----------
	
	public void ShowHelpMessage() {
		Help="1: Login與Register按鈕進行登入與註冊\n2: 下方可以點選衣服、褲子、鞋子";
		JOptionPane.showMessageDialog(null, Help,"操作流程",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setMark(String mark) {
		this.mark=mark;
	}
	public void CallPdlist_setMark() {
		cm.CallPdlist_setMark(mark);
	}
	public String getMark() {
		return mark;
	}
	public void CallPdlist_record() {
		cm.CallPdlist_setRecord();
	}
	
	public void setName(String name ) {
		home1_View.setName(name);
	}
	
	public void SetLoginBtn_name(String name) {
		home1_View.SetLoginBtn_name(name);
	}
	
	public void setGuestAccount() {
		cm.setGuestAccount();
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		home1_View.SetNotifyImage(icon);
	}
}
