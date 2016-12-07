package ATSSG.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JPanel;

import ATSSG.Cell;
import ATSSG.GameMap;
import ATSSG.Actions.AttackAction;
import ATSSG.Actions.MoveAction;
import ATSSG.Entities.Entity;
import ATSSG.Entities.Unit;
import ATSSG.Enums.CommandType;
import ATSSG.Enums.TerrainType;
import ATSSG.Player.HumanPlayer;
import ATSSG.Script.ScriptInterface;

public class MainMap extends UIContainer<Cell> {
	
	//Fields
	
	//This field stores all Cells in the game, with listeners to prevent recalculations
	protected Cell[][] interactable;
	
	//While this one stores the subset of the above collection that is onscreen
	protected Cell[][] viewableArea;
	
	protected CommandType heldCommand;
	
	protected Entity heldEntity;
	
	protected Entity selectedEntity;
	
	protected GooeyJButton lastClicked;
	
	protected GooeyJButton clickedButton;
	
	protected CommandCard cCard;
	
	protected DetailCard dCard;
	
	protected Gooey holder;
	
	protected ScriptInterface si;
	protected ScriptInterfaceButton sibtn;
	
	protected HumanPlayer owner;
	
	protected JPanel mapView;
	
	protected final int[] cameraConstants; //camLeftEdge, camTopEdge, camWidth, camHeight, mapWidth, mapHeight
	protected final JButton scrollUp;
	protected final JButton scrollLeft;
	protected final JButton scrollRight;
	protected final JButton scrollDown;
	
	protected static int defaultCameraWidth = 15;
	protected static int defaultCameraHeight = 10;
	
	//Constructors
	
	public MainMap(final int width, final int height, final HumanPlayer owner, final int cCardW, final int cCardH, final int dCardW, final int dCardH,
			final Gooey holder, ScriptInterface si, ScriptInterfaceButton sibtn) {
		super(null, width, height); //It so happens that arrays are not collections, and an array is notably better here.
		this.holder = holder;
		this.owner = owner;
		this.si = si;
		this.sibtn = sibtn;
		
		//interactable map setup
		
		try {
			this.cCard = new CommandCard(null, cCardW, cCardH, this);
			this.dCard = new DetailCard(null, TerrainType.VOID, dCardW, dCardH, this, si);
		} catch (IOException ioe) {
			System.out.println("Images not found for cards");
		}
		selectedEntity = null;
		mapView = new JPanel();
		mapView.setPreferredSize(new Dimension(width - 100, height - 100));
		mapView.setVisible(true);
		
		//Scroller setup
		
		cameraConstants = new int[6];
		cameraConstants[0] = GameMap.getHuman().getStartingX();
		cameraConstants[1] = GameMap.getHuman().getStartingY();
		cameraConstants[2] = MainMap.defaultCameraWidth;
		cameraConstants[3] = MainMap.defaultCameraHeight;
		viewableArea = new Cell[cameraConstants[2]][cameraConstants[3]];
		scrollUp = new JButton("^");
		scrollLeft = new JButton("<");
		scrollRight = new JButton(">");
		scrollDown = new JButton("v");
		
		ActionListener alUp = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[1]--;
				updateView(cameraConstants[0], cameraConstants[1]);
			}
		};
		scrollUp.addActionListener(alUp);
		
		ActionListener alLeft = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[0]--;
				updateView(cameraConstants[0], cameraConstants[1]);
			}
		};
		scrollLeft.addActionListener(alLeft);
		
		ActionListener alRight = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[0]++;
				updateView(cameraConstants[0], cameraConstants[1]);
			}
		};
		scrollRight.addActionListener(alRight);
		
		ActionListener alDown = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cameraConstants[1]++;
				updateView(cameraConstants[0], cameraConstants[1]);
			}
		};
		scrollDown.addActionListener(alDown);
		
		scrollUp.setPreferredSize(new Dimension(width, 50));
		scrollLeft.setPreferredSize(new Dimension(50, height - 100));
		scrollRight.setPreferredSize(new Dimension(50, height - 100));
		scrollDown.setPreferredSize(new Dimension(width, 50));
		
		view = new JPanel();
		view.setLayout(new BorderLayout());
		view.add(scrollUp, BorderLayout.NORTH);
		view.add(scrollLeft, BorderLayout.WEST);
		view.add(scrollRight, BorderLayout.EAST);
		view.add(scrollDown, BorderLayout.SOUTH);
		view.add(mapView, BorderLayout.CENTER);
		view.setPreferredSize(getSize());
		view.setVisible(true);
	}
	
	//Methods
	
	public void updateGameMap(GameMap gm) {
		if (gm == null || gm.getCells() == null || gm.getCells().length == 0 || gm.getCells()[0].length == 0) {return;} //Flag possible error handling required
		owner = GameMap.getHuman();
		interactable = gm.getCells();
		cameraConstants[4] = interactable.length;
		cameraConstants[5] = interactable[0].length;
		for (int i = 0; i < cameraConstants[4]; i++) {
			for (int j = 0; j < cameraConstants[5]; j++) {
				interactable[i][j].setActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (si.isVisible() == true) {return;}
						Object o = e.getSource();
						GooeyJButton gjb = (GooeyJButton) o;
						Cell clickedCell = gjb.getCell();
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
							try {
								heldEntity.setAction(new MoveAction(1, (Unit) heldEntity, clickedCell)); //Unchecked Class Cast Flag
							} catch (RuntimeException error) {
								holder.getPrompts().createMessagePrompt("Illegal Command", error.getMessage(), null);
							} finally {
								clearHeld();
							}
						} else if (heldCommand == CommandType.ATTACK) {
							try {
								Entity enemy = clickedCell.getEnemy(owner);
								if (enemy != null) {
									heldEntity.setAction(new AttackAction(1, (Unit) heldEntity, enemy));
								} else {
									throw new RuntimeException("Entity"+selectedEntity.getId()+" can only attack enemies.");
								}
							} catch (RuntimeException error) {
								holder.getPrompts().createMessagePrompt("Illegal Command", error.getMessage(), null);
							} finally {
								clearHeld();
							}
						} else {
							lastClicked = clickedButton;
							clickedButton = gjb;
							if (lastClicked != null) {lastClicked.toggleSelected();}
							clickedButton.toggleSelected();
							
							dCard.update(clickedCell);
							if (selectedEntity == null) {
								cCard.reset();
								sibtn.setEnabled(false);
							} else {
								//Highlight the selected unit in DetailCard
								int index = 0;
								for (CommandType cmdt : selectedEntity.getAllowedCommands()) {
									cCard.getCmdButton(index).setParams(cmdt.getIcon(), "", new CommandListener(selectedEntity, cmdt, MainMap.this, si));
									index++; //Flag not protected from being fed too many commandTypes
									si.update(selectedEntity);
									sibtn.setEnabled(true);
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
		updateView(x, y, cameraConstants[2], cameraConstants[3]);
	}
	
	protected void updateView(int x, int y, int w, int h) {
		
		cameraConstants[0] = x;
		cameraConstants[1] = y;
		cameraConstants[2] = w;
		cameraConstants[3] = h;
		
		scrollUp.setEnabled(cameraConstants[1] > 0);
		scrollLeft.setEnabled(cameraConstants[0] > 0);
		scrollRight.setEnabled(cameraConstants[0] + cameraConstants[2] < cameraConstants[4]);
		scrollDown.setEnabled(cameraConstants[1] + cameraConstants[3] < cameraConstants[5]);
		mapView.removeAll();
		mapView.setLayout(new GridLayout(cameraConstants[3], cameraConstants[2]));
		
		if (x + cameraConstants[2] > cameraConstants[4]) {x = cameraConstants[4] - cameraConstants[2];}//No one likes ArrayIndexOutOfBoundsExceptions
		if (y + cameraConstants[3] > cameraConstants[5]) {y = cameraConstants[5] - cameraConstants[3];}
		if (x < 0) {x = 0;}
		if (y < 0) {y = 0;}
		
		for (int j = 0; j < cameraConstants[3] && y+j < cameraConstants[5]; j++) {
			for (int i = 0; i < cameraConstants[2] && x+i < cameraConstants[4]; i++) {
				interactable[x+i][y+j].updateView((int) (getSize().getWidth() / cameraConstants[2]), (int) (getSize().getHeight() / cameraConstants[3]));
				viewableArea[i][j] = interactable[x+i][y+j];
				mapView.add(viewableArea[i][j].getView());
			}
		}
		view.revalidate();
		view.repaint();
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
	public static int getDefaultCameraWidth() {return MainMap.defaultCameraWidth;}
	public static int getDefaultCameraHeight() {return MainMap.defaultCameraHeight;}
}
