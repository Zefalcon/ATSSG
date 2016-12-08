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
import ATSSG.Enums.CommandType;
import ATSSG.Enums.RCommodityType;
import ATSSG.Enums.UnitType;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIConfig;
import ATSSG.Player.AI.AIPlayer;

public class ActionStatementTest {

	@Test
	public void testExecute() throws IOException, ScriptError {
		GameMap gm = new GameMap(new File("src/ATSSG/Maps/empty.map"));
		Player ai = new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), new BufferedImage(1,1,1), null, gm, new AIConfig());
		Player enemy = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), gm);
		Unit testUnit = new Unit(UnitType.Soldier, ai, gm.getCell(4, 5));
		Unit enem = new Unit(UnitType.Soldier, enemy, gm.getCell(2, 3));
		Script s = new Script(testUnit);
		assertTrue(new ActionStatement(CommandType.IDLE, new ArrayList<String>()).execute(s));
		assertEquals(testUnit.getContainingCell(), gm.getCell(4, 5));
		assertTrue(new ActionStatement(CommandType.MOVE, Arrays.asList("3","3")).execute(s));
		assertEquals(testUnit.getContainingCell(), gm.getCell(3, 3));
		assertTrue(new ActionStatement(CommandType.ATTACK, Arrays.asList(new Double(enem.getId()).toString())).execute(s));
		assertEquals(UnitType.Soldier.maxHP-UnitType.Soldier.aDamage, enem.getHitPoints());		
	}

	@Test
	public void testStatementDone() {
		assertTrue(new ActionStatement(null, null).statementDone());
	}

	@Test
	public void testCopy() {
		ActionStatement orig = new ActionStatement(CommandType.MOVE, Arrays.asList("0", "1"));
		ActionStatement copy = (ActionStatement) orig.copy();
		assertNotSame(orig, copy);
		assertEquals(orig.getActionType(), copy.getActionType());
		assertNotSame(orig.getActionArgs(), copy.getActionArgs());
		assertTrue(orig.getActionArgs().get(0).equals(copy.getActionArgs().get(0)));
		assertTrue(orig.getActionArgs().get(1).equals(copy.getActionArgs().get(01)));
	}

}
