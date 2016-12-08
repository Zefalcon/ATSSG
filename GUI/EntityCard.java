package ATSSG.GUI;

import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JPanel;

import ATSSG.Cell;
import ATSSG.Entities.Building;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Script.ScriptInterface;

public class EntityCard extends UIContainer<Entity> {

	//Variables
	
	protected UnitButton[] entities;
	
	protected MainMap mainMap;
	
	protected Cell lastCell = null;
	
	//Constructors
	
	public EntityCard(Collection<Entity> occupiers, int width, int height, MainMap mainMap, ScriptInterface si) {
		super(occupiers, width, height);
		this.mainMap = mainMap;
		view = new JPanel();
		view.setPreferredSize(getSize());
		view.setLayout(new GridLayout(2, 4)); //Flag However big this ends up, will require safeguards on maximal cell occupancy
		entities = new UnitButton[8];
		for (int i = 0; i < 8; i++) {
			entities[i] = new UnitButton(mainMap, si, this);
			view.add(entities[i]);
		}
		view.setVisible(true);
	}

	public void removeBorders() {
		for (UnitButton ub : entities) {
			ub.setBorderPainted(false);
		}
	}
	
	public void update(Cell cell) {
		lastCell = cell;
		this.content = cell.getOccupyingEntities();
		for (UnitButton ub : entities) {
			ub.reset();
		}
		if (content.size() == 0) {
			return;
		} else if (content.size() == 1) {
			Entity ent = content.iterator().next();
			if (ent instanceof Unit) {
				entities[0].setEntity(ent);
			} else if (ent instanceof Building) {
				//Need to show basic info on the building and any production queues it has.
				//In-progress buildings would show the info, a progressbar where the queue would be, and also the worker building it.
			} else {
				//Flag this error case (an entity that is not a unit or a building) needs to be handled
			}
		} else { //Flag I have here assumed that buildings cannot multiply occupy with any other entities
			int index = 0;
			for (Entity e : content) { //Flag possible aberrant behavior if occupiers.size() > available spaces
				entities[index].setEntity(e);
				index++;
			}
			entities[0].setBorderPainted(true);
		}
	}
	
	public void update() {
		if (lastCell == null) {return;}
		update(lastCell);
		if (content != null && content.size() > 0) {
			mainMap.updateCCard(content.iterator().next());
		} else {
			mainMap.updateCCard(null);
		}
		view.revalidate();
		view.repaint();
	}
}
