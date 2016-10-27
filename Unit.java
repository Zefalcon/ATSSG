package ATSSG;
import java.util.Collection;

public class Unit extends Entity {
	
	//Variables
	protected UnitType type;
	
	//Constructors
	
	//Methods
	public Collection<Entity> validTargets(){
		return null;
	}
	
	public boolean attack(Entity target){
		return false;
	}
	
	public Collection<Cell> validLocations(){
		return null;
	}
	
	public boolean move(Cell destination){
		return false;
	}
	
	public UnitType getType() {return type;}

	public boolean build(BuildingType type){
		return false; //Units cannot build unless they are builder units
	}

	public boolean deposit(Building drop){
		return false;
	}

	public boolean harvest(ResourceItem resource){
		return false;
	}

}
