package ATSSG;

public abstract class UnitAction {

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