package ATSSG;
import java.util.Collection;

public class Building extends Entity {
	
	//Variables
	protected BuildingType type;
	protected int resourceProgress;
	protected int constructionProgress;
	protected UnitType constructionGoal;
	
	//Constructors
	
	//Methods
	public boolean canBuild(UnitType type){
		return false;
	}
	
	public Collection<Cell> validConstructionSquares(UnitType type){
		return null;
	}
	
	public boolean build(UnitType type){
		return false;
	}

}
