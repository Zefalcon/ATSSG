package ATSSG;
import ATSSG.Entities.Entity;
import ATSSG.Enums.TerrainType;
import ATSSG.GUI.GooeyJButton;
import ATSSG.Player.Player;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell implements Comparable<Cell> {
	
	//Variables
	protected TerrainType terrainType;
	protected ResourceItem occupyingResource; //Was listed in design doc as just Resource; I assumed ResourceItem, could also be ResourceType
	protected Collection<Entity> occupyingEntities;
	protected GameMap containingMap;
	protected int x, y; //location, may want to turn into an inner class or something
	protected GooeyJButton view;
	protected Image[] terrIcons;
	protected int terrainFlavor;
	
	//Constructors
	public Cell(TerrainType t, ResourceItem r, GameMap m, int x_in, int y_in){
		this.x = x_in;
		this.y = y_in;
		this.terrainType = t;
		this.terrainFlavor = terrainType.getTerrainFlavor();
		this.terrIcons = terrainType.getImages(terrainFlavor);
		this.occupyingResource = r;
		this.containingMap = m;
		
		this.occupyingEntities = new ArrayList<Entity>(8);
		this.view = new GooeyJButton(null, this);
	}
	
	//Methods
	public void updateView(int iconW, int iconH) {
		this.terrIcons = terrainType.getImages(terrainFlavor);
		Icon icon;
		if (getOccupyingEntities().isEmpty()) {
			icon = new ImageIcon(terrIcons[0]);
		} else {
			Image[] entities = new Image[getOccupyingEntities().size()];
			Iterator<Entity> itr = getOccupyingEntities().iterator();
			for (int i = 0; i < entities.length; i++) {
				entities[i] = itr.next().getImage();
			}
			Image background = terrIcons[2];
			double iW = background.getWidth(null);
			double iH = background.getHeight(null);
			for (int j = 0; j < entities.length; j++) {
				background.getGraphics().drawImage(entities[j].getScaledInstance((int)(iW/Math.pow(1.3, j)), (int)(iH/Math.pow(1.3, j)), Image.SCALE_SMOOTH),
						(int)(iW-iW/Math.pow(1.3, j)), (int)(iH-iH/Math.pow(1.3, j)), null);
			}
			icon = new ImageIcon(background.getScaledInstance(iconW, iconH, Image.SCALE_SMOOTH));
		}
		this.view.setIcon(icon);
	}
	
	public void setActionListener(ActionListener actlis) {
		ActionListener[] ala = view.getActionListeners();
		for (ActionListener al : ala) {
			view.removeActionListener(al);
		}
		view.addActionListener(actlis);
	}
	
	public JButton getView() {
		return view;
	}
	
	//Note that this makes Cell inconsistent with equals.
	public int compareTo(Cell target) {
		int number = (10000 * target.getY() + target.getX())-(10000 * this.getY() + this.getX());
		return number / Math.abs(number);
	}
	
	public Collection<Cell> getAdjacent(){
		ArrayList<Cell> cell_list = new ArrayList<Cell>(8);
		GameMap m = this.containingMap;
		
		Cell top_left = m.getCell(x - 1, y - 1);
		if(top_left != null){
			cell_list.add(top_left);
		}
		Cell top_center = m.getCell(x, y - 1);
		if(top_center != null){
			cell_list.add(top_center);
		}
		Cell top_right = m.getCell(x + 1, y - 1);
		if(top_right != null){
			cell_list.add(top_right);
		}
		
		Cell center_left = m.getCell(x - 1, y);
		if(center_left != null){
			cell_list.add(center_left);
		}
		Cell center_right = m.getCell(x + 1, y);
		if(center_right != null){
			cell_list.add(center_right);
		}
		
		Cell bottom_left = m.getCell(x - 1, y + 1);
		if(bottom_left != null){
			cell_list.add(bottom_left);
		}
		Cell bottom_center = m.getCell(x, y + 1);
		if(bottom_center != null){
			cell_list.add(bottom_center);
		}
		Cell bottom_right = m.getCell(x + 1, y + 1);
		if(bottom_right != null){
			cell_list.add(bottom_right);
		}
		
		return cell_list;
		
	}

	public TerrainType getTerrainType() {return terrainType;}
	public Icon getTerrainDIcon() {return new ImageIcon(terrIcons[1]);}
	public Collection<Entity> getOccupyingEntities() { return occupyingEntities;}
	public GameMap getGameMap(){ return containingMap;}
	public ResourceItem getResourceItem(){return occupyingResource;}
	public boolean addOccupyingEntity(Entity toAdd) {
		occupyingEntities.add(toAdd);
		return true; //May want to change later to ensure no more than one building/unit can be in the same cell.
	}
	public void removeEntity(Entity toRemove){
		occupyingEntities.remove(toRemove);
	}
	public Entity getEnemy(Player p){
        if(occupyingEntities.isEmpty()){
            return null;
        }
        if(occupyingEntities.iterator().next().getOwner().equals(p)){
            return null;
        }
        return occupyingEntities.iterator().next();
    }

	public static int distance(Cell a, Cell b){
		//Returns distance between two given cells.  Diagonals count as 1
		if (a==null || b== null) {
			System.out.println("The two cells are "+a+" "+b);
		}
		int xDif = a.getX()-b.getX();
		int yDif = a.getY()-b.getY();
		return Math.max(Math.abs(xDif), Math.abs(yDif));
	}
	public int getX() {return x;}
	public int getY() {return y;}
}
