package ATSSG;

public interface BuilderUnit {
	
	//Not sure what to do with variables, since Interfaces shouldn't have them as a general rule
	//int constructionProgress
	//BuildingType constructionGoal
	
	//Methods
	public boolean canBuild(BuildingType type);
	
	public boolean validConstructionSquare(BuildingType type);
	
	public void build(BuildingType type);
}
