package ATSSG;

public class BuildUnitAction extends BuildingAction {
	
	//Variables
	protected UnitType toBuild;
	
	//Constructor
	public BuildUnitAction(int numTurns, Building perf, UnitType unit){
		turnsToComplete = numTurns;
		performer = perf;
		toBuild = unit;
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
	
	public void setUnitType(UnitType toSet){
		toBuild = toSet;
	}

}
