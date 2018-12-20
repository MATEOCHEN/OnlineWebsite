package Abstract_Factory;


import Composite.Clothes;
import Composite.Nike_Clothes1;
import Composite.Nike_Pants1;
import Composite.Nike_Shoes1;
import Composite.Pants;
import Composite.Shoes;

public class Nike1_Factory extends Abstaract_Factory{
	
	public Nike1_Factory() {
		super.set();
	}
	
	public Clothes create_Clothes() {
		Nike_Clothes1 n_clothes1 = new Nike_Clothes1(name[0],Pd_detail[0],IDE[0],price[0],icon[0],quantity[0]); 
		return n_clothes1;
	}
	public Pants create_Paints() {
		Nike_Pants1 n_pants1 = new Nike_Pants1(name[2],Pd_detail[2],IDE[2],price[2],icon[2],quantity[2]); 
		return n_pants1;
	}
	public Shoes create_Shoes() {
		Nike_Shoes1 n_shoes1 = new Nike_Shoes1(name[4],Pd_detail[4],IDE[4],price[4],icon[4],quantity[4]); 
		return n_shoes1;
	}
	
	
	
}