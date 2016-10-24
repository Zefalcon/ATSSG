package ATSSG;

public class HarvestAction extends Action {
	
	//Variables
	protected ResourceItem toHarvest;
	
	//Constructor
	public HarvestAction(int numTurns, Entity perf, ResourceItem resource){
		turnsToComplete = numTurns;
		performer = perf;
		toHarvest = resource;
	}
	
	//Methods
	public boolean execute(){
		//Executes harvest(toHarvest) of performer
		return false;
	}
	
	public void setResource(ResourceItem resource){
		
	}

}
