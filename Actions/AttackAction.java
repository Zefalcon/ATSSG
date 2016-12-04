package ATSSG.Actions;
import ATSSG.CommandType;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;

public class AttackAction extends UnitAction {
	
	//Variables
	protected Entity enemy;
	
	//Constructor
	public AttackAction(int numTurns, Unit perf, Entity enem){
		turnsToComplete = numTurns;
		performer = perf;
		enemy = enem;
		type = CommandType.ATTACK;
		if (!perf.canAttack(enem)) {
			throw new RuntimeException("Entity"+perf.getId()+" cannot currently attack Entity"+enem.getId());
		}
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
