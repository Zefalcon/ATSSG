package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.io.File;

public class GameMap {
	
	//Variables
	protected Collection<Cell> all_cells;
	protected Collection<Player> players;
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
	
	public Collection<Player> getPlayers() {
		return new ArrayList<Player>(players);
	}

}
