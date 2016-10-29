package ATSSG.Entities;

import ATSSG.Button;
import ATSSG.Cell;
import ATSSG.CommandButton;
import ATSSG.IdleButton;
import ATSSG.UnitButton;
import ATSSG.Player.Player;
import ATSSG.Script.Script;
import ATSSG.Script.ScriptButton;
import ATSSG.Actions.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Icon;

public abstract class Entity {
	
	//Variables
	protected int hitPoints;
	public int getHitPoints() {
		return hitPoints;
	}
	protected Player owner;
	protected Cell containingCell;
	protected Script currentScript = null;
	protected Action currentAction = null;
	protected Collection<CommandButton> allowedCommands;
	protected Icon image;
	protected UnitButton button;

	//Constructor
	public Entity(int hp, Player player, Cell currentCell){
		hitPoints = hp;
		owner = player;
		containingCell = currentCell;
		currentScript = null;
		currentAction = null;
		image = null;
		button = null;
		allowedCommands = new ArrayList<CommandButton>();
		if (player != null) player.addEntity(this);
		if (currentCell != null) currentCell.addOccupyingEntity(this);
	}
	
	//Methods
	public void tickTurn(){
		if(currentAction!=null){
			executeAction();
		}
		else if(currentScript!=null){
			executeScript();
		}
		else{
			//Do nothing
		}
	}

	public void doDamage(int damage){
		hitPoints-=damage;
		if(hitPoints<=0){
			kill();
		}
	}
	
	public void kill(){
		hitPoints = 0;
		if(containingCell != null){
			containingCell.removeEntity(this);
		}
		containingCell = null;
		currentScript = null;
		currentAction = null;
		if(owner != null){
			owner.removeEntity(this);
		}
		owner = null;
	}
	
	public boolean scripted(){
		return currentScript!=null;
	}
	
	public boolean actionQueued(){
		return currentAction != null;
	}
	
	public boolean busy(){
		//TODO
		return false;
	}
	
	public void executeScript(){
		//TODO
	}
	
	public void executeAction(){
		if (currentAction != null) {
			currentAction.execute();
			currentAction=null;
		}
	}
	
	public void setAction(Action act) {
		currentAction = act;
	}
	
	public Cell getContainingCell() {return containingCell;}
	public void setContainingCell(Cell location) {containingCell = location;}
	public Player getOwner() {return owner;}
	public Collection<CommandButton> getAllowedCommands(){return allowedCommands;}
	public Icon getImage() {return image;}
	public UnitButton getButton() {return button;}

}