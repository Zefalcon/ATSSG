package ATSSG.Player.AI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ATSSG.Entities.Entity;
import ATSSG.Cell;
import ATSSG.GameMap;
import ATSSG.RCommodityType;
import ATSSG.Entities.Unit;
import ATSSG.Player.Player;

public class AIPlayer extends Player {
	
	//Variables
	protected Map<Entity, MetaAction> plannedActions;
	public Map<Entity, MetaAction> getPlannedActions() {
		return plannedActions;
	}

	protected Map<Integer, Boolean> featuresUsed;
	protected AIConfig mode;
	
	public AIPlayer(Map<RCommodityType, Integer> startingResources, List<Entity> starting_entities, GameMap map, AIConfig config) {
		resources = startingResources;
		owned_entities = starting_entities;
		containing_map = map;
		plannedActions = new HashMap<Entity, MetaAction>();
		mode = config;
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
		Collections.shuffle(owned_entities, new Random(System.nanoTime()));
		for (Entity e: owned_entities) {
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
		if (enemies == null || enemies.isEmpty()) {
			plannedActions.put(unit, new IdleMeta());
			return;
		}
		Entity target = null;
		switch(mode.target_style){
			case CLOSEST:
				Collections.shuffle(enemies, new Random(System.nanoTime()));
				double lowest = Double.POSITIVE_INFINITY;
				for (Entity enemy: enemies) {
					int shared = 0;
					if (mode.focus_bonus != 0) {
						for (Entity other: plannedActions.keySet()) {
							MetaAction act = plannedActions.get(other);
							if (act instanceof AttackMeta && ((AttackMeta) act).getTarget() == enemy) {
								shared++;
							}
						}
					}
					double distance = Cell.distance(unit.getContainingCell(), enemy.getContainingCell()) - shared*mode.focus_bonus;
					if (distance < lowest) {
						target = enemy;
						lowest = distance;
					}
				}
				break;
			case RANDOM:
			default:
				target = enemies.get(new Random().nextInt(enemies.size()));
		}
		plannedActions.put(unit, new AttackMeta(unit, target));
	}
	
	@Override
	public void executeAll(){
		System.out.println("AI is planning");
		if (owned_entities == null || owned_entities.isEmpty()) {
			this.kill();
			return;
		}
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
	
	@Override
	public void removeEntity(Entity e) {
		if (plannedActions.containsKey(e)) {
			plannedActions.remove(e);
		}
		super.removeEntity(e);
	}

}