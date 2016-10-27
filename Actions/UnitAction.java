package ATSSG.Actions;
import ATSSG.Unit;

public abstract class UnitAction extends Action{

	//Variables
	protected Unit performer;

	//Methods
	public void setPerformer(Unit perf){
		performer = perf;
	}

	public Unit getPerformer(){
		return performer;
	}

}