package ATSSG;

public class BuildBuildingAction extends BuilderUnitAction {
	
	//Variables
	protected BuildingType toBuild;
	
	//Constructor
	public BuildBuildingAction(int numTurns, BuilderUnit perf, BuildingType building){
		super(perf, numTurns);
		toBuild = building;
	}
	
	//Methods
	public boolean execute(){
		//Executes build(toBuild) of performer
		if(builder.build(toBuild)){
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
