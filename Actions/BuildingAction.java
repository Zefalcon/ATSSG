package ATSSG.Actions;
import ATSSG.Entities.Building;

public abstract class BuildingAction extends Action {

	//Variables
	protected Building performer;

	//Methods
	public void setPerformer(Building performer){
		performer = performer;
	}

	public Building getPerformer(){
		return performer;
	}
}