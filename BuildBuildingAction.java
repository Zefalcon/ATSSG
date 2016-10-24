package ATSSG;

public class BuildBuildingAction extends Action {
	
	//Variables
	protected BuildingType toBuild;
	
	//Constructor
	public BuildBuildingAction(int numTurns, Entity perf, BuildingType building){
		turnsToComplete = numTurns;
		performer = perf;
		toBuild = building;
	}
	
	//Methods
	public boolean execute(){
		//Executes build(toBuild) of performer
		return false;
	}
	
	public void setBuildingType(BuildingType building){
		
	}

}
