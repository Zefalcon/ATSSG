package ATSSG.Script.Framework;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import org.junit.Test;

import ATSSG.GameMap;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.RCommodityType;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIConfig;
import ATSSG.Player.AI.AIPlayer;
import ATSSG.Script.Framework.DataAccessStatement.AccessType;

public class DataAccessStatementTest {

	@Test
	public void testExecute() throws IOException, ScriptError {
		GameMap gm = new GameMap(new File("src/ATSSG/Maps/empty.map"));
		Player ai = new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), new BufferedImage(1,1, 1), gm, new AIConfig());
		Player enemy = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), gm);
		Unit test_unit = new Unit(UnitType.Soldier, ai, gm.getCell(8, 7));
		Unit ally = new Unit(UnitType.Cavalry, ai, gm.getCell(9, 7));
		Unit enem = new Unit(UnitType.Guardtower, enemy, gm.getCell(2, 3));
		Script s = new Script(test_unit);
		new DataAccessStatement(AccessType.My_ID, "my_id", new ArrayList<String>()).execute(s);
		assertEquals(new Double(test_unit.getId()), (Double) s.getHeap().get("my_id"));
		new DataAccessStatement(AccessType.Cell_Cost, "cell_cost", Arrays.asList("my_id", "1", "1")).execute(s);
		assertEquals((Double) UnitType.Soldier.passableTerrain.get(TerrainType.GRASS).doubleValue(), (Double) s.getHeap().get("cell_cost"));
		new DataAccessStatement(AccessType.Current_HP, "current_hp", Arrays.asList("my_id")).execute(s);
		assertEquals(new Double(test_unit.getHitPoints()), (Double) s.getHeap().get("current_hp"));
		new DataAccessStatement(AccessType.Damage, "damage", Arrays.asList("my_id")).execute(s);
		assertEquals(new Double(UnitType.Soldier.aDamage), (Double) s.getHeap().get("damage"));
		new DataAccessStatement(AccessType.Is_Alive, "alive1", Arrays.asList("my_id")).execute(s);
		assertTrue((Boolean) s.getHeap().get("alive1"));
		new DataAccessStatement(AccessType.Is_Alive, "alive2", Arrays.asList("-1")).execute(s);
		assertFalse((Boolean) s.getHeap().get("alive2"));
		new DataAccessStatement(AccessType.Is_Enemy, "enemy1", Arrays.asList(new Double(ally.getId()).toString())).execute(s);
		assertFalse((Boolean) s.getHeap().get("enemy1"));
		new DataAccessStatement(AccessType.Is_Enemy, "enemy2", Arrays.asList(new Double(enem.getId()).toString())).execute(s);
		assertTrue((Boolean) s.getHeap().get("enemy2"));
		new DataAccessStatement(AccessType.IsCellPassable, "passable", Arrays.asList("my_id", "1", "1")).execute(s);
		assertTrue((Boolean) s.getHeap().get("passable"));
		new DataAccessStatement(AccessType.Maximum_HP, "max_hp", Arrays.asList("my_id")).execute(s);
		assertEquals(new Double(UnitType.Soldier.maxHP), (Double) s.getHeap().get("max_hp"));
		new DataAccessStatement(AccessType.Maximum_Moves, "max_moves", Arrays.asList("my_id")).execute(s);
		assertEquals(new Double(UnitType.Soldier.maxMoves), (Double) s.getHeap().get("max_moves"));
		new DataAccessStatement(AccessType.Maximum_valid_id, "max_id", new ArrayList<String>()).execute(s);
		assertEquals(new Double(Entity.getNextId()-1), (Double) s.getHeap().get("max_id"));
		new DataAccessStatement(AccessType.Range, "range", Arrays.asList("my_id")).execute(s);
		assertEquals(new Double(UnitType.Soldier.aRange), (Double) s.getHeap().get("range"));
		new DataAccessStatement(AccessType.X_Loc, "x", Arrays.asList(new Double(enem.getId()).toString())).execute(s);
		assertEquals((Double) 2.0, (Double) s.getHeap().get("x"));
		new DataAccessStatement(AccessType.Y_Loc, "y", Arrays.asList(new Double(enem.getId()).toString())).execute(s);
		assertEquals((Double) 3.0, (Double) s.getHeap().get("y"));
	}

	@Test
	public void testStatementDone() {
		assertTrue(new DataAccessStatement(null, null, null).statementDone());
	}

	@Test
	public void testCopy() {
		DataAccessStatement orig = new DataAccessStatement(AccessType.Maximum_HP, "v1", Arrays.asList("0"));
		DataAccessStatement copy = (DataAccessStatement) orig.copy();
		assertNotSame(orig, copy);
		assertEquals(orig.getType(), copy.getType());
		assertTrue(orig.getVarname().equals(copy.getVarname()));
		assertNotSame(orig.getArguments(), copy.getArguments());
		assertTrue(orig.getArguments().get(0).equals(copy.getArguments().get(0)));
	}

}
