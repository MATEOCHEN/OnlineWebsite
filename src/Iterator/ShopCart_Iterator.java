package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

import Composite.Component;


public class ShopCart_Iterator implements Iterator<Object>{
	private ArrayList<Component> shopcart;
	int pos = 0;
	
	public ShopCart_Iterator(ArrayList<Component> shopcart) {
		this.shopcart = shopcart;
	}
	@Override
	public boolean hasNext() {
		if(pos>=shopcart.size()||shopcart.get(pos)==null) {
			return false;
		}
		return true;
	}


	public Component next() {
		// TODO Auto-generated method stub
		pos++;
		return shopcart.get(pos - 1);
	}
	
	public void remove() {
		if(pos <= 0 )
		throw new IllegalStateException("Illegal position");
		if(shopcart.get(pos) !=null){
		for (int i= pos-1; i<(shopcart.size()-1);i++){
			shopcart.set(i, shopcart.get(i+1));
		}
			shopcart.set(shopcart.size() - 1 , null);
		}
	}
}
