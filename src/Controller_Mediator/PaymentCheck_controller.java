package Controller_Mediator;

import javax.swing.JPanel;

import View.PaymentCheck_View;

import strategy.Context;
import strategy.CreditCard_strategy;
import strategy.LinePay_strategy;
import strategy.Strategy;
import strategy.WeChatPay_strategy;

public class PaymentCheck_controller {
	private PaymentCheck_View view = new PaymentCheck_View();
	public PaymentCheck_controller() {
	}
	
	public void contentPanelChange(JPanel type) {
		view.contentPaneChange(type);
		viewSetVisible();
	}
	
	public void viewSetVisible() {
		this.view.setVisible(true);
	}
	
	public void PaymentGUIShow(String type) {
		PaymentCheck_controller controller = new PaymentCheck_controller();
		Context c = new Context();
		Strategy s = null;
		switch(type) {
		case "LinePay":
			s = new LinePay_strategy();
			break;
		case "WeChatPay":
			s = new WeChatPay_strategy();
			break;
		case "CreditCard":
			s = new CreditCard_strategy();
			break;
		}
		c.setStrategy(s);
		controller.contentPanelChange(c.showGUI());
	}
}
