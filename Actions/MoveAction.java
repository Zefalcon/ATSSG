package ATSSG.Actions;
import ATSSG.Entities.Unit;
import ATSSG.Cell;
import ATSSG.CommandType;

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

}
