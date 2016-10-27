package ATSSG;

public class BuilderUnit extends Unit {
	
	int constructionProgress
	BuildingType constructionGoal
	
	//Methods
	public boolean canBuild(BuildingType type){
		return false;
	}
	
	public boolean validConstructionSquare(BuildingType type){
		return false;
	}
	
	public boolean build(BuildingType type){
		return false;
	}
}
