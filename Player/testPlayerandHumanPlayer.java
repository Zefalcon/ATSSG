package ATSSG.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import ATSSG.GameMap;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.RCommodityType;
import ATSSG.Enums.UnitType;

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
		assertTrue(p.getEntities().contains(u));
	}
	
	@Test
	public void integratedTest() throws IOException {
		GameMap gm = new GameMap(new File("src/ATSSG/Maps/empty.map"));
		Player human = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), gm);
		Unit u1 = new Unit(UnitType.Soldier, human, gm.getCell(1, 1));
		Unit u2 = new Unit(UnitType.Soldier, human, gm.getCell(1, 2));
		u1.setAction(new MoveAction(1, u1, gm.getCell(0, 0)));
		u2.setAction(new MoveAction(1, u2, gm.getCell(3, 4)));
		human.executeAll();
		assertEquals(gm.getCell(0, 0),u1.getContainingCell());
		assertEquals(gm.getCell(3, 4),u2.getContainingCell());
	}

	@Test
	public void testRemoveEntity() throws IOException {
		Entity u = new Unit(UnitType.Soldier, null, null);
		List<Entity> units = new ArrayList<Entity>();
		units.add(u);
		Player p = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), units, null);
		assertTrue(p.getEntities().contains(u));
		p.removeEntity(u);
		assertFalse(p.getEntities().contains(u));
	}

}
