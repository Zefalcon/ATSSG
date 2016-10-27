package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

import AI.AIPlayer;

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
		players.add(new Player());
		players.add(new AIPlayer(new Hashtable<RCommodityType, Integer>(), AI_ents, this));
		
		for(int i = 3; i < 8; i++){
			Entity s = new Entity();
			AI_ents.add(s);
			all_cells[3][i].getOccupyingEntities().add(s);
		}
		
		for(int i = 3; i < 8; i++){
			Entity s = new Entity();
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

}
