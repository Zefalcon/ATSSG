package ATSSG;

public class MoveAction extends Action {
	
	//Variables
	protected Cell destination;
	
	//Constructor
	public MoveAction(int numTurns, Entity perf, Cell end){
		turnsToComplete = numTurns;
		performer = perf;
		destination = end;
	}
	
	//Methods
	public boolean execute(){
		//Executes move(destination) of performer
		return false;
	}
	
	public void setEndPoint(Cell end){
		
	}

}
