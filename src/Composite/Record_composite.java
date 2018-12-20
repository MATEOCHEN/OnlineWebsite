package Composite;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Record_composite extends Component {
	ArrayList<Component> Ware_list = new ArrayList<Component>();
	
	public void operation() {
		
	}
	public void add(Component c) {
		Ware_list.add(c);
	}
	
	public void remove(Component c) {
		Ware_list.remove(c);
	}
	
	public Component getConponent(int i) {
		return Ware_list.get(i);
	}
	public ArrayList<Component> getList() {
		// TODO Auto-generated method stub
		return Ware_list;
	}
	
	public ImageIcon getImage() {
		return null;
	}
	public String getName() {
		return null;
	}
	@Override
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