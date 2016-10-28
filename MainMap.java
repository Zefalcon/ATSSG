package ATSSG;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;
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
	protected Cell[][] interactable;
	
	//While this one stores the subset of the above collection that is onscreen
	//protected Cell[][] viewableArea;
	
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
		view.setLayout(new GridLayout(10, 10));
		
		interactable = gm.getCells();
		int mapWidth = interactable.length;
		int mapHeight = interactable[0].length;
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				interactable[i][j].setActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o = e.getSource();
						Cell clickedCell = ((Cell) o);
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
				});
				view.add(interactable[i][j].getView()); //Shortcut code that assumes viewableArea = World
			}
		}

		view.setBounds(xLoc, yLoc, width, height);
		view.setVisible(true);
		/////////////////////////////////
		//Maybe for build one we don't care about moving the camera - make the whole map fit on one screen
		/////////////////////////////////
		
		//viewableArea = interactable;
		
		
	}
	
	//Methods
	
	//Notably, with proper external support this method, by not placing any restriction on 
	//viewableArea, supports zooming
	protected void updateView(int xStart, int xEnd, int yStart, int yEnd) {
		while (yStart < yEnd) {
			while (xStart < xEnd) {
				interactable[xStart][yStart].updateView();
			}
		}
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
}
