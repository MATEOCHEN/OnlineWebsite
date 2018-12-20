package Controller_Mediator;

import View.Home_View;
import View.Warehouse_View;

public class Warehouse_Controller {
	private Controller_mediator cm;
	private Warehouse_View warehouse_View;

	public Warehouse_Controller(Controller_mediator cm, Warehouse_View warehouse_View) {
		this.cm = cm;
		this.warehouse_View = warehouse_View;
	}
	
	public Controller_mediator getControllerMediator() {
		return  this.cm;
	}
	
	
	
	
}
