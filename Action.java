package ATSSG;

public abstract class Action {
	
	//Variables
	protected int turnsToComplete;
	protected Entity performer;
	
	//Methods
	public boolean execute(){
		return false;
	}
	
	public void setNumTurns(int numTurns){
		turnsToComplete = numTurns;
	}
	
	public int getNumTurns(){
		return turnsToComplete;
	}
	
	public void setPerformer(Entity perf){
		performer = perf;
	}
	
	public Entity getPerformer(){
		return performer;
	}

}
