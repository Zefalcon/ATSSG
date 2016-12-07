package ATSSG.Actions;
import java.util.List;

import ATSSG.Cell;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.CommandType;

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
			throw new RuntimeException("Entity"+perf.getId()+" cannot currently attack Entity"+enem.getId() 
					+". Target is "+Cell.distance(perf.getContainingCell(), enem.getContainingCell())+" units away. Attack range is "
					+ perf.getType().aRange);
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

	public String toString(){
		return performer.toString() + " to attack " + enemy.toString();
	}
	
	@Override
	public String saveString(){
		List<Entity> master_list = performer.getOwner().getContaining_map().getEntities();
		return
			"-atk:" + Integer.toString(master_list.indexOf(performer))
			+ "," + Integer.toString(turnsToComplete)
			+ "," + Integer.toString(master_list.indexOf(enemy))
			+ "-"
		;
	}

}