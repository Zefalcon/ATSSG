package ATSSG.Player.AI;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import ATSSG.*;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.RCommodityType;
import ATSSG.Enums.TerrainType;
import ATSSG.Enums.UnitType;
import ATSSG.Player.*;

import org.junit.Test;

public class AIPlayerTest {

	public AIPlayer setUpAIPlayer() {
		return new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), new BufferedImage(1,1, 1), null, null, new AIConfig());
	}
	public Player setUpEnemy() {
		return new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), null);
	}
	
	@Test
	public void testKill() {
		AIPlayer testPlayer = setUpAIPlayer();
		testPlayer.kill();
		assertNull(testPlayer.getPlannedActions());
	}
	
	@Test
	public void testForceReplan() throws IOException {
		AIPlayer testPlayer = setUpAIPlayer();
		Unit u = new Unit(UnitType.Soldier, testPlayer, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Entity enemy1 = new Unit(UnitType.Soldier, setUpEnemy(), new Cell(TerrainType.GRASS, null, null, 1, 1));
		testPlayer.planAttack(u, Arrays.asList(enemy1));
		testPlayer.forceReplan();
		assertTrue(testPlayer.getPlannedActions().isEmpty());
	}

	@Test
	public void testPlanAction() throws IOException {
		AIPlayer testPlayer = setUpAIPlayer();
		Entity mine = new Unit(UnitType.Soldier, testPlayer, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Entity enemy1 = new Unit(UnitType.Soldier, setUpAIPlayer(), new Cell(TerrainType.GRASS, null, null, 1, 1));
		testPlayer.planAction(mine, Arrays.asList(enemy1));
		Map<Entity, MetaAction> actions = testPlayer.getPlannedActions();
		assertTrue(actions.keySet().contains(mine));
		assertTrue(MetaAction.class.isInstance(actions.get(mine)));
		
	}

	@Test
	public void testPlanAttack() throws IOException {
		AIPlayer testPlayer = setUpAIPlayer();
		Unit u = new Unit(UnitType.Soldier, testPlayer, new Cell(TerrainType.GRASS, null, null, 0, 0));
		Entity enemy1 = new Unit(UnitType.Soldier, setUpEnemy(), new Cell(TerrainType.GRASS, null, null, 1, 1));
		Entity enemy2 = new Unit(UnitType.Soldier, setUpEnemy(), new Cell(TerrainType.GRASS, null, null, 1, 2));
		testPlayer.planAttack(u, Arrays.asList(enemy1));
		Map<Entity, MetaAction> actions = testPlayer.getPlannedActions();
		assertTrue(actions.keySet().contains(u));
		assertEquals(u, ((AttackMeta)actions.get(u)).getAttacker());
		assertEquals(enemy1, ((AttackMeta)actions.get(u)).getTarget());
		testPlayer.forceReplan();
		testPlayer.planAttack(u, Arrays.asList(enemy1, enemy2));
		assertTrue(actions.keySet().contains(u));		
		assertEquals(u, ((AttackMeta)actions.get(u)).getAttacker());
	}
	
	@Test
	public void integratedTest() throws IOException {
		GameMap gm = new GameMap(new File("src/ATSSG/Maps/empty.map"));
		Player ai = new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), 
				new BufferedImage(1,1, 1), null, gm, new AIConfig(1, 1, 1));
		Player enem = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), gm);
		new Unit(UnitType.Soldier, ai, gm.getCell(8, 8));
		new Unit(UnitType.Soldier, ai, gm.getCell(7, 8));
		new Unit(UnitType.Soldier, enem, gm.getCell(1, 1));
		new Unit(UnitType.Soldier, enem, gm.getCell(1, 2));
		for (int i=0; i<10; i++) {
			ai.executeAll();
		}
		assertEquals(0,enem.getEntities().size());
	}

}