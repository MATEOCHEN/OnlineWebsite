package mememto;

import Command.Command;

public class Memento {
	private Command command;
	public Memento(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return this.command;
	}
}
