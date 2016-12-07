package ATSSG.Actions;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.CommandType;

import java.util.List;

import ATSSG.Cell;

public class MoveAction extends UnitAction {
	
	//Variables
	protected Cell destination;
	
	//Constructor
	public MoveAction(int numTurns, Unit perf, Cell end){
		turnsToComplete = numTurns;
		performer = perf;
		destination = end;
		type = CommandType.MOVE;
		if (!perf.canMoveTo(end)) {
			throw new RuntimeException("Entity"+perf.getId()+" cannot currently move to ("+end.getX()+","+end.getY()+")");
		}
	}
	
	//Methods
	public boolean execute(){
		//Executes move(destination) of performer
		if(performer.move(destination)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setEndPoint(Cell end){
		destination = end;
	}
	
	@Override
	public String saveString(){
		List<Entity> master_list = performer.getOwner().getContaining_map().getEntities();
		return
			"-mov:" + Integer.toString(master_list.indexOf(performer))
			+ "," + Integer.toString(turnsToComplete)
			+ "," + Integer.toString(destination.getX())
			+ "," + Integer.toString(destination.getY())
			+ "-"
		;
	}

}
