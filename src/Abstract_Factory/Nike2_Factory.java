package Abstract_Factory;

import Composite.Clothes;
import Composite.Nike_Clothes2;
import Composite.Nike_Pants2;
import Composite.Nike_Shoes2;
import Composite.Pants;
import Composite.Shoes;

public class Nike2_Factory extends Abstaract_Factory{
	
	public Nike2_Factory() {
		super.set();
	}
	
	public Clothes create_Clothes() {
		Nike_Clothes2 n_clothes2 = new Nike_Clothes2(name[1],Pd_detail[1],IDE[1],price[1],icon[1],quantity[1]); 
		return n_clothes2;
	}
	public Pants create_Paints() {
		Nike_Pants2 n_pants2 = new Nike_Pants2(name[3],Pd_detail[3],IDE[3],price[3],icon[3],quantity[3]); 
		return n_pants2;
	}
	public Shoes create_Shoes() {
		Nike_Shoes2 n_shoes2 = new Nike_Shoes2(name[5],Pd_detail[5],IDE[5],price[5],icon[5],quantity[5]); 
		return n_shoes2;
	}
	
	
	
}