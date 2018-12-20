package Composite;

import javax.swing.ImageIcon;

public class Nike_Shoes1 extends Shoes {
	private String name;
	private String pd_detail;
	private String IDE;
	private int price;
	private int quantity;
	ImageIcon icon ;
	private int shop_quantity = 0;
	
	public Nike_Shoes1(String name, String pd_detail, String IDE, int price,ImageIcon icon,int quantity) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.pd_detail=pd_detail;
		this.IDE=IDE;
		this.price=price;
		this.icon=icon;
		this.quantity=quantity;
	}

	public String getName() {
		return name;
	}
	
	public String getPdDetail() {
		return pd_detail;
	}
	
	public ImageIcon getImage() {
		return icon;
	}
	
	public void operation() {
		
	}
	
	public void add(Component c) {
		//do nothing
	}
	
	public void remove(Component c) {
		//do nothing
	}
	
	public Component getConponent(int i) {
		//do nothing
		return null;
	}
	
	public String getIDE() {
		return IDE;
	}
	
	public int getPrice() {
		return price;
	}
	public String getDetail() {
		return pd_detail;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setShop_Quantity(int shop_quantity) {
		this.shop_quantity = shop_quantity;
	}
	public int getShop_Quantity() {
		return shop_quantity;
	}
}