package ATSSG.Player.AI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ATSSG.Entity;
import ATSSG.GameMap;
import ATSSG.RCommodityType;
import ATSSG.Unit;
import ATSSG.Player.Player;

public class AIPlayer extends Player {
	
	//Variables
	protected Map<Entity, MetaAction> plannedActions;
	public Map<Entity, MetaAction> getPlannedActions() {
		return plannedActions;
	}

	protected Map<Integer, Boolean> featuresUsed;
	
	public AIPlayer(Map<RCommodityType, Integer> startingResources, Collection<Entity> starting_entities, GameMap map) {
		resources = startingResources;
		all_entities = starting_entities;
		containing_map = map;
		plannedActions = new HashMap<Entity, MetaAction>();
	}
	
	//Methods
	public void forceReplan(){
		plannedActions = new HashMap<Entity, MetaAction>();
	}
	
	protected void planAllActions() {
		List<Entity> enemies = new ArrayList<Entity>();
		for (Player p : containing_map.getPlayers()) {
			if (p == this) continue;
			enemies.addAll(p.getEntities());
		}
		for (Entity e: all_entities) {
			planAction(e, enemies);
		}
	}
	
	protected void planAction(Entity entity, List<Entity> enemies) {
		if (plannedActions.containsKey(entity)) {
			if (plannedActions.get(entity).isDone()) {
				plannedActions.remove(entity);
			} else {
				return;
			}
		}
		if (Unit.class.isInstance(entity)) { //TODO: replace with varied choices for more features
			planAttack((Unit) entity, enemies);
		} else {
			plannedActions.put(entity, new IdleMeta());
		}
	}
	
	protected void planAttack(Unit unit, List<Entity> enemies) {
		//TODO: replace with intelligent choice
		Entity target = enemies.get(new Random().nextInt(enemies.size()));
		plannedActions.put(unit, new AttackMeta(unit, target));
	}
	
	@Override
	public void executeAll(){
		planAllActions();
		for (Entity e: plannedActions.keySet()) {
			e.setAction(plannedActions.get(e).nextAction());
			e.executeAction();
		}
	}
	
	@Override
	public void kill(){
		super.kill();
		plannedActions = null;
	}

}


