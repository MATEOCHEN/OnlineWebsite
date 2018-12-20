package Abstract_Factory;

import javax.swing.ImageIcon;

import Composite.Clothes;
import Composite.Pants;
import Composite.Shoes;
import Main.Picture;

public abstract class Abstaract_Factory {
	
	Picture picture = new Picture();
	String[] name;
	String[] Pd_detail;
	String[] IDE;
	int[] price;
	ImageIcon[] icon;
	int[] quantity;
	
	public void set() {
		picture.SetImageIcon();	
		
		name = picture.getName();
		Pd_detail = picture.getPd_detail();
		IDE = picture.getIDE();
		price = picture.getPrice();
		icon = picture.getImagIcon();
		quantity = picture.getQuantity();
	}
	
	public abstract Clothes create_Clothes();
	public abstract Pants create_Paints();
	public abstract Shoes create_Shoes();
	
	
	
	
}
