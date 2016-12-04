package ATSSG.Player;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import ATSSG.Entities.Entity;
import ATSSG.RCommodityType;
import ATSSG.Entities.Unit;
import ATSSG.UnitType;

public class testPlayerandHumanPlayer {

	@Test
	public void testKill() {
		Player p = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), null);
		p.kill();
		assertNull(p.getContaining_map());
		assertNull(p.getResources());
		assertNull(p.getEntities());		
	}

	@Test
	public void testAddEntity() throws IOException {
		Unit u = new Unit(UnitType.Soldier, null, null);
		Player p = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), null);
		p.addEntity(u);
		assert(p.getEntities().contains(u));
	}

	@Test
	public void testRemoveEntity() throws IOException {
		Entity u = new Unit(UnitType.Soldier, null, null);
		List<Entity> units = new ArrayList<Entity>();
		units.add(u);
		Player p = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), units, null);
		assert(p.getEntities().contains(u));
		p.removeEntity(u);
		assert(!p.getEntities().contains(u));
	}

}
