package ATSSG.Actions;
import ATSSG.Entities.Unit;
import ATSSG.Cell;

public class MoveAction extends UnitAction {
	
	//Variables
	protected Cell destination;
	
	//Constructor
	public MoveAction(int numTurns, Unit perf, Cell end){
		turnsToComplete = numTurns;
		performer = perf;
		destination = end;
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
