package ATSSG;

public class BuildUnitAction extends Action {
	
	//Variables
	protected UnitType toBuild;
	
	//Constructor
	public BuildUnitAction(int numTurns, Entity perf, UnitType unit){
		turnsToComplete = numTurns;
		performer = perf;
		toBuild = unit;
	}
	
	//Methods
	public boolean execute(){
		//Executes build(toBuild) of performer
		return false;
	}
	
	public void setUnitType(UnitType toSet){
		
	}

}
