package ATSSG;

public class AttackAction extends Action {
	
	//Variables
	protected Entity enemy;
	
	//Constructor
	public AttackAction(int numTurns, Entity perf, Entity enem){
		turnsToComplete = numTurns;
		performer = perf;
		enemy = enem;
	}
	
	//Methods
	public boolean execute(){
		//Executes attack(enemy) of performer
		return false;
	}
	
	public void setTarget(Entity target){
		
	}

}
