package ATSSG;

public class HarvestAction extends HarvesterUnitAction {
	
	//Variables
	protected ResourceItem toHarvest;
	
	//Constructor
	public HarvestAction(int numTurns, HarvesterUnit perf, ResourceItem resource){
		super(perf, numTurns);
		toHarvest = resource;
	}
	
	//Methods
	public boolean execute(){
		//Executes harvest(toHarvest) of performer
		if(harvester.harvest(toHarvest)){
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
