package ATSSG;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JWindow;

import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;

public class Gooey {

	//Fields
	protected Minimap minimap;
	
	protected MapButton mapButton;
	
	protected CommandCard commandCard;
	
	protected ScriptButton scriptButton;
	
	protected UnitQueue unitQ;
	
	protected DetailCard detailCard;
	
	protected JWindow etButton;
	
	protected MenuButton menuButton;
	
	protected ResourceCard resourceCard;
	
	protected MainMap mainMap;
	
	protected Menu menu;
	
	protected ScriptInterface scripts;
	
	protected GlobalMap globalMap;
	
	
	//Constructors
	
	public Gooey(int screenHeight, int screenWidth, int numResources, Player owner, GameMap gm) {
		//0,0 is the top left corner.
		//Reused Variables
		int buttonWidth = screenWidth / 8;
		int buttonHeight = screenHeight / 16;
		Collection<Player> computers = new ArrayList<Player>();
		for (Player p : gm.getPlayers()) { //flag disgustingly efficient looking for loop syntax
			if (p instanceof AIPlayer) {
				computers.add(p);
			}
		}
		//MiniMap is a square in the bottom left
		int miniY = 2 * screenHeight / 3;
		int miniX = 0;
		int miniWidth = screenHeight - miniY;
		int miniHeight = miniWidth;
		//MapButton sits atop the miniMap
		int mbY = miniY - buttonHeight;
		int mbX = 0;
		//CommandCard is a square in the bottom right
		int cCardY = 3 * screenHeight / 4;
		int cCardX = screenWidth - cCardY;
		int cCardWidth = screenHeight / 4;
		int cCardHeight = cCardWidth;
		//ScriptButton sits atop the CommandCard
		int sbY = cCardY - buttonHeight;
		int sbX = screenWidth - buttonWidth;
		//UnitQueue sits next to the CommandCard
		int uqY = cCardY;
		int uqX = miniWidth + (15 * (cCardY - miniWidth) / 16);
		int uqWidth = cCardX - uqX;
		int uqHeight = cCardHeight;
		//DetailCard fills the space between MiniMap and UnitQueue
		int detailY = cCardY;
		int detailX = screenWidth - miniY;
		int detailWidth = cCardX - miniY;
		int detailHeight = cCardHeight;
		//EndTurnButton occupies a small space in the top right
		int etbY = 0;
		int etbX = screenWidth - buttonWidth;
		//MenuButton sits next to EndTurnButton
		int menuY = 0;
		int menuX = screenWidth - 2 * buttonWidth;
		//ResourceCard occupies a similar space in the top left. It is not a button; it merely uses the same dimensions for aesthetics.
		int rCardY = 0;
		int rCardX = 0;
		int rCardWidth = numResources * buttonWidth;
		int rCardHeight = buttonHeight;
		//MainMap occupies all of the space left
		int mainX = 0;
		int mainY = 0;
		int mainWidth = screenWidth;
		int mainHeight = 3 * screenHeight / 4;
		
		//Building the UI
		
		commandCard = new CommandCard(null, cCardX, cCardY, cCardWidth, cCardHeight, 0, owner);
		
		mainMap = new MainMap(gm, mainX, mainY, mainWidth, mainHeight, 0, owner, commandCard);
		
		etButton = new JWindow();
		etButton.add(new EndTurnButton(null, owner, computers).getGooey(), 0);
		etButton.setBounds(etbX, etbY, buttonWidth, buttonHeight);
		etButton.setVisible(true);
	}
	
	//Methods
	
	public void createPrompt(String text) {
		//Prompt notification = new Prompt(PARAMETERS);
	}
	
}
