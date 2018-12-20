package Command;

import Controller_Mediator.ShopCart_Controller;
import account.Account;

public class UpdateItem implements Command{
	private ShopCart_Controller receiver;
	private String product_name;
	private int quantity;
	private int last_quantity;
	private int index;
	private String sign;
	private Account current_Account;
	
	
	public UpdateItem(ShopCart_Controller receiver,String pd_name,int quantity,int current_quantity,int i,String sign) {
		this.receiver = receiver;
		this.product_name = pd_name;
		this.quantity = quantity;
		this.last_quantity = current_quantity;
		this.index = i;
		this.current_Account = receiver.getCurrentAccount();
		this.sign = sign;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(sign + " " + Integer.toString(index));
		receiver.setQuantity(index, sign);
		receiver.updateQuantity(product_name, quantity, index);
		receiver.setDisocunt(current_Account);
		receiver.setTotal();
	}
	@Override
	public void unexecute() {
		String current_sign;
		// TODO Auto-generated method stub
		if(this.sign.equals("+")) {
			current_sign = "-";
		} else {
			current_sign = "+";
		}
		System.out.println(sign + " " + Integer.toString(index));
		receiver.setQuantity(index, current_sign);
		receiver.updateQuantity(product_name, last_quantity, index);
		receiver.setDisocunt(current_Account);
		receiver.setTotal();
	}

}
