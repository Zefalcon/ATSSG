package ATSSG.Entities;

import ATSSG.Cell;
import ATSSG.Player.Player;
import ATSSG.Script.Framework.Script;
import ATSSG.Script.Framework.ScriptError;
import ATSSG.Actions.*;
import ATSSG.Enums.CommandType;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;

public abstract class Entity {
	
	//Variables
	protected int hitPoints;
	protected Player owner;
	protected Cell containingCell;
	protected Script currentScript = null;
	protected Action currentAction = null;
	protected List<CommandType> allowedCommands;
	protected BufferedImage image;
	protected BufferedImage hImage;
	protected Icon icon;
	protected String path;
	protected final int entity_id;
	protected static int next_id = 0;

	//Constructor
	public Entity(int hp, Player player, Cell currentCell, String path){
		hitPoints = hp;
		owner = player;
		containingCell = currentCell;
		currentScript = new Script(this);
		currentAction = null;
		this.path = path;
		try {
			this.image = ImageIO.read(new File(path));
			this.hImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error fetching an entity image");
		}
		icon = null;
		allowedCommands = new ArrayList<CommandType>();
		if (player != null) player.addEntity(this);
		if (currentCell != null) currentCell.addOccupyingEntity(this);
		entity_id = next_id;
		next_id++;
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
		return (currentScript != null) && (currentScript.getLines().getLines().size() != 0);
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
	
	public void updateHealthyImage() {
		BufferedImage background = getHealthyImage();
		try {
			BufferedImage healthBlank = ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoHealthbarBlank.png").toString()));
			BufferedImage health = ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoHealthbar.png").toString()));
			background.getGraphics().drawImage(healthBlank, 19, 80, null);
			if (this instanceof Unit) {
				Unit unit = (Unit) this;
				double healthFrac = (double) unit.getHitPoints() / (double) unit.getType().maxHP;
				int healthWidth = (int) (healthFrac * health.getWidth());
				background.getGraphics().drawImage(health, 19, 80, 19 + healthWidth, 80 + health.getHeight(),
						0, 0, healthWidth, health.getHeight(), null);
			} else {
				//reference is a building, which is not implemented currently
			}
		} catch (IOException e) {
			System.out.println("Error fetching the healthbar image.");
		}
	}
	
	public Cell getContainingCell() {return containingCell;}
	public void setContainingCell(Cell location) {containingCell = location;}
	public Player getOwner() {return owner;}
	public Collection<CommandType> getAllowedCommands(){return allowedCommands;}
	public BufferedImage getImage() {return image;}
	public BufferedImage getHealthyImage() {return hImage;}
	public void setIcon(Icon icon) {this.icon = icon;}
	public Icon getIcon() {return icon;}
	public int getId() {return entity_id;}
	public static int getNextId() {return next_id;}
	public int getHitPoints() {return hitPoints;}
	
	public void setHitPoints(int h){this.hitPoints = h;}
	public Script getCurrentScript(){
		return currentScript;
	}
	public void setScript(String wad){
		this.currentScript = new Script(this, wad);
	}

}