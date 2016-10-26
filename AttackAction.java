package ATSSG;

public class AttackAction extends UnitAction {
	
	//Variables
	protected Entity enemy;
	
	//Constructor
	public AttackAction(int numTurns, Unit perf, Entity enem){
		turnsToComplete = numTurns;
		performer = perf;
		enemy = enem;
	}
	
	//Methods
	public boolean execute(){
		//Executes attack(enemy) of performer
		if(performer.attack(enemy)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setTarget(Entity target){
		enemy = target;
	}

}
