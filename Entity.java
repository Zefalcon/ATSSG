package ATSSG;

public abstract class Entity {
	
	//Variables
	protected int hitPoints;
	protected Player owner;
	protected Cell containingCell;
	protected Script currentScript;
	protected Action currentAction;
	
	//Methods
	public void tickTurn(){
		
	}
	
	public void kill(){
		
	}
	
	public boolean scripted(){
		return false;
	}
	
	public boolean actionQueued(){
		return false;
	}
	
	public boolean busy(){
		return false;
	}
	
	public void executeScript(){
		
	}
	
	public void executeAction(){
		
	}

}
