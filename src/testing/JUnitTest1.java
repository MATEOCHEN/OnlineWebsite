package testing;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

import Composite.Addidas_Clothes1;
import Composite.Addidas_Pants1;
import Composite.Addidas_Shoes1;
import Composite.Component;
import Composite.Spcart_Composite;
import Controller_Mediator.ShopCart_Controller;
import account.Account;

public class JUnitTest1 {

	@Test
	public void test() {
		Component shopcart_composite = new Spcart_Composite();
		Component addidas_Pants_p1 = new Addidas_Pants1("N_Clothes1", "很棒的褲子"
				, "NC01", 1180, new ImageIcon("src/Nike/Nike_pants_1.png"), 5);
		Component addidas_Shoes_p1 = new Addidas_Shoes1("N_Shoes1", "Addidas 很棒的襪子"
				, "NS01", 500, new ImageIcon("src/Nike/Nike_shoes_1.png"), 5);
		Component addidas_Clothes_p1 = new Addidas_Clothes1("N_Clothes1", "Addidas 很棒的衣服"
				, "NS01", 1000, new ImageIcon("src/Nike/Nike_clothes_1.png"), 5);
		Component addidas_Clothes_p2 = new Addidas_Clothes1("N_Clothes2", "Addidas 很水的衣服"
				, "NS01", 1000, new ImageIcon("src/Nike/Nike_clothes_2.png"), 5);
		shopcart_composite.getList().add(addidas_Pants_p1);
		shopcart_composite.getList().add(addidas_Shoes_p1);
		shopcart_composite.getList().add(addidas_Clothes_p1);
		shopcart_composite.getList().add(addidas_Clothes_p2);
		ShopCart_Controller c = new ShopCart_Controller();
		double discount = c.getDiscount(shopcart_composite, new Account("User@example.com","","Guest","",""));
		System.out.println(discount);
		
		assertEquals(0.9,discount,0);
	}

}
