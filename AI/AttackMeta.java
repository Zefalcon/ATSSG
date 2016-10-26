package ATSSG.AI;

import ATSSG.Action;
import ATSSG.AttackAction;
import ATSSG.Entity;
import ATSSG.Unit;

public class AttackMeta extends MetaAction {
	Unit attacker;
	Entity target;

	public AttackMeta(Unit attacker, Entity target) {
		this.attacker = attacker;
		this.target = target;
	}
	
	@Override
	public Action nextAction() {
		if (attacker.validTargets().contains(target)) return new AttackAction(1, attacker, target);
		//TODO: reuse previous moves on unmoving target
		return new MoveMeta(target.getContainingCell(), attacker).nextAction();
	}

}
