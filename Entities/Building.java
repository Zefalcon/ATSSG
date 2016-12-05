package ATSSG.Entities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ATSSG.*;
import ATSSG.Enums.BuildingType;
import ATSSG.Enums.UnitType;
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
		super(type.maxHP, player, location, type.getImage());
		this.type = type;
		buildable = new ArrayList<UnitType>();
		//allowedCommands.add(new ConstructButton(null, "Construct"));
	}
	
	//Methods
	public void addBuildableUnit(UnitType type){
		buildable.add(type);
	}
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
	
	public boolean build(UnitType type, Cell location) throws IOException {
		if(canBuild(type) && validConstructionSquares(type).contains(location)){
			return location.addOccupyingEntity(new Unit(type, owner, location));
		}
		else{
			return false;
		}
	}

}
