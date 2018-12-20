package mememto;

import java.util.ArrayList;

public class CareTaker {
	private final ArrayList<Memento> savepointStorage = new ArrayList<Memento>();
	public void saveMemento(Memento mememto,int index) {
		System.out.println("Saving state..."+ " " + index);
		savepointStorage.add(mememto);
	}
	
	public Memento getMemento(int i) {
		return savepointStorage.get(i);
	}
	
	public int getArrayList_length() {
		return this.savepointStorage.size();
	}
	
	public void removeSavePoint(int i) {
		savepointStorage.remove(i);
		System.out.println("Remove the save points "+ i + " ...");
	}
}
