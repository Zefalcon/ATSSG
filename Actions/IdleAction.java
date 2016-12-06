package ATSSG.Actions;
import ATSSG.Cell;
import ATSSG.Enums.CommandType;

public class IdleAction extends Action {
	
	//Variables
	protected Cell destination;
	
	//Constructor
	public IdleAction(){
		type = CommandType.IDLE;
	}
	
	//Methods
	public boolean execute(){
		return true;
	}

}