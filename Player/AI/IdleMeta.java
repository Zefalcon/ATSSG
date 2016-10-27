package ATSSG.Player.AI;

import ATSSG.Actions.Action;

public class IdleMeta extends MetaAction {

	@Override
	public Action nextAction() {
		return null;
	}

	@Override
	public Boolean isDone() {
		return true;
	}

}
