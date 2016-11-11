package ATSSG.Player;
import java.util.Map;
import java.util.Collection;

import ATSSG.Entities.Entity;
import ATSSG.GameMap;
import ATSSG.RCommodityType;

public abstract class Player {
	
	//Variables
	protected Map<RCommodityType, Integer> resources;
	protected Collection<Entity> owned_entities;
	protected GameMap containing_map;
	
	//Constructors

	//Methods
	public void kill(){
		if (owned_entities != null) {
			for (Object entity: owned_entities.toArray()) {
				((Entity) entity).kill();
			}
			owned_entities = null;
		}
		resources = null;
		if (containing_map != null) containing_map.removePlayer(this);
		containing_map = null;
	}
	
	public abstract void executeAll();
	
	public Collection<Entity> getEntities() {
		return owned_entities;
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
		if (owned_entities != null && owned_entities.contains(e)) owned_entities.remove(e);
	}
	
	public void addEntity(Entity e) {
		owned_entities.add(e);
	}

}