package Composite;

import javax.swing.ImageIcon;

public class Addidas_Clothes1 extends Clothes {
	private String name;
	private String pd_detail;
	private String IDE;
	private int price;
	private int quantity;
	private ImageIcon icon ;
	private int shop_quantity = 0;
	
	public Addidas_Clothes1(String name, String pd_detail, String IDE, int price,ImageIcon icon,int quantity) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.pd_detail=pd_detail;
		this.IDE=IDE;
		this.price=price;
		this.icon=icon;
		this.quantity=quantity;
	}
	
	public Addidas_Clothes1(ImageIcon url,String name,int price,int quantity) {
		this.icon = url;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	
	public String getUrl() {
		return this.icon.toString();
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
