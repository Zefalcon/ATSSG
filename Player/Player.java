package ATSSG.Player;

import java.util.List;
import java.util.Map;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;

import ATSSG.Entities.Entity;
import ATSSG.Enums.RCommodityType;
import ATSSG.GameMap;

public abstract class Player {
	
	//Variables
	protected Map<RCommodityType, Integer> resources;
	protected List<Entity> owned_entities;
	protected GameMap containing_map;
	protected Image colors;
	protected Color visID;
	
	//Constructors
	public Player(Map<RCommodityType, Integer> startingResources, List<Entity> starting_entities, GameMap map) {
		resources = startingResources;
		owned_entities = starting_entities;
		containing_map = map;
		if (containing_map != null) containing_map.getPlayers().add(this);
	}
	
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
		e.getImage().getGraphics().drawImage(colors, 40, 40, null);
		e.getHealthyImage().getGraphics().drawImage(colors, 40, 40, null);
		owned_entities.add(e);
	}
	
	public Color getVisID() {
		return visID;
	}
}