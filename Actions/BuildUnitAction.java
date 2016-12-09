package ATSSG.Actions;
import ATSSG.Entities.Building;
import ATSSG.Enums.UnitType;

import java.io.IOException;

import ATSSG.Cell;

public class BuildUnitAction extends BuildingAction {
	
	//Variables
	protected UnitType toBuild;
	protected Cell location;
	
	//Constructor
	public BuildUnitAction(int numTurns, Building perf, UnitType unit, Cell toPlace){
		turnsToComplete = numTurns;
		performer = perf;
		toBuild = unit;
		location = toPlace;
	}
	
	//Methods
	public boolean execute() throws IOException {
		//Executes build(toBuild, location) of performer
		if(performer.build(toBuild, location)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setUnitType(UnitType toSet){
		toBuild = toSet;
	}
	public void setLocation(Cell toPlace) { location = toPlace; }
}
