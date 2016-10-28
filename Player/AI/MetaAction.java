package ATSSG.Player.AI;

import ATSSG.Actions.Action;

public abstract class MetaAction {	
	public abstract Action nextAction();
	public abstract Boolean isDone();
}