package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.HumanPlayer;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIConfig;
import ATSSG.Player.AI.AIPlayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class GameMap{
	
	//Variables
	protected Cell[][] all_cells;
	protected List<Player> players;
	
	private static Map<Character, TerrainType> terrain_lookup = new InlineMap<Character, TerrainType>()
		.returnPut(new Character('v'), TerrainType.VOID)
		.returnPut(new Character('g'), TerrainType.GRASS)
		.returnPut(new Character('r'), TerrainType.ROUGH_TERRAIN)
		.returnPut(new Character('m'), TerrainType.MOUNTAIN)
	;
	
	private static Map<String, UnitType> unit_lookup = new InlineMap<String, UnitType>()
		.returnPut("soldier", UnitType.Soldier)
		.returnPut("archer", UnitType.Archer)
		.returnPut("tower", UnitType.Guardtower)
		.returnPut("seige", UnitType.SeigeEngine)
		.returnPut("mountaineer", UnitType.Mountaineer)
		.returnPut("cavalry", UnitType.Cavalry)
	;
	
	private static HumanPlayer human = new HumanPlayer(new Hashtable<RCommodityType, Integer>(), new ArrayList<Entity>(0), null);
	
	public GameMap(){
		this.all_cells = null;
		this.players = null;
		human.setGameMap(this);
	}
	
	//Constructor
	public GameMap(File toLoad) throws IOException{
		
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
		human.setGameMap(this);
		players.add(human);
		AIPlayer cp;
		for(int i = 0; i < ai_count; i++){
			cp = new AIPlayer(
				new Hashtable<RCommodityType, Integer>(),
				new ArrayList<Entity>(),
				ImageIO.read(new File((Paths.get("src/ATSSG/Art/AIColors1.png").toString()))),
				this, 
				new AIConfig(AIConfig.AttackMode.CLOSEST, -5.1));
			players.add(cp);
		}
		
		String terrain_plus = name_stripped.substring(name_stripped.indexOf("---") + 3);
		String terrain_only = terrain_plus.substring(0, terrain_plus.indexOf("---"));
		
		for(int x = 0; x < size_x; x++){
			for(int y = 0; y < size_y; y++){
				all_cells[x][y] = new Cell(
						terrain_lookup.get(terrain_only.charAt(y * size_x + x)),
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
				new Unit(ut, human, all_cells[lx][ly]);
			}
			else{
				new Unit(ut, players.get(Integer.parseInt(pi)), all_cells[lx][ly]);
			}
			
			unit_list = unit_list.substring(last_ind + 1);
			last_ind = unit_list.indexOf(';');
		}
	}
	
	//Methods
	
	public void update(String fpath) {
		try {
			GameMap tmp = new GameMap(new File(fpath));
			this.all_cells = tmp.all_cells;
			this.players = tmp.players;
		} catch (IOException e) {
			//Flag Needs handling (gracefully)
		}
	}
		
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
	
	public ArrayList<Entity> getEntities(){
		ArrayList<Entity> all_entities = new ArrayList<Entity>();
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

	public static HumanPlayer getHuman() {return human;}

	public byte[] Save() {
		byte[] dim_x = Saveable.itob(all_cells.length);
		byte[] dim_y = Saveable.itob(all_cells[0].length);
		byte[] player_count = Saveable.itob(players.size() - 1);
		
		byte[][] terrain_tmp = new byte[all_cells.length * all_cells[0].length][Saveable.ict];
		for(int x = 0; x < all_cells.length; x++){
			for(int y = 0; y < all_cells[x].length; y++){
				byte[] tmp = Saveable.itob(
					all_cells[x][y].getTerrainType().ordinal()
				);
				for(int z = 0; z < Saveable.ict; z ++){
					terrain_tmp[x * all_cells[0].length + y][z] = tmp[z];
				}
			}
		}
		byte[] terrain = new byte[terrain_tmp.length * terrain_tmp[0].length];
		for(int a = 0; a < terrain_tmp.length; a++){
			for(int b = 0; b < terrain_tmp[0].length; b++){
				terrain[a * terrain_tmp[0].length + b] = terrain_tmp[a][b];
			}
		}
		
		List<Entity> ulist = this.getEntities();
		byte[][][] units_tmp = new byte[ulist.size()][5][];
		for(int i = 0; i < ulist.size(); i++){
			Unit u = (Unit)ulist.get(i);
			units_tmp[i][0] = Saveable.itob(u.getContainingCell().getX());
			units_tmp[i][1] = Saveable.itob(u.getContainingCell().getY());
			units_tmp[i][2] = Saveable.itob(u.getType().ordinal());
			units_tmp[i][3] = Saveable.itob(u.getHitPoints());
			if(u.getOwner().equals(human)){
				units_tmp[i][4] = Saveable.itob(0);
			}else{
				units_tmp[i][4] = Saveable.itob(players.indexOf(u.getOwner()));
			}
		}
		byte[] units = new byte[units_tmp.length * units_tmp[0].length * units_tmp[0][0].length];
		for(int a = 0; a < units_tmp.length; a++){
			for(int b = 0; b < units_tmp[0].length; b++){
				for(int c = 0; c < units_tmp[0][0].length; c++){
					units[a * units_tmp[0].length + b * units_tmp[0][0].length + c] = units_tmp[a][b][c];
				}
			}
		}
		
		//Serialize everything.
		byte[] serial = new byte[
		                         dim_x.length + dim_y.length + player_count.length
		                         + terrain.length + units.length
		                         ];
		int sp = 0;
		for(int i = 0; i < dim_x.length; i++){
			serial[i + sp] = dim_x[i];
		}
		sp = sp + dim_x.length;
		for(int i = 0; i < dim_y.length; i++){
			serial[i + sp] = dim_y[i];
		}
		sp = sp + dim_y.length;
		for(int i = 0; i < player_count.length; i++){
			serial[i + sp] = player_count[i];
		}
		sp = sp + player_count.length;
		for(int i = 0; i < terrain.length; i++){
			serial[i + sp] = terrain[i];
		}
		sp = sp + terrain.length;
		for(int i = 0; i < units.length; i++){
			serial[i + sp] = units[i];
		}
		
		return serial;
		
	}
}
