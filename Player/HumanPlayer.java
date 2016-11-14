package ATSSG.Player;

import java.util.List;
import java.util.Map;

import ATSSG.Entities.Entity;
import ATSSG.GameMap;
import ATSSG.RCommodityType;

public class HumanPlayer extends Player {

	public HumanPlayer(Map<RCommodityType, Integer> startingResources, List<Entity> starting_entities, GameMap map) {
		resources = startingResources;
		owned_entities = starting_entities;
		containing_map = map;
	}
	
	@Override
	public void executeAll() {
		if (owned_entities == null) return;
		// TODO Execute the script
		for (Entity e: owned_entities) {
			e.executeAction();
		}
	}

}