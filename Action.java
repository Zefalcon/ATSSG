package ATSSG;

public abstract class Action {
	
	//Variables
	protected int turnsToComplete;
	
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
}
