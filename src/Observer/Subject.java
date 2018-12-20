package Observer;

import java.util.HashMap;

import account.Account;
import account.Account_Observer;

public abstract class Subject {
	 HashMap<String,Account_Observer> list  = new HashMap<String,Account_Observer>(); 
	 public abstract void add(String component_name,Account_Observer account);
	 
	 public abstract void remove(String component_name);
	
	 public abstract void notify_account(String name);
	 
}
