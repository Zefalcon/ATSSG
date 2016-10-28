package ATSSG.Actions;
import ATSSG.Building;

public abstract class BuildingAction extends Action {

	//Variables
	protected Building performer;

	//Methods
	public void setPerformer(Building performer){
		this.performer = performer;
	}

	public Building getPerformer(){
		return performer;
	}
}