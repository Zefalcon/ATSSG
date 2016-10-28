package ATSSG;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JWindow;

import ATSSG.Actions.AttackAction;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.Player;

public class MainMap extends UIContainer<Cell> {
	
	//Fields
	
	//This field stores the conversion of the Collection into an array
	protected GameMap gm;
	
	//This field stores all Cells in the game, with listeners to prevent recalculations
	protected Collection<ListenerCell> interactable;
	
	//While this one stores the subset of the above collection that is onscreen
	protected Collection<ListenerCell> viewableArea;
	
	//The Actual GUI object
	protected JWindow view;
	
	protected CommandType heldCommand;
	
	protected Entity selectedEntity;
	
	protected CommandCard cCard;
	
	//Constructors
	
	//MainMap wants to be passed the entire map, and will rescale its viewable section dynamically
	public MainMap(GameMap gm, int xLoc, int yLoc,
			int width, int height, int displayLevel, Player owner, int cCardX, int cCardY, int cCardWidth, int cCardHeight) {
		super(null, xLoc, yLoc, width, height, displayLevel, owner);
		this.gm = gm;
		this.cCard = new CommandCard(null, cCardX, cCardY, cCardWidth, cCardHeight, 0, owner, this);
		view = new JWindow();
		view.setBounds(xLoc, yLoc, width, height);
		
		Iterator<Cell> itr = gm.getCells().iterator();
		for (Cell cell = itr.next(); itr.hasNext(); cell = itr.next()) { //Does this skip the first Cell? There doesn't seem to be an iterator.first() method...
			interactable.add(new ListenerCell(cell, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object o = e.getSource();
					ListenerCell clickedCell = ((ListenerCell) o);
					if (heldCommand == CommandType.MOVE) {
						selectedEntity.setAction(new MoveAction(1, (Unit) selectedEntity, clickedCell)); //Unchecked Class Cast Flag
						clearHeld();
					} else if (heldCommand == CommandType.ATTACK) {
						Entity enemy = clickedCell.getEnemy(owner);
						if (enemy != null) {
							selectedEntity.setAction(new AttackAction(1, (Unit) selectedEntity, enemy));
						}
						clearHeld();
					} else {
						//Do stuff
						//Display info on DetailCard - which includes selectable entities in a grid - thus UnitButton is what refreshes the Command Card
						//highlight selected Cell
						//discriminate between left and right clicks?
						selectedEntity = clickedCell.getOccupyingEntities().iterator().next();
						cCard = new CommandCard(selectedEntity.getAllowedCommands(), cCardX, cCardY, cCardWidth,
								cCardHeight, 0, owner, MainMap.this);
					}
				}
			}, null));
		}
		
		/////////////////////////////////
		//Maybe for build one we don't care about moving the camera - make the whole map fit on one screen
		/////////////////////////////////
		
		viewableArea = interactable;
		
		
		//initializeView(/*owner.getStartX(), owner.getStartY()*/0,0);
		//note that I can't actually do this and I'll have to yoink the initializeView code into the constructor eventually
		
		Iterator<ListenerCell> i = viewableArea.iterator();
		ListenerCell lc;
		while (i.hasNext()) {
			lc = i.next();
			view.add(lc.getView());
		}
	}
	
	//Methods
	
	protected void initializeView(int x, int y) {
		view.setLayout(new GridLayout(16, 32)); //FLAG on arbitrary numbers
		//view.add things
		//double loop in x, y adding ListenerCells
		updateView(gm.getCells());
		
		
		view.setVisible(true);
	}
	
	//Notably, with proper external support this method, by not placing any restriction on 
	//viewableArea, supports zooming
	//It will require that all Cells have identifying coordinates
	protected void updateView(Collection<Cell> viewableCells) {
		//identify contained Cells, pull relevant ListenerCells from interactable to viewableArea
		//view.setLayout(new GridLayout(numX, numY))
		//set up an iterator
		//add each ListenerCell in viewableArea to view
	}
	
	public void setHeldCommand(CommandType heldCommand) {
		this.heldCommand = heldCommand;
	}
	
	public void setSelectedEntity(Entity selectedEntity) {
		this.selectedEntity = selectedEntity;
	}
	
	public void clearHeld() {
		heldCommand = null;
	}
	
	//Internal Class adding a listener to a Cell
	public class ListenerCell extends Cell implements Comparable<ListenerCell> {
		
		protected int ordering;
		protected JButton view;
		protected Cell parent;
		
		public ListenerCell(Cell cell, ActionListener l, Icon icon) { //Icon should not be a pass-in it should be determinable from contents
			super(cell.getTerrainType(), cell.getResourceItem(), cell.getGameMap(), cell.getX(), cell.getY());
			ordering = 10000 * xLoc + yLoc; //Arbitrary scaling number flag
			parent = cell;
			view = new JButton(icon);
			view.addActionListener(l);
		}
		
		public int getOrdering() {
			return ordering;
		}
		
		public JButton getView() {
			return view;
		}
		
		//Note that this makes ListenerCell inconsistent with equals
		@Override
		public int compareTo(ListenerCell target) {
			if (target.getOrdering() < this.getOrdering()) {
				return 1;
			} else if (target.getOrdering() > this.getOrdering()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
