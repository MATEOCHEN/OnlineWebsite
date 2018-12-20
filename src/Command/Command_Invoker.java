package Command;

import mememto.CareTaker;
import mememto.Memento;

public class Command_Invoker {
	private Command cmd;
	private CareTaker caretaker = new CareTaker();;
	private int index = caretaker.getArrayList_length() - 1;
	private Boolean undo_isClick = false;
	
	public Command_Invoker() {
	}
	
	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}
	
	public void execute(int i) {
		this.cmd.execute();
		createSavePoint(i);
		System.out.println("index: "+ index);
		System.out.println("length: "+caretaker.getArrayList_length());
	}
	
	public void CommandUnexecute() {
		this.cmd.unexecute();
		System.out.println("index: "+ index);
	}
	
	public int getIndex() {
		return index;
	}
	
	public boolean Check_UndoClick() {
		return this.undo_isClick;
	}
	//------Mememto Pattern------
	
	public void createSavePoint(int i) {
		if(undo_isClick == true) {
			System.out.println("index: "+ index);
			for(int j = i ; j < caretaker.getArrayList_length() ; j++) {
				removeMemento(j);
				System.out.println("length: "+caretaker.getArrayList_length());
			}
			undo_isClick = false;
		}
		caretaker.saveMemento(new Memento(cmd),caretaker.getArrayList_length() + 1);
		index = caretaker.getArrayList_length() - 1;
	}
	
	public void removeMemento(int i) {
		caretaker.removeSavePoint(i);
	}
	
	public void undo() {
		//if(index != 0) {
			System.out.println("Your index is " + index );
			if(undo_isClick == false) {
				setOriginatorState(index);
				cmd.unexecute();
				undo_isClick = true;
			} else {
				index = index - 1;
				setOriginatorState(index);
				cmd.unexecute();
			}
			System.out.println("Now the state is state"+index);
		//} else {
			//System.out.println("You can not undo anymore!!!");
		//}
	}
	
	public void redo() {
		if(undo_isClick == false) {
			System.out.println("Your shoppingCart state is newest!!");
		} else {
			setOriginatorState(index);
			cmd.execute();
			index = index + 1;
		}
	}
	
	public void setOriginatorState(int i) {
		Memento men = caretaker.getMemento(i);
		setCommand(men.getCommand());
	}
	
	//------Mememto Pattern------
}
