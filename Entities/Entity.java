package ATSSG.Entities;
import ATSSG.Cell;
import ATSSG.CommandType;
import ATSSG.Player.Player;
import ATSSG.Script.Script;
import ATSSG.Actions.*;

import java.awt.Image;
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
	protected Collection<CommandType> allowedCommands; //Flag further review on whether this should be a collection. There is a corresponding collection at MainMap line 107
	protected Image image;
	protected Icon icon;

	//Constructor
	public Entity(int hp, Player player, Cell currentCell, Image image){
		hitPoints = hp;
		owner = player;
		containingCell = currentCell;
		currentScript = null;
		currentAction = null;
		this.image = image;
		icon = null;
		allowedCommands = new ArrayList<CommandType>();
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
	public Collection<CommandType> getAllowedCommands(){return allowedCommands;}
	public Image getImage() {return image;}
	public void setIcon(Icon icon) {this.icon = icon;}
	public Icon getIcon() {return icon;}

}