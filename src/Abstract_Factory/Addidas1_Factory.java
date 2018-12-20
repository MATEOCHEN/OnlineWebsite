package Abstract_Factory;

import Composite.Addidas_Clothes1;
import Composite.Addidas_Pants1;
import Composite.Addidas_Shoes1;
import Composite.Clothes;
import Composite.Pants;
import Composite.Shoes;

public class Addidas1_Factory extends Abstaract_Factory{
	
	public Addidas1_Factory() {
		super.set();
	}
	
	
	public Clothes create_Clothes() {
		Addidas_Clothes1 a_clothes1 = new Addidas_Clothes1(name[6],Pd_detail[6],IDE[6],price[6],icon[6],quantity[6]); 
		return a_clothes1;
	}
	public Pants create_Paints() {
		Addidas_Pants1 a_pants1 = new Addidas_Pants1(name[8],Pd_detail[8],IDE[8],price[8],icon[8],quantity[8]); 
		return a_pants1;
	}
	public Shoes create_Shoes() {
		Addidas_Shoes1 a_shoes1 = new Addidas_Shoes1(name[10],Pd_detail[10],IDE[10],price[10],icon[10],quantity[10]); 
		return a_shoes1;
	}
	
	
	
}
