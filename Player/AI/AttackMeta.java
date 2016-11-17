package ATSSG.Player.AI;

import ATSSG.Actions.Action;
import ATSSG.Actions.AttackAction;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;

public class AttackMeta extends MetaAction {
	Unit attacker;
	Entity target;

	public Unit getAttacker() {
		return attacker;
	}

	public Entity getTarget() {
		return target;
	}

	public AttackMeta(Unit attacker, Entity target) {
		this.attacker = attacker;
		this.target = target;
	}
	
	@Override
	public Action nextAction() {
		if (target.getHitPoints() == 0 || attacker.getHitPoints() == 0) return null;
		if (attacker.canAttack(target)) return new AttackAction(1, attacker, target);
		//TODO: reuse previous moves on unmoving target
		return new MoveMeta(target.getContainingCell(), attacker).nextAction();
	}

	@Override
	public Boolean isDone() {
		return target.getHitPoints() <= 0 || attacker.getHitPoints() == 0;
	}
}
