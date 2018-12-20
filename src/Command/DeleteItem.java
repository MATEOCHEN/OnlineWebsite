package Command;

import Composite.Component;
import Controller_Mediator.ShopCart_Controller;
import account.Account;

public class DeleteItem implements Command {
	private ShopCart_Controller receiver;
	private String product_name;
	private Account current_Account;
	private Component currentComponent;
	
	int index;
	public DeleteItem(ShopCart_Controller receiver,String pd_name,int i) {
		this.receiver = receiver;
		this.product_name = pd_name;
		this.index = i;
		this.current_Account = receiver.getCurrentAccount();
		this.currentComponent = receiver.getshopcart_Composite().getList().get(i);
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		receiver.repaintView();
		receiver.deleteCartItem(product_name, index);
		receiver.getCart();
		receiver.setTotalPrice(index);
		receiver.setDisocunt(current_Account);
		receiver.setTotal();
		
		System.out.println("Discount：" + receiver.getDiscount(receiver.getshopcart_Composite(),current_Account));
	}
	public void unexecute() {
		// TODO Auto-generated method stub
		receiver.repaintView();
		receiver.getshopcart_Composite().add(currentComponent);
		receiver.getCart();
		receiver.setDisocunt(current_Account);
		
		System.out.println("Discount：" + receiver.getDiscount(receiver.getshopcart_Composite(),current_Account));
	}

}
