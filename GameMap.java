package ATSSG;
import java.util.Collection;
import java.io.File;

public class GameMap {
	
	//Variables
	protected Collection<Cell> all_cells;
	protected Collection<Player> human_players;
	protected Collection<Player> ai_players;
	protected Collection<Entity> entities;
	
	//Constructor
	public GameMap(Collection<Cell> cells, Collection<Player> players, Collection<Player> ais, Collection<Entity> entities){
		
	}
	
	public GameMap(File toLoad){
		
	}
	
	//Methods
	public Cell getCell(int x, int y){
		//Returns cell at given coordinates
		return null;
	}

}
