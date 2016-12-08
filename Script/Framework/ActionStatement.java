package ATSSG.Script.Framework;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ATSSG.Actions.*;
import ATSSG.Entities.*;
import ATSSG.Enums.CommandType;

public class ActionStatement extends Statement {
	
	//Variables
	protected CommandType actionType;
	protected List<String> actionArgs;

	//Constructors
	public ActionStatement(CommandType act, List<String> args) {
		actionType = act;
		actionArgs = args;
	}
	
	//Methods
	@Override
	public boolean execute(Script environment) throws ScriptError {
		Action action = null;
		switch (actionType) {
		case ATTACK:
			action = new AttackAction(1, (Unit) environment.getOwner(), 
					DataAccessStatement.getEntity(Expression.getDoubleValue(actionArgs.get(0), environment).intValue(), environment));
			break;
		case IDLE:
			action = new IdleAction();
			break;
		case MOVE:
			int xVal = Expression.getDoubleValue(actionArgs.get(0), environment).intValue();
			int yVal = Expression.getDoubleValue(actionArgs.get(1), environment).intValue();
			action = new MoveAction(1, (Unit) environment.getOwner(), 
					environment.getOwner().getOwner().getContaining_map().getCell(xVal, yVal));
			break;
		default:
			return false;
		}
		environment.getOwner().setAction(action);
		try {
			environment.getOwner().executeAction();
		} catch (IOException e) {
			throw new ScriptError(environment, this, e.toString());
		}
		return true;
	}

	@Override
	public boolean statementDone() {
		return true;
	}

	@Override
	public Statement copy() {
		return new ActionStatement(actionType, new ArrayList<String>(actionArgs));
	}

	@Override
	public String toString(){
		switch (actionType) {
		case ATTACK:
			return "Action: Attacking \""+actionArgs.get(0)+"\"";
		case IDLE:
			return "Action: Idle";
		case MOVE:
			return "Action: Moving to ("+actionArgs.get(0)+","+actionArgs.get(1)+")";
		default:
			return "Action: None";
		}
	}
	
	public CommandType getActionType() {
		return actionType;
	}

	public void setAction(CommandType action) {
		this.actionType = action;
	}

	public List<String> getActionArgs() {
		return actionArgs;
	}

	public void setActionArgs(List<String> actionArgs) {
		this.actionArgs = actionArgs;
	}
	
	@Override
	public String saveString(int d){
		String args = "";
		for(String s : actionArgs){
			args = args + s + ";";
		}
		return "act:" + Integer.toString(actionType.ordinal()) + "," + args;
	}

}
