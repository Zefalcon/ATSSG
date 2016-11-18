package ATSSG;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JPanel;

import ATSSG.Actions.AttackAction;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.Player;
import ATSSG.Script.ScriptInterface;

public class MainMap extends UIContainer<Cell> {
	
	//Fields
	
	//This field stores all Cells in the game, with listeners to prevent recalculations
	protected Cell[][] interactable;
	
	//While this one stores the subset of the above collection that is onscreen
	//protected Cell[][] viewableArea;
	
	protected CommandType heldCommand;
	
	protected Entity heldEntity;
	
	protected Entity selectedEntity;
	
	protected CommandCard cCard;
	
	protected DetailCard dCard;
	
	protected Gooey holder;
	
	protected ScriptInterface si;
	
	//Constructors
	
	//MainMap wants to be passed the entire map, and will rescale its viewable section dynamically
	public MainMap(final int width, final int height, final Player owner, final int cCardW, final int cCardH, final int dCardW, final int dCardH,
			final Gooey holder, ScriptInterface si) {
		super(null, width, height, owner); //It so happens that arrays are not collections, and an array is notably better here.
		this.holder = holder;
		this.si = si;
		this.cCard = new CommandCard(null, cCardW, cCardH, owner, this);
		this.dCard = new DetailCard(null, TerrainType.VOID, dCardW, dCardH, owner, this, si);
		selectedEntity = null;
		view = new JPanel();view.setPreferredSize(new Dimension(width, height));
		view.setVisible(true);
		
		
		/////////////////////////////////
		//Maybe for now we don't care about moving the camera - make the whole map fit on one screen
		/////////////////////////////////
		
		//viewableArea = interactable;
		
		
	}
	
	//Methods
	
	public void updateGameMap(GameMap gm) {
		if (gm == null || gm.getCells().length == 0 || gm.getCells()[0].length == 0) {return;} //Flag possible error handling required
		interactable = gm.getCells();
		int mapWidth = interactable.length;
		int mapHeight = interactable[0].length;
		view.removeAll();
		view.setLayout(new GridLayout(mapHeight, mapWidth));
		
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				interactable[i][j].setActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if (si.getView().isVisible() == true) {return;}
						Object o = e.getSource();
						Cell clickedCell = ((GooeyJButton) o).getCell();
						if (clickedCell == null) {return;} //Applies only to blank CmdButtons
						Collection<Entity> occupiers = clickedCell.getOccupyingEntities();
						if (occupiers.isEmpty()) {
							selectedEntity = null;
						} else {
							selectedEntity = occupiers.iterator().next(); //This checks the ownership of the first unit
							if (selectedEntity.getOwner() != owner) { 	//It only works because units owned by different
								selectedEntity = null;					//players cannot occupy the same space
							}
						}
						if (heldCommand == CommandType.MOVE) {
							heldEntity.setAction(new MoveAction(1, (Unit) heldEntity, clickedCell)); //Unchecked Class Cast Flag
							clearHeld();
						} else if (heldCommand == CommandType.ATTACK) {
							Entity enemy = clickedCell.getEnemy(owner);
							if (enemy != null) {
								heldEntity.setAction(new AttackAction(1, (Unit) heldEntity, enemy));
							}
							clearHeld();
						} else {
							//Do stuff
							//Display info on DetailCard - which includes selectable entities in a grid - thus UnitButton is what refreshes the Command Card
							//highlight selected Cell
							//discriminate between left and right clicks?
							
							/*if (clickedCell != null && ! clickedCell.getOccupyingEntities().isEmpty()) {
								selectedEntity = clickedCell.getOccupyingEntities().iterator().next();
							}*/
							dCard.update(occupiers, clickedCell.getTerrainType());
							if (selectedEntity == null) {
								cCard.reset();
							} else {
								//Highlight the selected unit in DetailCard
								int index = 0;
								for (CommandType cmdt : selectedEntity.getAllowedCommands()) {
									cCard.getCmdButton(index).setParams(cmdt.icon, "", new CommandListener(selectedEntity, cmdt, MainMap.this, si));
									index++; //Flag not protected from being fed too many commandTypes
								}
							}
						}
					}
				});
				view.add(interactable[i][j].getView()); //Shortcut code that assumes viewableArea = World
			}
		}
	}
	
	//Notably, with proper external support this method, by not placing any restriction on 
	//viewableArea, supports zooming
	protected void updateView() {
		if (interactable == null) {return;} //Flag possible error handling required
		int x = 0;
		int y = 0;
		while (y < interactable.length) {
			while (x < interactable[0].length) {
				interactable[x][y].updateView();
				x++;
			}
			x = 0;
			y++;
		}
	}
	
	public void setHeldCommand(CommandType heldCommand) {
		this.heldCommand = heldCommand;
	}
	
	public void setHeldEntity(Entity heldEntity) {
		this.heldEntity = heldEntity;
	}
	
	public void setSelectedEntity(Entity selectedEntity) {
		this.selectedEntity = selectedEntity;
	}
	
	public void clearHeld() {
		setHeldCommand(null);
		setHeldEntity(null);
	}
	
	public void updateCCard(Entity selectedEntity) {
		int index = 0;
		for (CommandType cmdt : selectedEntity.getAllowedCommands()) {
			cCard.getCmdButton(index).setParams(cmdt.icon, "", new CommandListener(selectedEntity, cmdt, MainMap.this, si));
			index++; //Flag not protected from being fed too many commandTypes
		}
	}
	
	//getter methods to get references to Gooey
	public CommandCard getCCard() {return cCard;}
	public DetailCard getDCard() {return dCard;}
}
