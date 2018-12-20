package Main;
 
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import Abstract_Factory.Abstaract_Factory;
import Abstract_Factory.Addidas1_Factory;
import Abstract_Factory.Addidas2_Factory;
import Abstract_Factory.Nike1_Factory;
import Abstract_Factory.Nike2_Factory;
import Composite.*;
import Controller_Mediator.*;
import View.*;
import account.Account;

	public class Client {
		public static void main(String[] args) throws SQLException {
			
		     Component spcart_coposite;
			 Component ware_list;
			 Component nike_Clothes_p1;
			 Component nike_Clothes_p2;
			 Component nike_Pants_p1;
			 Component nike_Pants_p2;
			 Component nike_Shoes_p1;
			 Component nike_Shoes_p2;
			 Component addidas_Clothes_p1;
			 Component addidas_Clothes_p2;
			 Component addidas_Pants_p1;
			 Component addidas_Pants_p2;
			 Component addidas_Shoes_p1;
			 Component addidas_Shoes_p2;
		
			 
		//------------AbstractFactory---------------
			 Abstaract_Factory a1,a2,n1,n2;
			 a1 = new Addidas1_Factory();
			 a2 = new Addidas2_Factory();
			 n1 = new Nike1_Factory();
			 n2 = new Nike2_Factory();
	    //------------AbstractFactory---------------
					 
			 
		//-------------Composite--------------------	
			
			ware_list =new WareHouse_Composite();
			Component record_composite = new Record_composite();
			
			nike_Clothes_p1 = n1.create_Clothes();
			nike_Clothes_p2 = n2.create_Clothes();
			nike_Pants_p1 = n1.create_Paints();
			nike_Pants_p2 = n2.create_Paints();
			nike_Shoes_p1 = n1.create_Shoes();
			nike_Shoes_p2 = n2.create_Shoes();
			
			addidas_Clothes_p1 = a1.create_Clothes();
			addidas_Clothes_p2 = a2.create_Clothes();
			addidas_Pants_p1 = a1.create_Paints();
			addidas_Pants_p2 = a2.create_Paints();
			addidas_Shoes_p1 = a1.create_Shoes();
			addidas_Shoes_p2 = a2.create_Shoes();
				
			ware_list.add(nike_Clothes_p1);
			ware_list.add(nike_Clothes_p2);
			ware_list.add(nike_Pants_p1);
			ware_list.add(nike_Pants_p2);
			ware_list.add(nike_Shoes_p1);
			ware_list.add(nike_Shoes_p2);
			
			ware_list.add(addidas_Clothes_p1);
			ware_list.add(addidas_Clothes_p2);
			ware_list.add(addidas_Pants_p1);
			ware_list.add(addidas_Pants_p2);
			ware_list.add(addidas_Shoes_p1);
			ware_list.add(addidas_Shoes_p2);


		//-------------Composite--------------------	
			
		//-------------View-------------------------
			Home_View  home = new Home_View();
			Home1_View home1= new Home1_View();
			Login_View loginOrRegister = new Login_View();
			PdInformation_View pdIn = new PdInformation_View();
			PdList_View pdList = new PdList_View();
			ShopCart_View shoppingcart = new ShopCart_View();
			Warehouse_View ware_house = new Warehouse_View();
			home.setVisible(true);
			ware_house.setVisible(true);
		//-------------View-------------------------
			
		//------------Controller--------------------
			
			Controller_mediator controller_mediator = new Controller_mediator();
			
			Home_Controller home_controller = new Home_Controller(controller_mediator,home);
			home.SetController(home_controller);
			
			Home1_Controller home1_controller = new Home1_Controller(controller_mediator,home1);
			home1.SetController(home1_controller);
			
			ProductList_Controller pdlist_controller = new ProductList_Controller(controller_mediator,pdList);
			pdList.SetController(pdlist_controller);
			pdlist_controller.SetWare_list(ware_list); //???
			
			PdInformation_controller pdIn_controller = new PdInformation_controller(controller_mediator,pdIn);
			pdIn.SetController(pdIn_controller);

			
			ShopCart_Controller shopcart_controller = new ShopCart_Controller(controller_mediator,shoppingcart);
			shoppingcart.SetController(shopcart_controller);
			Component spcart_comosite = new Spcart_Composite();
			shopcart_controller.setShopcart_Composite(spcart_comosite);
			
			Login_Controller login_controller = new Login_Controller(controller_mediator,loginOrRegister);
			login_controller.initializeShopCart(spcart_comosite);
			loginOrRegister.SetController(login_controller);
			
			Warehouse_Controller warehouse_Controller = new Warehouse_Controller(controller_mediator ,ware_house);
			ware_house.SetController(warehouse_Controller);
			
		//------------Controller--------------------	
			

		//------------SetMediator----------------
			controller_mediator.sethome_controller(home_controller);
			controller_mediator.sethome1_controller(home1_controller);
			controller_mediator.setpdlist_controller(pdlist_controller);
			controller_mediator.setpdIn_controller(pdIn_controller);
			controller_mediator.setshopcart_controller(shopcart_controller);
			controller_mediator.setlogin_controller(login_controller);
		//---------------------------	
			
			
			
			
		
		
		
				
	}	
		
	
		
}
