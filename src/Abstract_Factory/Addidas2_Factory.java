package Abstract_Factory;

import Composite.Addidas_Clothes2;
import Composite.Addidas_Pants2;
import Composite.Addidas_Shoes2;
import Composite.Clothes;
import Composite.Pants;
import Composite.Shoes;

public class Addidas2_Factory extends Abstaract_Factory{
	
	public Addidas2_Factory() {
		super.set();
	}
	
	public Clothes create_Clothes() {
		Addidas_Clothes2 a_clothes2 = new Addidas_Clothes2(name[7],Pd_detail[7],IDE[7],price[7],icon[7],quantity[7]); 
		return a_clothes2;
	}
	public Pants create_Paints() {
		Addidas_Pants2 a_pants2 = new Addidas_Pants2(name[9],Pd_detail[9],IDE[9],price[9],icon[9],quantity[9]); 
		return a_pants2;
	}
	public Shoes create_Shoes() {
		Addidas_Shoes2 a_shoes2 = new Addidas_Shoes2(name[11],Pd_detail[11],IDE[11],price[11],icon[11],quantity[11]); 
		return a_shoes2;
	}
	
	
	
	
}
