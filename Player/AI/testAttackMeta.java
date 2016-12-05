package ATSSG.Player.AI;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.RCommodityType;
import ATSSG.UnitType;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;

public class testAttackMeta {

	public HumanPlayer setUpHuman() {
		return new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), null);
	}

	@Test
	public void testIsDone() throws IOException {
		Unit attacker = new Unit(UnitType.Soldier, setUpHuman(), new Cell(null, null, null, 0, 0));
		Unit target = new Unit(UnitType.Soldier, setUpHuman(), new Cell(null, null, null, 0, 0));
		MetaAction m = new AttackMeta(attacker, target);
		assert(!m.isDone());
		target.doDamage(UnitType.Soldier.maxHP);
		assert(m.isDone());
	}

}
