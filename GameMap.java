package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIConfig;
import ATSSG.Player.AI.AIPlayer;

import java.io.File;
import java.io.IOException;

public class GameMap {
	
	//Variables
	protected Cell[][] all_cells;
	protected List<Player> players;
	
	private static Map<Character, TerrainType> terrain_lookup = new HashMap<Character, TerrainType>();
	private static Map<String, UnitType> unit_lookup = new HashMap<String, UnitType>();
	
	public GameMap(){
		try{
			File f = new File("C:/Users/TomShkurti/Desktop/swengineering_prime/ATSSG/src/Maps/5v5.map");
			GameMap tmp = new GameMap(f);
			this.all_cells = tmp.all_cells;
			this.players = tmp.players;
		}
		catch(IOException e){
		}
	}
	
	
	
	//Constructor
	public GameMap(File toLoad) throws IOException{
		
		//flag These should really be moved ANYWHERE other than here...
		terrain_lookup.put(new Character('g'), TerrainType.GRASS);
		unit_lookup.put("soldier", UnitType.Soldier);
		
		System.out.println("Constructing game map.");
		
		Scanner s_tmp = new Scanner(toLoad);
		String map_str = s_tmp.useDelimiter("\\Z").next().replaceAll("\\s+", "");
		s_tmp.close();
		
		String name_stripped = map_str.substring(map_str.indexOf("---") + 3);
		int size_x = Integer.parseInt(name_stripped.substring(0, name_stripped.indexOf('x')));
		int size_y = Integer.parseInt(name_stripped.substring(name_stripped.indexOf('x') + 1, name_stripped.indexOf(':')));
		all_cells = new Cell[size_x][size_y];
		
		int ai_count = Integer.parseInt(name_stripped.substring(name_stripped.indexOf(':') + 1, name_stripped.indexOf("---")));
		players = new LinkedList<Player>();
		//The human is player zero.
		Player human = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), this);
		players.add(human);
		for(int i = 0; i < ai_count; i++){
			players.add(new AIPlayer(
					new Hashtable<RCommodityType, Integer>(),
					new ArrayList<Entity>(),
					this, 
					new AIConfig(AIConfig.AttackMode.CLOSEST, -5.1)
			));
		}
		
		String terrain_plus = name_stripped.substring(name_stripped.indexOf("---") + 3);
		String terrain_only = terrain_plus.substring(0, terrain_plus.indexOf("---"));
		
		for(int x = 0; x < size_x; x++){
			for(int y = 0; y < size_y; y++){
				all_cells[x][y] = new Cell(
						terrain_lookup.get(terrain_only.charAt(x * size_x + y)),
						null,
						this,
						x,
						y
				);
			}
		}
		
		String unit_list = terrain_plus.substring(terrain_plus.indexOf("---") + 3);
		int last_ind = unit_list.indexOf(';');
		while(last_ind != -1){
			String unit_string = unit_list.substring(0, last_ind);
			
			int dash = unit_string.indexOf('-');
			int at = unit_string.indexOf('@');
			int comma = unit_string.indexOf(',');
			
			UnitType ut = unit_lookup.get(unit_string.substring(0, dash));
			String pi = unit_string.substring(dash + 1, at);
			int lx = Integer.parseInt(unit_string.substring(at + 1, comma));
			int ly = Integer.parseInt(unit_string.substring(comma + 1));
			
			if(pi.equals("h")){
				new Unit(ut, human, all_cells[ly][lx]);
			}
			else{
				new Unit(ut, players.get(Integer.parseInt(pi)), all_cells[ly][lx]);
			}
			
			unit_list = unit_list.substring(last_ind + 1);
			last_ind = unit_list.indexOf(';');
		}
			
		//all_cells = new Cell[10][10];
		//for(int x = 0; x < 10; x++){
			//for(int y = 0; y < 10; y++){
				//all_cells[x][y] = new Cell(TerrainType.GRASS, null, this, x, y);
			//}
		//}
		
		//players = new LinkedList<Player>();
		//Player human = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), this);
		//Player ai = new AIPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(), this, 
		//		new AIConfig(AIConfig.AttackMode.CLOSEST, -5.1));
		//players.add(human);
		//players.add(ai);

		/*for(int i = 3; i < 8; i++){
			Unit s = new Unit(UnitType.Soldier, human, all_cells[3][i]);
		}
		
		for(int i = 3; i < 8; i++){
			Unit s = new Unit(UnitType.Soldier, players.get(1), all_cells[7][i]);
		}*/
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
