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

public class MainMap extends UIContainer<Cell> {
	
	//Fields
	
	//This field stores the conversion of the Collection into an array
	protected GameMap gm;
	
	//This field stores all Cells in the game, with listeners to prevent recalculations
	protected Cell[][] interactable;
	
	//While this one stores the subset of the above collection that is onscreen
	//protected Cell[][] viewableArea;
	
	protected CommandType heldCommand;
	
	protected Entity heldEntity;
	
	protected Entity selectedEntity;
	
	protected CommandCard cCard;
	
	protected DetailCard dCard;
	
	public Gooey holder;
	
	//Constructors
	
	//MainMap wants to be passed the entire map, and will rescale its viewable section dynamically
	public MainMap(GameMap gm, final int width, final int height, final Player owner, 
			final int cCardW, final int cCardH, final int dCardW, final int dCardH, final Gooey holder) {
		super(null, width, height, owner);
		this.holder = holder;
		this.gm = gm;
		this.cCard = new CommandCard(null, cCardW, cCardH, owner, this);
		this.dCard = new DetailCard(null, TerrainType.VOID, dCardW, dCardH, owner, this);
		selectedEntity = null;
		view = new JPanel();
		view.setLayout(new GridLayout(10, 10));
		
		interactable = gm.getCells(); //reapply this update on turn ends
		int mapWidth = interactable.length;
		int mapHeight = interactable[0].length;
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				interactable[i][j].setActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object o = e.getSource();
						Cell clickedCell = ((GooeyJButton) o).getCell();
						if (clickedCell == null) {return;} //Applies only to blank CmdButtons
						System.out.println("I am clicked: " + clickedCell.getX() + ", " + clickedCell.getY()); //Flag test code
						Collection<Entity> occupiers = clickedCell.getOccupyingEntities();
						System.out.println(occupiers.toString());
						if (occupiers.isEmpty()) {
							selectedEntity = null;
						} else {
							selectedEntity = occupiers.iterator().next(); //This checks the ownership of the first unit
							if (selectedEntity.getOwner() != owner) { 	//It only works because units owned by different
								selectedEntity = null;					//players cannot occupy the same space
							}
						}
						if (heldCommand == CommandType.MOVE) {
							System.out.println("Move Command Recognized");
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
							dCard.update(occupiers, clickedCell.getTerrainType()); //Flag this line is causing the UI hang on click
							if (selectedEntity == null) {
								cCard.reset();
							} else {
								int index = 0;
								for (CommandType cmdt : selectedEntity.getAllowedCommands()) {
									cCard.getCmdButton(index).setParams(cmdt.icon, "", new CommandListener(selectedEntity, cmdt, MainMap.this));
									index++; //Flag not protected from being fed too many commandTypes
								}
							}
							holder.cCardUpdate(cCard);
						}
					}
				});
				view.add(interactable[i][j].getView()); //Shortcut code that assumes viewableArea = World
			}
		}
		
		view.setPreferredSize(new Dimension(width, height));
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
		int x = xStart;
		while (yStart < yEnd) {
			while (x < xEnd) {
				interactable[x][yStart].updateView();
				x++;
			}
			x = xStart;
			yStart++;
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
	
	//getter methods to get references to Gooey
	public CommandCard getCCard() {return cCard;}
	public DetailCard getDCard() {return dCard;}
}
