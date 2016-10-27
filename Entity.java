package ATSSG;

import ATSSG.Player.Player;

public abstract class Entity {
	
	//Variables
	protected int hitPoints;
	protected Player owner;
	protected Cell containingCell;
	protected Script currentScript;
	protected Action currentAction = null;
	
	//Methods
	public void tickTurn(){
		
	}
	
	public void kill(){
		
	}
	
	public boolean scripted(){
		return false;
	}
	
	public boolean actionQueued(){
		return currentAction != null;
	}
	
	public boolean busy(){
		return false;
	}
	
	public void executeScript(){
		
	}
	
	public void executeAction(){
		
	}
	
	public void setAction(Action act) {
		currentAction = act;
	}
	
	public Cell getContainingCell() {return containingCell;}
	public Player getOwner() {return owner;}

}
