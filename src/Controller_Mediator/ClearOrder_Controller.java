package Controller_Mediator;

import View.ClearOrder;
import strategy.Context;
import strategy.CreditCard_strategy;
import strategy.LinePay_strategy;
import strategy.Strategy;
import strategy.WeChatPay_strategy;

public class ClearOrder_Controller {
	private ShopCart_Controller c;
	private ClearOrder view;
	private ShopCart_Controller controller;
	private String PaymentType;
	public ClearOrder_Controller(ShopCart_Controller c) {
		this.c = c;
		view =  new ClearOrder(this);
	}
	
	public void displayOrderInfo(String account,String total,String discount,String shippingFee,String payment,String pay_type) {
		view.textPaneSet(account, total, discount, shippingFee, payment, pay_type);
		view.setType(pay_type);
		view.setVisible(true);
	}
	
	public void EditOrder() {
		view.setVisible(false);
		c.Openshop_view();
	}
	
	public void setType(String type) {
		this.PaymentType = type;
	}

	public void repaint() {
		c.repaintView();
	}
}
