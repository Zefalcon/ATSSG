package ATSSG.Player.AI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

import ATSSG.Cell;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.RCommodityType;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;
import ATSSG.Player.HumanPlayer;

public class testAttackMeta {

	public HumanPlayer setUpHuman() {
		return new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), null);
	}

	@Test
	public void testIsDone() throws IOException {
		Unit attacker = new Unit(UnitType.Soldier, setUpHuman(), new Cell(TerrainType.GRASS, null, null, 0, 0));
		Unit target = new Unit(UnitType.Soldier, setUpHuman(), new Cell(TerrainType.GRASS, null, null, 0, 0));
		MetaAction m = new AttackMeta(attacker, target);
		assert(!m.isDone());
		target.doDamage(UnitType.Soldier.maxHP);
		assert(m.isDone());
	}

}
