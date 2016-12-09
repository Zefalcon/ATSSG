package ATSSG.GUI;
//import ATSSG.GameMap;
import ATSSG.Entities.Entity;
import ATSSG.Script.ScriptInterface;

import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.util.ArrayList;
import java.util.Collection;
//import java.util.Iterator;

import javax.swing.JPanel;

public class UnitQueue extends UIContainer<Entity> {
	
	//Variables
	protected UnitButton[] displayedEntities;
	
	//Constructors
	public UnitQueue(Collection<Entity> ents, int width, int height, MainMap mainMap, ScriptInterface si) {
		super(ents, width, height);
		//content = new ArrayList<Entity>();
		//displayedEntities = new UnitButton[3];
		//displayedEntities[0] = new UnitButton(mainMap, si, this);
		//displayedEntities[1] = new UnitButton(mainMap, si, this);
		//displayedEntities[2] = new UnitButton(mainMap, si, this);
		view = new JPanel();
		//view.setLayout(new GridLayout(3,1));
		//view.add(displayedEntities[0]);
		//view.add(displayedEntities[1]);
		//view.add(displayedEntities[2]);
		view.setPreferredSize(new Dimension(width, height));
		view.setVisible(true);
	}
	
	//Methods
	public void addAll() {
		/*content.clear();
		for (Entity e : GameMap.getHuman().getEntities()) {
			if (! e.actionQueued()) {
				content.add(e);
			}
		}
		fillDisplayedUnits();*/
	}
	
	public void remove(Entity ordered) {
		//removal code
		//fillDisplayedUnits();
	}
	
	public boolean isEmpty() {
		return true;//Unimplementation code
		//return content.isEmpty();
	}
	
	public void fillDisplayedUnits() {
		/*Iterator<Entity> ent = content.iterator();
		for(int i = 0; i < displayedEntities.length; i++) {
			if (ent.hasNext()) {
				displayedEntities[i].setEntity(ent.next());
			} else {
				displayedEntities[i].setEntity(null);
			}
		}
		removeBorders();*/
	}
	
	public void removeBorders() {
		/*for (UnitButton ub : displayedEntities) {
			ub.setBorderPainted(false);
		}*/
	}
}
