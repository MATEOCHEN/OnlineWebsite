package Controller_Mediator;

import java.util.ArrayList;


import javax.swing.JOptionPane;

import Composite.Component;
import Iterator.ShopCart_Iterator;
import View.PaymentCheck_View;
import View.ShopCart_View;
import account.Account;
import db.DBMgr;

public class ShopCart_Controller {
	
	Controller_mediator cm;
	private Component ware_composite;
	private ShopCart_View shopcart_view ; 
	private Component shopcart_composite;	
	
	private ArrayList<Component> lastShopCartList;

	
	private double discount;
	
	public ShopCart_Controller(Controller_mediator cm,ShopCart_View shopcart_view) {
		this.cm=cm;
		this.shopcart_view=shopcart_view;
	}
	
	public ShopCart_Controller() {
		
	}
	

	public void CallHome() {
		cm.shopCloseView();
		cm.homeOpenView();
	}
	
	public void CallPaymentCheck() {
		PaymentCheck_View PaymentCheck = new PaymentCheck_View();
		PaymentCheck.setVisible(true);
	}
	public void CallClearOrder(String total,String discount,String shippingfee,String payment,String pay_type) {
		String accountName = cm.getAccount().getName();
		System.out.println(accountName);
		ClearOrder_Controller co_controller = new ClearOrder_Controller(this);
		co_controller.displayOrderInfo(accountName,total,discount,shippingfee,payment,pay_type);
		cm.shopCloseView();
	}
	
	public void CallLogin() {
		cm.shopCloseView();
		cm.loginOpenView();
	}
	
	//-----------View open and close-----------
	
	public void Openshop_view() {
		shopcart_view.setVisible(true);
		this.getCart();
		this.setDisocunt(cm.getAccount());
		shopcart_view.setTotal();
	}
	
	public void Closeshop_view() {
		shopcart_view.setVisible(false);
	}
	//-----------View open and close-----------
	
	public void SetWare_Composite(Component ware_composite) {	
		this.ware_composite = ware_composite;
		for(Component lists :ware_composite.getList()) {
			System.out.println("Shopping_cart���b�]�w���w  �ثe���ӫ~��"+lists.getName());
		}
	}
	
	public Component getWare_Composite() {	
		return ware_composite;
	}
	
	public void ShowHelpMessage() {
		String Help="1: Login�PRegister���s�i��n�J�P���U\n2: �U��i�H�I���A�B�Ǥl�B�c�l";
		JOptionPane.showMessageDialog(null, Help,"�ާ@�y�{",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	public void setShopcart_Composite(Component shopcart_composite) {  
		this.shopcart_composite=shopcart_composite;	
	}
	
	public Component getshopcart_Composite() {						
		return shopcart_composite;
	}
	
	public void addShoppingCart(String email) { //db data verify
		ArrayList<Component> list = cm.CallShop_getshop_composite().getList();
		ArrayList<Component> db_list = DBMgr.getInstance().getShoppingCart(email);
		boolean isInput= false;
		for(int i = 0 ; i < list.size(); i++) {
			for(int j = 0 ; j < db_list.size() ; j++) {
				if(list.get(i).getName().equals(db_list.get(j).getName())) {
					DBMgr.getInstance().updateQuantity(email, list.get(i).getName(),list.get(i).getQuantity()+db_list.get(j).getQuantity());
					isInput=true;
					break;
				}
			}
			if(isInput == false) {
				DBMgr.getInstance().insertShoppingCart(email,list.get(i).getImage().toString(),list.get(i).getName(), list.get(i).getPrice(), list.get(i).getQuantity());
			}
			isInput=false;
		}
	}
	
	public void deleteCartItem(String pd_name,int i) {
		lastShopCartList = new ArrayList<Component>();
		for(int i1 = 0 ; i1 < shopcart_composite.getList().size(); i1++) {
			lastShopCartList.add(shopcart_composite.getList().get(i1));
		}
		String savePoint = pd_name + "saved";
		shopcart_composite.getList().remove(i); //remove the cart item
		DBMgr.getInstance().deleteCartItem(cm.getAccount().getEmail(), pd_name); //remove the data from database
	}
	
	public void updateQuantity(String pd_name,int quantity,int i) {
			this.shopcart_composite.getList().get(i).setQuantity(quantity);
			DBMgr.getInstance().updateQuantity(cm.getAccount().getEmail(),pd_name,quantity);
	}
	
	
	
	public void getCart() {
		ArrayList<Component> sp_cart = this.shopcart_composite.getList();
		if(sp_cart.size() == 0) {
			shopcart_view.empty_print();
		} else {
			for(int i= 0; i < sp_cart.size(); i++) {
				shopcart_view.addItem(sp_cart.get(i).getImage(),sp_cart.get(i).getName(),sp_cart.get(i).getPrice(),sp_cart.get(i).getQuantity(),i);
			}
		}
	}	//------add the shoppingCart item to front page.------
	
	public void setDisocunt(Account a) {
		this.discount = getDiscount(shopcart_composite,a);
		shopcart_view.setDiscount(discount);
	}
	
	public void setQuantity(int i,String sign) {
		shopcart_view.setQuantity(i, sign);
	}
	
	public double getDiscount(Component shopcart,Account currentAccount) {
		double accumulatePrice = currentAccount.getAccumulate();
		double discount = 0;
		int itemcount = 0;
		ShopCart_Iterator iterator = new ShopCart_Iterator(shopcart.getList());
		if(accumulatePrice >= 100000) {
			discount = 0.8;
		} else {
			while(iterator.hasNext()) {
				Component next = iterator.next();
				double quantity = next.getQuantity();
				String name = next.getName();
				itemcount ++;
				if(quantity >= 100) {
					System.out.println(name);
					System.out.println(quantity);
					discount = 0.85;
					break;
				} else if(itemcount >= 3){
					discount = 0.9;
					continue;
				}
			}
		}
		System.out.println(discount);
		return discount;
	}
	
	public Account getCurrentAccount() {
		return cm.getAccount();
	}
	
	public void repaintView() {
		this.shopcart_view.repaint_bodyPanel();
	}
	
	public void triggerConfirmButton(String type) {
		ClearOrder_Controller c= new ClearOrder_Controller(this);
		c.setType(type);
	}
	
	public void setTotal() {
		shopcart_view.setTotal();
	}
	
	public void setTotalPrice(int i) {
		shopcart_view.setTotalPrice(i);
	}
}
