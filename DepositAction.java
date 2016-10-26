package ATSSG;

public class DepositAction extends HarvesterUnitAction {
	
	//Variables
	protected Building dropZone;
	
	//Constructor
	public DepositAction(int numTurns, HarvesterUnit perf, Building building){
		super(perf, numTurns);
		dropZone = building;
	}
	
	//Methods
	public boolean execute(){
		//Executes deposit(dropZone) of performer
		if(harvester.deposit(dropZone)){
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
