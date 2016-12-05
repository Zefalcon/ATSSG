package ATSSG.Actions;
import ATSSG.Entities.Unit;
import ATSSG.Enums.BuildingType;

public class BuildBuildingAction extends UnitAction {
	
	//Variables
	protected BuildingType toBuild;
	
	//Constructor
	public BuildBuildingAction(int numTurns, Unit perf, BuildingType building){
		performer = perf;
		turnsToComplete = numTurns;
		toBuild = building;
	}
	
	//Methods
	public boolean execute(){
		//Executes build(toBuild) of performer
		if(performer.build(toBuild)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setBuildingType(BuildingType building){
		toBuild = building;
	}

}
