package ATSSG.Player.AI;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

import ATSSG.Entity;
import ATSSG.RCommodityType;
import ATSSG.Unit;
import ATSSG.UnitType;

public class testAIPlayer {

	public AIPlayer setUpAIPlayer() {
		return new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), null);
	}
	
	@Test
	public void testKill() {
		AIPlayer testPlayer = setUpAIPlayer();
		testPlayer.kill();
		assertNull(testPlayer.getPlannedActions());
	}
	
	@Test
	public void testForceReplan() {
		AIPlayer testPlayer = setUpAIPlayer();
		Unit u = new Unit(UnitType.Soldier);
		Entity enemy1 = new Unit(UnitType.Soldier);
		testPlayer.planAttack(u, Arrays.asList(enemy1));
		testPlayer.forceReplan();
		assert(testPlayer.getPlannedActions().isEmpty());
	}

	@Test
	public void testPlanAction() {
		AIPlayer testPlayer = setUpAIPlayer();
		Entity mine = new Unit(UnitType.Soldier);
		Entity enemy1 = new Unit(UnitType.Soldier);
		testPlayer.planAction(mine, Arrays.asList(enemy1));
		Map<Entity, MetaAction> actions = testPlayer.getPlannedActions();
		assert(actions.keySet().contains(mine));
		assert(MetaAction.class.isInstance(actions.get(mine)));
		
	}

	@Test
	public void testPlanAttack() {
		AIPlayer testPlayer = setUpAIPlayer();
		Unit u = new Unit(UnitType.Soldier);
		Entity enemy1 = new Unit(UnitType.Soldier);
		Entity enemy2 = new Unit(UnitType.Soldier);
		testPlayer.planAttack(u, Arrays.asList(enemy1));
		Map<Entity, MetaAction> actions = testPlayer.getPlannedActions();
		assert(actions.keySet().contains(u));
		assertEquals(u, ((AttackMeta)actions.get(u)).getAttacker());
		assertEquals(enemy1, ((AttackMeta)actions.get(u)).getTarget());
		testPlayer.forceReplan();
		testPlayer.planAttack(u, Arrays.asList(enemy1, enemy2));
		assert(actions.keySet().contains(u));		
		assertEquals(u, ((AttackMeta)actions.get(u)).getAttacker());
	}

}