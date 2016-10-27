package ATSSG.Actions;
import ATSSG.ResourceItem;
import ATSSG.Unit;

public class HarvestAction extends UnitAction {
	
	//Variables
	protected ResourceItem toHarvest;
	
	//Constructor
	public HarvestAction(int numTurns, Unit perf, ResourceItem resource){
		performer = perf;
		turnsToComplete = numTurns;
		toHarvest = resource;
	}
	
	//Methods
	public boolean execute(){
		//Executes harvest(toHarvest) of performer
		if(performer.harvest(toHarvest)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setResource(ResourceItem resource){
		toHarvest = resource;
	}

}
