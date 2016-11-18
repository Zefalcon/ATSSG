package ATSSG;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;
import ATSSG.Script.ScriptInterface;

public class Gooey {

	//Fields
	protected Minimap minimap;
	
	protected JPanel mapButton;
	
	protected CommandCard commandCard;
	
	protected JPanel scriptInterfaceButton;
	
	protected UnitQueue unitQueue;
	
	protected DetailCard detailCard;
	
	protected JPanel etButton;
	
	protected JPanel menuButton;
	
	protected ResourceCard resourceCard;
	
	protected MainMap mainMap;
	
	protected Menu menu;
	
	protected ScriptInterface scriptInt;
	
	protected GlobalMap globalMap;
	
	protected JPanel panelPrime; //Flag hideous disorganization
	
	protected JFrame containerPrime;
	
	protected JPanel buttonRow;
	
	protected final int screenWidth, screenHeight;
	
	
	//Constructors
	
	public Gooey(int screenHeight, int screenWidth, int numResources, Player owner, GameMap gm) {
		//0,0 is the top left corner.
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		Collection<Player> computers = new ArrayList<Player>();
		for (Player p : gm.getPlayers()) {
			if (p instanceof AIPlayer) {
				computers.add(p);
			}
		}
		//MiniMap is a square in the bottom left
		int miniW = screenHeight / 3;
		int miniH = miniW;
		//CommandCard is a square in the bottom right
		int cCardW = screenHeight / 4;
		int cCardH = cCardW;
		//UnitQueue sits to the left of CommandCard
		int uqH = cCardH;
		int uqW = uqH / 3;
		//DetailCard fills the space between MiniMap and UnitQueue
		int dCardW = screenWidth - cCardW - uqW - miniW;
		int dCardH = cCardH;
		//MapButton, ResourceCard, ScriptButton, MenuButton, and EndTurnButton occupy a buttonRow above DetailCard->CommandCard
		int brH = miniH - cCardH;
		int brW = screenWidth - miniW;
		int rcW = numResources * screenWidth / 8; //Flag the divisor is arbitrary and untested
		int buttonWidth = (brW - rcW) / 4; //Flag Should customize size of buttons at some point.
		//MainMap occupies all of the space left
		int mainW = screenWidth;
		int mainH = 3 * screenHeight / 4;
		
		//Building the UI
		
		JPanel paneSwitcher = new JPanel();
		
		menu = new Menu(new ArrayList<MenuElement>(6), screenWidth, screenHeight, owner, paneSwitcher);
		
		mainMap = new MainMap(gm, mainW, mainH, owner, cCardW, cCardH, dCardW, dCardH, this, scriptInt);
		mainMap.updateView(0, 10, 0, 10); //flag arbitrary numbers //FLAG uncomment after fixing icon sizes
		
		minimap = new Minimap(null, miniW, miniH, owner);
		
		mapButton = new JPanel();
		mapButton.add(new MapButton(owner, globalMap).getGooey());
		mapButton.setPreferredSize((new Dimension(buttonWidth, brH)));
		mapButton.setVisible(true);
		
		resourceCard = new ResourceCard(null, null, rcW, brH, owner);
		
		scriptInterfaceButton = new JPanel();
		scriptInterfaceButton.add(new ScriptInterfaceButton(owner, scriptInt).getGooey());
		scriptInterfaceButton.setPreferredSize((new Dimension(buttonWidth, brH)));
		scriptInterfaceButton.setVisible(true);
		
		menuButton = new JPanel();
		menuButton.add(new MenuButton(owner, paneSwitcher).getGooey());
		menuButton.setPreferredSize((new Dimension(buttonWidth, brH)));
		menuButton.setVisible(true);
		
		etButton = new JPanel();
		etButton.add(new EndTurnButton(owner, computers, this).getGooey());
		etButton.setPreferredSize((new Dimension(buttonWidth, brH)));
		etButton.setVisible(true);
		
		detailCard = mainMap.getDCard();
		
		unitQueue = new UnitQueue(null, uqW, uqH, owner);
		//unitQueue = mainMap.getUQ(); /TODO
		
		commandCard = mainMap.getCCard();
		
		//Assemble the row of buttons
		
		buttonRow = new JPanel();
		buttonRow.add(scriptInterfaceButton); //Flag see below flags
		buttonRow.add(menuButton); //Flag see below flag
		buttonRow.add(etButton);//Flag hack: This should exist below but when it does it's offscreen
		buttonRow.add(mapButton);
		buttonRow.add(resourceCard.getView());
		buttonRow.setPreferredSize(new Dimension(brW, brH));
		buttonRow.setVisible(true);
		
		//Assembling the UI
		
		panelPrime = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		panelPrime.setLayout(gbl);
		panelPrime.setBounds(0, 0, screenWidth, screenHeight);
		panelPrime.add(mainMap.getView());
		gbl.setConstraints(mainMap.getView(), new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panelPrime.add(minimap.getView());
		gbl.setConstraints(minimap.getView(), new GridBagConstraints(0, 1, 1, 2, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panelPrime.add(buttonRow);
		gbl.setConstraints(buttonRow, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panelPrime.add(detailCard.getView());
		gbl.setConstraints(detailCard.getView(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panelPrime.add(unitQueue.getView());
		gbl.setConstraints(unitQueue.getView(), new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panelPrime.add(commandCard.getView());
		gbl.setConstraints(commandCard.getView(), new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
		panelPrime.setBounds(0, 0, screenWidth, screenHeight);
		panelPrime.setPreferredSize(new Dimension(screenWidth, screenHeight));
		panelPrime.setVisible(true);
		
		paneSwitcher.setLayout(new CardLayout());
		paneSwitcher.setPreferredSize(panelPrime.getSize());
		paneSwitcher.add(menu.getView());
		paneSwitcher.add(panelPrime);
		paneSwitcher.setVisible(true);
		
		containerPrime = new JFrame();
		containerPrime.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		containerPrime.setBounds(0, 0, screenWidth + 16, screenHeight + 89); //flag hacked numbers
		containerPrime.add(paneSwitcher);
		containerPrime.setResizable(false);
		containerPrime.setVisible(true);
	}
	
	//Methods
	
	public void createPrompt(String text) {
		//Prompt notification = new Prompt(PARAMETERS);
	}
	
	public void turnEndUpdate() {
		//MainMap, Minimap, GlobalMap, UnitQueue, ResourceCard, DetailCard, CommandCard need to be updated
		//MainMap
		mainMap.updateView(0, 10, 0, 10);
		
	}
}
