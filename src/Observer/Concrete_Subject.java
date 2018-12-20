package Observer;

import java.util.HashMap;

import account.Account;
import account.Account_Observer;

public class Concrete_Subject extends Subject{
	
	
	 public void add(String component_name,Account_Observer account) {
		 list.put(component_name,account);
	 }
	 
	 public void remove(String component_name) {
		 list.remove(component_name);
	 }
	
	 public void notify_account(String product_name) {
		 if(list.containsKey(product_name)) {
			 Account_Observer account = list.get(product_name);
			 account.update(product_name);
		 }
	 }
	 
	 
}
