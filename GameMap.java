package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;

import java.io.File;

public class GameMap {
	
	//Variables
	protected Cell[][] all_cells;
	protected Collection<Player> players;
	protected Collection<Entity> entities;
	
	//Constructor
	public GameMap(){
		all_cells = new Cell[10][10];
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				all_cells[x][y] = new Cell(TerrainType.GRASS, null, this, x, y);
			}
		}
		Collection<Entity> AI_ents = new LinkedList<Entity>();
		Collection<Entity> human_ents = new LinkedList<Entity>();
		
		players = new LinkedList<Player>();
		Player human = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), human_ents, this);
		Player ai = new AIPlayer(new Hashtable<RCommodityType, Integer>(), AI_ents, this);
		players.add(human);
		players.add(ai);


		for(int i = 3; i < 8; i++){
			Unit s = new Unit(UnitType.Soldier, human, all_cells[3][i]);
			AI_ents.add(s);
			all_cells[3][i].getOccupyingEntities().add(s);
		}
		
		for(int i = 3; i < 8; i++){
			Unit s = new Unit(UnitType.Soldier, ai, all_cells[7][i]);
			human_ents.add(s);
			all_cells[7][i].getOccupyingEntities().add(s);
		}
	}
	
	public GameMap(File toLoad){
		
	}
	
	//Methods
	public Cell getCell(int x, int y){
		if(x < 0 || x > all_cells.length){
			return null;
		}
		if(y < 0 || y > all_cells[1].length){
			return null;
		}
		return all_cells[x][y];
	}
	
	public Collection<Player> getPlayers() {
		return players;
	}
	
	public Collection<Entity> getEntities(){
		return entities;
	}

	public void removeEntity(Entity toRemove){
		if(entities.contains(toRemove)){
			entities.remove(toRemove);
		}
	}

	public void removePlayer(Player toRemove){
		if(players.contains(toRemove)){
			players.remove(toRemove);
		}
	}

}
