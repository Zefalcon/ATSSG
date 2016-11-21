package ATSSG.Script.Framework;
import ATSSG.Actions.*;

public class ActionStatement extends Statement {
	
	//Variables
	protected Action action;
	
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	//Constructors
	public ActionStatement(Action act) {
		action = act;
	}
	
	//Methods
	@Override
	public boolean execute(Script environment) throws ScriptError {
		environment.getOwner().setAction(action);
		return true;
	}

	@Override
	public boolean statementDone() {
		return true;
	}

	@Override
	public Statement copy() {
		return new ActionStatement(action);
	}

}
