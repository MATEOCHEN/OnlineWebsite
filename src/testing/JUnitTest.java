package testing;


import javax.swing.ImageIcon;

import org.junit.Test;

import static org.junit.Assert.*;
import Composite.Addidas_Pants1;
import Composite.Component;
import Composite.Spcart_Composite;
import Controller_Mediator.ShopCart_Controller;
import account.Account;

public class JUnitTest{

	@Test
	public void test() {
		Component shopcart_composite = new Spcart_Composite();
		Component addidas_Pants_p1 = new Addidas_Pants1("N_Clothes1", "Nike Dri-FIT Kobe 男款籃球 T 恤採用排汗材質搭配經典細節設計，有助於在場上保持乾爽舒適。"
				, "NC01", 1180, new ImageIcon("src/Nike/Nike_clothes_1.png"), 100);
		shopcart_composite.getList().add(addidas_Pants_p1);
		ShopCart_Controller c = new ShopCart_Controller();
		double discount = c.getDiscount(shopcart_composite, new Account("User@example.com","","Guest","",""));
		System.out.println(discount);
		
		assertEquals(0.85,discount,0);
	}

}
