package Controller_Mediator;

import javax.swing.ImageIcon;

import Composite.Component;
import Observer.Concrete_Subject;
import View.ClearOrder;
import View.Home_View;
import View.Home1_View;
import View.Login_View;
import View.PdInformation_View;
import View.PdList_View;
import View.ShopCart_View;
import account.Account;

public class Controller_mediator {
	Home_Controller home_controller;
	Home1_Controller home1_controller;
	ProductList_Controller pdlist_controller;
	PdInformation_controller pdIn_controller;
	ShopCart_Controller shopcart_controller;
	Login_Controller login_controller;
	
	String Login_status;
	public Controller_mediator() {	
	
	}
	
	//----------SetController------------
		public void sethome_controller(Home_Controller home_controller) {
			this.home_controller = home_controller;
		}
		public void sethome1_controller(Home1_Controller home1_controller) {
			this.home1_controller = home1_controller;
		}
		public void setpdlist_controller(ProductList_Controller pdlist_controller) {
			this.pdlist_controller = pdlist_controller;
		}
		public void setpdIn_controller(PdInformation_controller pdIn_controller) {
			this.pdIn_controller = pdIn_controller;
		}
		
		public void setshopcart_controller(ShopCart_Controller shopcart_controller) {
			this.shopcart_controller = shopcart_controller;
		}
		
		public void setlogin_controller(Login_Controller login_controller) {
			this.login_controller = login_controller;
		}
	//-----------------------------------
	
	
	//-------介面轉換------------
    //適用於home 與 home1 回去home介面
	public void HomeOpenView() {
		home_controller.setMark("");
		home_controller.Openhome_view();		
	}
	//適用於home 與 home1 回去home介面 
	
	public void homeOpenView() {
		home_controller.setMark("");
		pdlist_controller.remove_record_list();
		home_controller.Openhome_view();
	}
	public void homeCloseView() {
		home_controller.Closehome_view();
	}
	
	public void home1OpenView() {
		home1_controller.Openhome_view();
	}
	public void home1CloseView() {
		home1_controller.Closehome_view();
	}
		
	public void pdListOpenView() {
		pdlist_controller.Openhome_view();
	}
	public void pdListCloseView() {
		pdlist_controller.Closehome_view();
	}
	
	public void pdInOpenView() {
		pdIn_controller.OpenpdIn_view();
	}
	public void pdInCloseView() {
		pdIn_controller.ClosepdIn_view();
	}
	
	public void shopCloseView() {
		shopcart_controller.Closeshop_view();
	}
	
	public void shopOpenView() {
		shopcart_controller.Openshop_view();
	}
	
	public void loginOpenView() {
		login_controller.OpenLogin_View();
	}
	public void loginCloseView() {
		login_controller.CloseLogin_View();
	}
	//-------介面轉換結束------------
	
	//-------介面與介面的溝通
	public void Callhome_setMark(String mark) {
		home_controller.setMark(mark);
	}
	public void Callhome1_setMark(String mark) {
		home1_controller.setMark(mark);
	}
	public void CallPdlist_setMark(String mark) {
		pdlist_controller.setMark(mark);
		System.out.println("(來源於mediator) pdlist_controller 的 mark為"+pdlist_controller.getMark());
		
	}
	public void CallPdlist_setRecord() {
		pdlist_controller.Record_list();
	}
	
	public void CallPdIn_setRecord_component(Component c) {
		pdIn_controller.SetComponent(c);
	}
	
	public void CallPdlist_clear_pictur() {
		pdlist_controller.clear_picture();
	}
	//-------介面與介面的溝通------
	
	//Change the element of view.//
	public void changeNameLabel(String name) {
		home_controller.setName(name);
		home1_controller.setName(name);
		pdlist_controller.setName(name);
		pdIn_controller.setName(name);
	}
	
	public void changeLoginButton(String name) {
		home_controller.SetLoginBtn_name(name);
		home1_controller.SetLoginBtn_name(name);
		pdlist_controller.SetLoginName(name);
		pdIn_controller.SetLoginBtn_name(name);
	}
	
	public void changeNotifyImage(ImageIcon icon) {
		home_controller.SetNotifyImage(icon);
		home1_controller.SetNotifyImage(icon);
		pdlist_controller.SetNotifyImage(icon);
		pdIn_controller.SetNotifyImage(icon);
	}
	
	
	//Change the element of view.//
	
	public void addShoppingCart(String email) {
		shopcart_controller.addShoppingCart(email);
	}
	
	
	public Component CallShop_getshop_composite() {
		return shopcart_controller.getshopcart_Composite();
	}
	
	public Component CallProdulist_getwarehouse_composite() {
		return pdlist_controller.getWarehouse_composite();
	}
	
	public void setDiscount(Account a) {
		shopcart_controller.setDisocunt(a);
	}
	
	public void setGuestAccount() {
		login_controller.setAccount(new Account("User@example.com","","Guest","",""));
		login_controller.searchShoppingCart("User@example.com");
	}
	
	public Account getAccount() {
		return login_controller.getAccount();
	}
	
	public double getAccountAccumulate() {
		return login_controller.getAccountAccumulate();
	}
	
	public Concrete_Subject getConcrete_Subject() {
		return pdIn_controller.getConcrete_Subject();
	}
	
	
}
