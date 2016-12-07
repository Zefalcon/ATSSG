package ATSSG.Entities;
import ATSSG.Cell;
import ATSSG.Player.Player;
import ATSSG.Script.Framework.Script;
import ATSSG.Script.Framework.ScriptError;
import ATSSG.Actions.*;
import ATSSG.Enums.CommandType;

import java.awt.Image;
import java.io.IOException;
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
	protected Icon cardIcon;
	protected final int entity_id;
	protected static int next_id = 0;

	//Constructor
	public Entity(int hp, Player player, Cell currentCell, Image image){
		hitPoints = hp;
		owner = player;
		containingCell = currentCell;
		currentScript = new Script(this);
		currentAction = null;
		this.image = image;
		icon = null;
		allowedCommands = new ArrayList<CommandType>();
		if (player != null) player.addEntity(this);
		if (currentCell != null) currentCell.addOccupyingEntity(this);
		entity_id = next_id;
		next_id++;
	}
	
	//Methods
	public void tickTurn() throws IOException{
		if(currentAction!=null){
			executeAction();
		}
		else if(currentScript!=null){
			System.out.println("Executing script");
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
		return currentScript != null;
	}
	
	public boolean actionQueued(){
		return currentAction != null;
	}
	
	public boolean busy(){
		//TODO
		return false;
	}
	
	public void executeScript(){
		if (currentScript != null) {
			try {
				currentScript.execute();
			} catch (ScriptError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void executeAction() throws IOException{
		if (currentAction != null) {
			currentAction.execute();
			currentAction=null;
		} else  {
			executeScript();
		}
	}
	
	public void setAction(Action act) {
		if (!allowedCommands.contains(act.getType())) {
			throw new RuntimeException("Illegal action type for entity: "+act.getType());
		}
		currentAction = act;
	}
	
	public Cell getContainingCell() {return containingCell;}
	public void setContainingCell(Cell location) {containingCell = location;}
	public Player getOwner() {return owner;}
	public Collection<CommandType> getAllowedCommands(){return allowedCommands;}
	public Image getImage() {return image;}
	public void setIcon(Icon icon) {this.icon = icon;}
	public Icon getIcon() {return icon;}
	public void setCardIcon(Icon cicon) {this.cardIcon = cicon;}
	public Icon getCardIcon() {return cardIcon;}
	public int getId() {return entity_id;}
	public static int getNextId() {return next_id;}
	
	public void setHitPoints(int h){this.hitPoints = h;}
	public Script getCurrentScript(){
		return currentScript;
	}
	public void setScript(String wad){
		this.currentScript = new Script(this, wad);
	}

}