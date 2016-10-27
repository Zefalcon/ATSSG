package ATSSG.Player;

import java.util.Collection;
import java.util.Map;

import ATSSG.Entity;
import ATSSG.GameMap;
import ATSSG.RCommodityType;

public class HumanPlayer extends Player {

	public HumanPlayer(Map<RCommodityType, Integer> startingResources, Collection<Entity> starting_entities, GameMap map) {
		resources = startingResources;
		all_entities = starting_entities;
		containing_map = map;
	}
	
	@Override
	public void executeAll() {
		if (all_entities == null) return;
		// TODO Execute the script
		for (Entity e: all_entities) {
			e.executeAction();
		}
	}

}
