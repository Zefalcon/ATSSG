package ATSSG;

public abstract class HarvesterUnitAction extends UnitAction {

	//Variables
	protected HarvesterUnit harvester;

	//Constructor
	public HarvesterUnitAction(HarvesterUnit harv, int numTurns){
		harvester = harv;
		performer = harv;
		turnsToComplete = numTurns;
	}

	//Methods
	public void setHarvester(HarvesterUnit harv){
		harvester = harv;
	}

	public HarvesterUnit getHarvester(){
		return harvester;
	}
}