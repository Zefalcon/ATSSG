package ATSSG;

public abstract class BuilderUnitAction extends UnitAction {

	//Variables
	protected BuilderUnit builder;

	//Constructor
	public BuilderUnitAction(BuilderUnit buil, int numTurns){
		builder = buil;
		performer = buil;
		turnsToComplete = numTurns;
	}

	//Methods
	public void setBuilder(BuilderUnit buil){
		builder = buil;
	}

	public BuilderUnit getBuilder(){
		return builder;
	}
}