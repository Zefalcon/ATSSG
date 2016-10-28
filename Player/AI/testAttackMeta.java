package ATSSG.Player.AI;

import static org.junit.Assert.*;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.UnitType;
import ATSSG.Entities.Unit;
import ATSSG.Player.HumanPlayer;

public class testAttackMeta {

	@Test
	public void testIsDone() {
		Unit attacker = new Unit(UnitType.Soldier, new HumanPlayer(null, null, null), new Cell(null, null, null, 0, 0));
		Unit target = new Unit(UnitType.Soldier, new HumanPlayer(null, null, null), new Cell(null, null, null, 0, 0));
		MetaAction m = new AttackMeta(attacker, target);
		assert(!m.isDone());
		target.doDamage(UnitType.Soldier.maxHP);
		assert(m.isDone());
	}

}
