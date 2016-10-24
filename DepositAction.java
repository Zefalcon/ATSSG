package ATSSG;

public class DepositAction extends Action {
	
	//Variables
	protected Building dropZone;
	
	//Constructor
	public DepositAction(int numTurns, Entity perf, Building building){
		turnsToComplete = numTurns;
		performer = perf;
		dropZone = building;
	}
	
	//Methods
	public boolean execute(){
		//Executes deposit(dropZone) of performer
		return false;
	}
	
	public void setDropZone(Building building){
		
	}

}
