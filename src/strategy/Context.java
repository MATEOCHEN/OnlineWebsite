package strategy;

import javax.swing.JPanel;

public class Context {
	private Strategy type;
	
	public Context() {}
	
	public void setStrategy(Strategy s) {
		this.type = s;
	}
	
	public JPanel showGUI() {
		return this.type.showGUI();
	}
}
