package ATSSG;
import java.util.Collection;

public class BuilderUnit extends Unit {
	
	int constructionProgress;
	BuildingType constructionGoal;
	Collection<BuildingType> buildable;
	
	public BuilderUnit(BUnitType t){
		super(t.baseUnit);
	}
	
	//Methods
	public boolean canBuild(BuildingType type){
		if(buildable.contains(type)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean validConstructionSquare(BuildingType type){
		TerrainType square = getContainingCell().getTerrainType();
		switch(square){
			case GRASS:
				return true;
			default:
				return false;
		}
	}
	
	public boolean build(BuildingType type){
		if(canBuild(type) && validConstructionSquare(type)){
			return getContainingCell().addOccupyingEntity(new Building(type));
		}
		else{
			return false;
		}
	}
}
