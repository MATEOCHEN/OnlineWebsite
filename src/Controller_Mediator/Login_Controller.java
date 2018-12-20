package Controller_Mediator;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Composite.Component;
import Composite.Spcart_Composite;
import View.Login_View;
import account.Account;
import db.DBMgr;

public class Login_Controller {
	private Controller_mediator cm;
	private String Help; 
	private String mark;
	private Login_View loginView;
	private Account account = new Account("User@example.com","","Guest","","");
	
	public Login_Controller(Controller_mediator cm,Login_View loginView) {
		this.cm = cm;
		this.loginView = loginView;
	}
	public void callHome() {
		cm.HomeOpenView();
		cm.loginCloseView();
	}
	
	public void initializeShopCart(Component spcart_coposite) throws SQLException {
		ArrayList<Component> dbList = DBMgr.getInstance().getShoppingCart(this.account.getEmail());
		for(int i = 0; i < dbList.size() ; i ++) {
			spcart_coposite.add(dbList.get(i));
		}
			ResultSet guest_account = DBMgr.getInstance().getAccount(this.account.getEmail());
			this.account.setAccumulate(guest_account.getInt("accum_spend"));
	}	//------Set the data to the guest shoppinCart.
	
	public void addAccountRequest(String email,String passwd,String cfm_passwd,String name,String address,String phoneNumber) {
		if((email.isEmpty())||(passwd.isEmpty())||(cfm_passwd.isEmpty())||(name.isEmpty())||(address.isEmpty())||(phoneNumber.isEmpty())) {
			System.out.println("The register information can not be null value");
		} else {
			if((passwd.equals(cfm_passwd))) {
				DBMgr.getInstance().insertAccount(email, passwd, name, address, phoneNumber);
			} else {
				System.out.println("The password should equal to the confirmed password!!!");
			}
		}
	}

	public boolean verifyAccountRequest(String email,String passwd) {
		boolean result = false;
		if((email.isEmpty())||(passwd.isEmpty())) {
			System.out.println("Your password or email is empty!!");
			result = false;
		} else {
			loginView.setVisible(false);
			try {
				ResultSet login_acc = DBMgr.getInstance().getAccount(email);
				account = new Account(login_acc.getString("email"),login_acc.getString("password"),login_acc.getString("name"),login_acc.getString("address"),login_acc.getString("phoneNumber")); //new account(get from db)
				account.setAccumulate(login_acc.getInt("accum_spend"));
				cm.homeOpenView();
				cm.changeNameLabel("Hello~ "+ login_acc.getString("name")); //setting the member name in the homeView
				cm.changeLoginButton("Log Out");
				cm.addShoppingCart(email); //store in the database
				searchShoppingCart(email); //fetch the DB data and input to shopping cart.
				System.out.println(getAccount().getEmail());
				result = DBMgr.getInstance().verifyAccount(email, passwd);
			}  catch(SQLException e ) {
				System.out.println(e);
			}
		}
		return result;
	}
	/*------This is used to send the login account request.-----*/
	public void searchShoppingCart(String email) {
		
		Component current_shopCart = cm.CallShop_getshop_composite();
		int db_shopCart = DBMgr.getInstance().getShoppingCart(email).size();
		
		System.out.println(DBMgr.getInstance().getShoppingCart(email).size());
		
		Iterator<Component> iterator = current_shopCart.getList().iterator();
        while (iterator.hasNext()){
           iterator.next();
           iterator.remove();
        }
        
        for(int j = 0 ; j < db_shopCart ; j++) {
        	current_shopCart.add(DBMgr.getInstance().getShoppingCart(email).get(j));
			System.out.println("新增商品"+DBMgr.getInstance().getShoppingCart(email).get(j).getName());
		} //search the particular account's shoppingCart then add to current shoppingart		
		
	}	//------fetch the shoppingCart data from DB.------
	
	public void setAccount(Account a) {
		this.account = a;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	public double getAccountAccumulate() {
		return this.account.getAccumulate();
	}
	
	public void setAccountAccumulate(double acc) {
		this.account.setAccumulate(acc);
	}	//????
	
	public void OpenLogin_View() {
		this.loginView.setVisible(true);
	}
	
	public void CloseLogin_View() {
		this.loginView.setVisible(false);
	}
	/*------Control the View------*/
}
