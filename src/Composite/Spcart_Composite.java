package Composite;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Spcart_Composite extends Component{
	
	ArrayList<Component> list = new ArrayList<Component>(); 
	
	public void add(Component c) {
		list.add(c);
	}
	
	public void remove(Component c) {
		list.remove(c);
	}
	
	public Component getConponent(int i) {
		return list.get(i);
	}
	
	public ArrayList<Component> getList() {
		return list;
	}
	
	public void operation() {
		
	}
	
	public void setArrayList(ArrayList<Component> list) {
		this.list = list;
	}
	
	public  ImageIcon getImage() {
		return null;
	}
	public void setShop_Quantity(int shop_quantity) {
		// TODO Auto-generated method stub
		//do nothing
	}
	@Override
	public int getShop_Quantity() {
		// TODO Auto-generated method stub
		return 0;
	}
}
