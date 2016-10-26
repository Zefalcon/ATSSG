package ATSSG;
import java.util.Collection;

public class Cell {
	
	//Variables
	protected TerrainType terrainType;
	protected ResourceItem occupyingResource; //Was listed in design doc as just Resource; I assumed ResourceItem, could also be ResourceType
	protected Collection<Entity> occupyingEntities;
	protected GameMap containingMap;
	protected int x, y; //location, may want to turn into an inner class or something
	
	//Constructors
	
	//Methods
	public Collection<Cell> getAdjacent(){
		//Returns the 8 surrounding cells
		return null;
	}

	public TerrainType getTerrainType() {return terrainType;}
	public Collection<Entity> getOccupyingEntities() { return occupyingEntities;}
	public int getX() {return x;}
	public int getY() {return y;}
}
