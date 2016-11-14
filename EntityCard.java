package ATSSG;

import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JPanel;

import ATSSG.Entities.Building;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.Player;

public class EntityCard extends UIContainer<Entity> {

	//Variables
	
	protected UnitButton[] entities;
	
	protected MainMap mainMap;
	
	//Constructors
	
	public EntityCard(Collection<Entity> occupiers, int width, int height, Player owner, MainMap mainMap) {
		super(occupiers, width, height, owner);
		this.mainMap = mainMap;
		view = new JPanel();
		view.setPreferredSize(getSize());
		view.setLayout(new GridLayout(2, 4)); //Flag However big this ends up, will require safeguards on maximal cell occupancy
		entities = new UnitButton[8];
		for (int i = 0; i < 8; i++) {
			entities[i] = new UnitButton(owner, mainMap);
			view.add(entities[i].getGooey());
		}
		view.setVisible(true);
	}

	public void update(Collection<Entity> occupiers) {
		this.content = occupiers;
		for (UnitButton ub : entities) {
			ub.reset();
		}
		if (occupiers.size() == 0) {
			return;
		} else if (occupiers.size() == 1) {
			Entity ent = occupiers.iterator().next();
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
			for (Entity e : occupiers) { //Flag possible aberrant behavior if occupiers.size() > available spaces
				entities[index].setEntity(e);
				index++;
			}
		}
	}
}
