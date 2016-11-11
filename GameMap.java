package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;

import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;

import java.io.File;

public class GameMap {
	
	//Variables
	protected Cell[][] all_cells;
	protected Collection<Player> players;
	
	//Constructor
	public GameMap(){
		all_cells = new Cell[10][10];
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				all_cells[x][y] = new Cell(TerrainType.GRASS, null, this, x, y);
			}
		}
		
		players = new LinkedList<Player>();
		Player human = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), this);
		Player ai = new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), this);
		players.add(human);
		players.add(ai);

		for(int i = 3; i < 8; i++){
			Unit s = new Unit(UnitType.Soldier, human, all_cells[3][i]);
		}
		
		for(int i = 3; i < 8; i++){
			Unit s = new Unit(UnitType.Soldier, ai, all_cells[7][i]);
		}
	}
	
	public GameMap(File toLoad){
		
	}
	
	//Methods
	public Cell getCell(int x, int y){
		if(x < 0 || x >= all_cells.length){
			return null;
		}
		if(y < 0 || y >= all_cells[1].length){
			return null;
		}
		return all_cells[x][y];
	}
	
	public Collection<Player> getPlayers() {
		return players;
	}
	
	public Collection<Entity> getEntities(){
		Collection<Entity> all_entities = new ArrayList<Entity>();
		for (Player p : players) {
			all_entities.addAll(p.getEntities());
		}
		return all_entities;
	}

	public void removePlayer(Player toRemove){
		if(players.contains(toRemove)){
			players.remove(toRemove);
		}
	}
	
	public Cell[][] getCells() {
		return all_cells;
	}

}