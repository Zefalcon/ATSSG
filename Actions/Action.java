package ATSSG.Actions;

import ATSSG.CommandType;

public abstract class Action { //Flag we should totally make one or two ActionType enums instead of all these subclasses.
	
	//Variables
	protected int turnsToComplete;
	protected CommandType type;
	
	//Methods
	public boolean execute(){
		return true;
	}
	
	public void setNumTurns(int numTurns){
		turnsToComplete = numTurns;
	}
	
	public int getNumTurns(){
		return turnsToComplete;
	}
	
	public CommandType getType() {
		return type;
	}
}
