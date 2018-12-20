package Composite;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Component {
	public abstract void operation();
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
	public ArrayList<Component> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	public abstract ImageIcon getImage();
	public String getName() {
		return null;
	}
	public String getIDE() {
		return null;
	}
	public int getPrice(){
		return 0;
	}
	public String getDetail() {
		return null;
	}
	public void setArrayList(ArrayList<Component> lastCart) {
		// TODO Auto-generated method stub
		
	}
	public void setQuantity(int quantity) {
		
	}
	public void addQuantity(int quantity) {
		
	}
	public int getQuantity() {
		return 0;
	}
	public abstract void setShop_Quantity(int shop_quantity);
	
	public abstract int getShop_Quantity();

	
	
}
