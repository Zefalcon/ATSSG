package ATSSG;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JPanel;

import ATSSG.Actions.AttackAction;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Player.HumanPlayer;
import ATSSG.Script.ScriptInterface;

public class MainMap extends UIContainer<Cell> {
	
	//Fields
	
	//This field stores all Cells in the game, with listeners to prevent recalculations
	protected Cell[][] interactable;
	
	protected int mapW, mapH;
	
	//While this one stores the subset of the above collection that is onscreen
	protected Cell[][] viewableArea;
	
	protected int cameraW, cameraH;
	
	protected CommandType heldCommand;
	
	protected Entity heldEntity;
	
	protected Entity selectedEntity;
	
	protected CommandCard cCard;
	
	protected DetailCard dCard;
	
	protected Gooey holder;
	
	protected ScriptInterface si;
	
	protected HumanPlayer owner;
	
	//Constructors
	
	public MainMap(final int width, final int height, final HumanPlayer owner, final int cCardW, final int cCardH, final int dCardW, final int dCardH,
			final Gooey holder, ScriptInterface si) {
		super(null, width, height); //It so happens that arrays are not collections, and an array is notably better here.
		this.holder = holder;
		this.owner = owner;
		this.si = si;
		this.cameraH = 10;
		this.cameraW = 15;
		this.cCard = new CommandCard(null, cCardW, cCardH, this);
		this.dCard = new DetailCard(null, TerrainType.VOID, dCardW, dCardH, this, si);
		selectedEntity = null;
		viewableArea = new Cell[cameraW][cameraH];
		view = new JPanel();
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	//Methods
	
	public void updateGameMap(GameMap gm) {
		if (gm == null || gm.getCells() == null || gm.getCells().length == 0 || gm.getCells()[0].length == 0) {return;} //Flag possible error handling required
		interactable = gm.getCells();
		mapW = interactable.length;
		mapH = interactable[0].length;
		for (int i = 0; i < mapW; i++) {
			for (int j = 0; j < mapH; j++) {
				interactable[i][j].setActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if (si.getView().isVisible() == true) {return;}
						Object o = e.getSource();
						Cell clickedCell = ((GooeyJButton) o).getCell();
						if (clickedCell == null) {return;} //Applies only to blank CmdButtons
						System.out.print(clickedCell.getTerrainType().getName());
						System.out.println("  ("+clickedCell.getX() + "," + clickedCell.getY() + ")");
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
							//highlight selected Cell
							
							
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
			}
		}
		updateView(owner.getStartingX(), owner.getStartingY());
	}
	
	protected void updateView() {
		updateView(viewableArea[0][0].getX(), viewableArea[0][0].getY());
	}
	
	protected void updateView(int x, int y) {
		if (interactable == null) {return;} //Flag possible error handling required
		view.removeAll();
		view.setLayout(new GridLayout(cameraH, cameraW));
		
		if (x + cameraW > mapW) {x = mapW - cameraW;}//No one likes ArrayIndexOutOfBoundsExceptions
		if (y + cameraH > mapH) {y = mapH - cameraH;}
		if (x < 0) {x = 0;}
		if (y < 0) {y = 0;}
		
		for (int j = 0; j < cameraH && j < mapH; j++) {
			for (int i = 0; i < cameraW && i < mapW; i++) {
				interactable[x+i][y+j].updateView();
				viewableArea[i][j] = interactable[x+i][y+j];
				view.add(viewableArea[i][j].getView());
				viewableArea[i][j].updateView();
			}
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
		if (selectedEntity.getOwner() == owner) {
		int index = 0;
			for (CommandType cmdt : selectedEntity.getAllowedCommands()) {
				cCard.getCmdButton(index).setParams(cmdt.icon, "", new CommandListener(selectedEntity, cmdt, MainMap.this, si));
				index++; //Flag not protected from being fed too many commandTypes
			}
		} else {
			cCard.reset();
		}
	}
	
	//getter methods to get references to Gooey
	public CommandCard getCCard() {return cCard;}
	public DetailCard getDCard() {return dCard;}
	
	//getter methods for MainScroller to find camera bounds
	public int getCamTop() {return viewableArea[0][0].getY();}
	public int getCamLeft() {return viewableArea[0][0].getX();}
	public int getCamRight() {
		if (cameraW < mapW && cameraH < mapH)
			return viewableArea[cameraW-1][cameraH-1].getX();
		else
			return viewableArea[mapW-1][mapH-1].getX();//Flag: what about cross terms? Or do we just have no maps smaller than the camera?
	}
	public int getCamBot() {
		if (cameraW < mapW && cameraH < mapH)
			return viewableArea[cameraW-1][cameraH-1].getY();
		else
			return viewableArea[mapW-1][mapH-1].getY();
	}
	public int getMapW() {return mapW;}
	public int getMapH() {return mapH;}
}
