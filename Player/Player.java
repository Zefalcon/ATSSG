package ATSSG.Player;
import java.util.Map;
import java.util.Collection;

import ATSSG.Entities.Entity;
import ATSSG.GameMap;
import ATSSG.RCommodityType;

public abstract class Player {
	
	//Variables
	protected Map<RCommodityType, Integer> resources;
	protected Collection<Entity> all_entities;
	protected GameMap containing_map;
	
	//Constructors

	//Methods
	public void kill(){
		for (Object entity: all_entities.toArray()) {
			((Entity) entity).kill();
		}
		resources = null;
		if (containing_map != null) containing_map.removePlayer(this);
		containing_map = null;
		all_entities = null;
	}
	
	public abstract void executeAll();
	
	public Collection<Entity> getEntities() {
		return all_entities;
	}
	
	public Map<RCommodityType, Integer> getResources() {
		return resources;
	}

	public void setResources(Map<RCommodityType, Integer> resources) {
		this.resources = resources;
	}

	public GameMap getContaining_map() {
		return containing_map;
	}
	
	public void removeEntity(Entity e) {
		if (all_entities != null) all_entities.remove(e);
		if (containing_map !=null) containing_map.removeEntity(e);
	}
	
	public void addEntity(Entity e) {
		all_entities.add(e);
	}

}
