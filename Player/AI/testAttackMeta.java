package ATSSG.Player.AI;

import static org.junit.Assert.*;

import org.junit.Test;

import ATSSG.Unit;
import ATSSG.UnitType;

public class testAttackMeta {

	@Test
	public void testIsDone() {
		Unit attacker = new Unit(UnitType.Soldier, null, null);
		Unit target = new Unit(UnitType.Soldier, null, null);
		MetaAction m = new AttackMeta(attacker, target);
		assert(!m.isDone());
		target.doDamage(UnitType.Soldier.maxHP);
		assert(m.isDone());
	}

}
