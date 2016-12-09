package ATSSG.Actions;

import java.io.IOException;

import ATSSG.Enums.CommandType;

public abstract class Action {
	
	//Variables
	protected int turnsToComplete;
	protected CommandType type;
	
	//Methods
	public boolean execute() throws IOException{
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
	
	public abstract String saveString();
}
