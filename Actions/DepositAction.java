package ATSSG.Actions;
import ATSSG.Entities.Building;
import ATSSG.Entities.Unit;

public class DepositAction extends UnitAction {
	
	//Variables
	protected Building dropZone;
	
	//Constructor
	public DepositAction(int numTurns, Unit perf, Building building){
		performer = perf;
		turnsToComplete = numTurns;
		dropZone = building;
	}
	
	//Methods
	public boolean execute(){
		//Executes deposit(dropZone) of performer
		if(performer.deposit(dropZone)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setDropZone(Building building){
		dropZone = building;
	}

}
