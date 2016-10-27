package ATSSG;
import java.util.Collection;

public class Unit extends Entity {
	
	//Variables
	protected UnitType type;
	
	//Constructors
	public Unit(UnitType t){
		type = t;
	}
	//Methods
	public boolean canAttack(Entity target){
		return Cell.distance(getContainingCell(), target.getContainingCell()) < type.aRange;
	}

	public boolean attack(Entity target){
		//If within range, hit
		if(canAttack(target)){
			target.doDamage((type.aDamage));
			return true;
		}
		else{
			return false;
		}
	}

	public boolean canMoveTo(Cell destination){
		return Cell.distance(getContainingCell(), destination) <= type.maxMoves;
	}
	
	public boolean move(Cell destination){
		if(canMoveTo(destination)){
			getContainingCell().removeEntity(this);
			destination.addOccupyingEntity(this);
			setContainingCell(destination);
		}
		return false;
	}
	
	public UnitType getType() {return type;}

	public boolean build(BuildingType type){
		return false; //Units cannot build unless they are builder units
	}

	public boolean deposit(Building drop){
		return false; //Only harvesters can drop stuff
	}

	public boolean harvest(ResourceItem resource){
		return false; //Only harvesters can harvest stuff
	}

}
