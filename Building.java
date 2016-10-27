package ATSSG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ATSSG.Player.Player;

public class Building extends Entity {
	
	//Variables
	protected BuildingType type;
	protected int resourceProgress;
	protected int constructionProgress;
	protected UnitType constructionGoal;
	protected Collection<UnitType> buildable;
	
	//Constructors
	public Building(BuildingType type, Player player, Cell location){
		super(type.maxHP, player, location);
		this.type = type;
		allowedCommands.add(new ConstructButton(null, "Construct"));
	}
	
	//Methods
	public boolean canBuild(UnitType type){
		if(buildable.contains(type)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public Collection<Cell> validConstructionSquares(UnitType type){
		Iterator<Cell> iter = getContainingCell().getAdjacent().iterator();
		//Cell[] adjacent = getContainingCell().getAdjacent();
		//Collection<Cell> adjacent = getContainingCell().getAdjacent();
		Collection<Cell> valid = new ArrayList<Cell>();
		while (iter.hasNext()){
			Cell current = iter.next();
			switch (current.getTerrainType()){
				case GRASS:
					valid.add(current);
				default:
					valid.add(current);
			}
		}
		return valid;
	}
	
	public boolean build(UnitType type, Cell location){
		if(canBuild(type) && validConstructionSquares(type).contains(location)){
			return location.addOccupyingEntity(new Unit(type, owner, location));
		}
		else{
			return false;
		}
	}

}
