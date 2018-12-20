package Controller_Mediator;

import java.util.ArrayList;

import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Composite.Component;
import Observer.Concrete_Subject;
import db.DBMgr;
import View.Home_View;
import View.PdInformation_View;
import account.Account;

public class PdInformation_controller {
	public Controller_mediator cm;
	private String Help; 
	private String spcart;
	private PdInformation_View pdIn_view;
	
	private Component c;
	
	/*public double DiscountCount(Account account) {
		Item item = new Item(spcart_list,account);
		TwentyDiscountHandler handler = new TwentyDiscountHandler();
		return handler.operation(item);
	}*/
		
	
	public PdInformation_controller(Controller_mediator cm, PdInformation_View pdIn_view) {
		this.cm=cm;
		this.pdIn_view = pdIn_view;
	}
	//---------呼叫mediator 轉換介面------------------
	public void CallHome1() {
		cm.pdInCloseView();
		cm.home1OpenView();
	}	
	
	public void CallHome() {
		cm.pdInCloseView();
		cm.homeOpenView();
	}
	
	public void CallCart() {
		cm.pdInCloseView();
		cm.shopOpenView();
	}
	
	public void CallLogin() {
		cm.pdInCloseView();
		cm.loginOpenView();;
	}
	//---------結束------------------
	
	//-----------View open and close-----------

	public void OpenpdIn_view() {
		pdIn_view.setVisible(true);
	}
	public void ClosepdIn_view() {
		pdIn_view.setVisible(false);
	}
	//-----------View open and close-----------
	
	public void ShowHelpMessage() {
		Help="1: Login與Register按鈕進行登入與註冊\n2: 下方可以點選衣服、褲子、鞋子";
		JOptionPane.showMessageDialog(null, Help,"操作流程",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void ShowSuccessMessage() {
		spcart="成功加入到購物車";
		JOptionPane.showMessageDialog(null, spcart,"加入",JOptionPane.INFORMATION_MESSAGE);
	}		
	
	// 獲的傳入的商品(component)資訊
	public void SetComponent(Component c) {
		this.c = c;
		pdIn_view.setAll(c.getName(), c.getImage(), c.getDetail(), c.getPrice());
	}
	
	public void Call_pdlist_clear_picture() {
		cm.CallPdlist_clear_pictur();
	}
	
	public void setComponent(Component c) {
		this.c=c;
	}
	
	public Component getComponent() {
		return c;
	}
	
	public Component getshopcart_Composite() {
		return cm.CallShop_getshop_composite();
	}
	
	//set the elements of the view
	public void setName(String name) {
		pdIn_view.setName(name);
	}
	
	public void SetLoginBtn_name(String name) {
		pdIn_view.SetLoginBtn_name(name);
	}
	
	public Account getAccount() {
		return cm.getAccount();
	}
	
	public void setGuestAccount() {
		cm.setGuestAccount();
	}
	public void insertShoppingCart() {
		if(this.getAccount().getEmail() == null) {
			System.out.println("Save to client shoppingcart");
		} else {
			DBMgr.getInstance().insertShoppingCart(this.getAccount().getEmail(), c.getImage().toString(), c.getName(), c.getPrice(), c.getQuantity());
		}
	}
	
	public void updateQuantity(String email,String pd_name,int quantity) {
		DBMgr.getInstance().updateQuantity(email, pd_name, quantity);
	}
	
	public Concrete_Subject getConcrete_Subject() {
		return pdIn_view.getConcrete_Subject();
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		pdIn_view.SetNotifyImage(icon);
	}
}
