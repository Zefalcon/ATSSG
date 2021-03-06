package ATSSG.GUI;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ATSSG.GameMap;
import ATSSG.Enums.TerrainType;
import ATSSG.Player.HumanPlayer;
import ATSSG.Script.ScriptInterface;

public class Gooey {

	//Fields
	protected final Prompt prompts;
	protected ScriptInterface scriptInt;
	protected GlobalMap globalMap;
	
	protected Menu menu;
	protected MapButton mapButton;
	protected JButton lastPromptButton;
	protected ResourceCard resourceCard;
	protected ScriptInterfaceButton scriptInterfaceButton;
	protected MainMap mainMap;
	protected Minimap minimap;
	protected UnitQueue unitQueue;
	protected MenuButton menuButton;
	protected EndTurnButton etButton;
	protected DetailCard detailCard;
	protected CommandCard commandCard;
	protected JPanel buttonRow;
	
	protected JPanel panelPrime;
	protected JFrame containerPrime;
	
	protected final int screenWidth, screenHeight;
	
	
	//Constructors
	
	public Gooey(int screenWidth, int screenHeight, int numResources, HumanPlayer owner, GameMap gm) {
		//0,0 is the top left corner.
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
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
		int buttonWidth = (brW - rcW) / 6;
		//MainMap occupies all of the space left
		int mainH = (3 * screenHeight / 4);
		
		//Building the UI
		JPanel paneSwitcher = new JPanel();
		
		prompts = new Prompt();
		scriptInt = new ScriptInterface(null);
		
		try {
			menu = new Menu(new ArrayList<MenuElement>(6), screenWidth, screenHeight, paneSwitcher, gm, this);
		
			mapButton = new MapButton(brH, brH, globalMap);
			
			lastPromptButton = new JButton("Last Prompt");
			lastPromptButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prompts.createLastPrompt();
				}
			});
			lastPromptButton.setPreferredSize(new Dimension(2 * buttonWidth / 3, brH));
		
			resourceCard = new ResourceCard(null, null, rcW, brH);
		
			scriptInterfaceButton = new ScriptInterfaceButton(buttonWidth, brH, scriptInt);
		
			mainMap = new MainMap(screenWidth, mainH, owner, cCardW, cCardH, dCardW, dCardH, this, scriptInt, scriptInterfaceButton);
			
			minimap = new Minimap(null, miniW, miniH, gm, mainMap);
			
			unitQueue = new UnitQueue(null, uqW, uqH, mainMap, scriptInt);
			
			menuButton = new MenuButton(2 * buttonWidth / 3, brH, paneSwitcher, scriptInt);
			
			etButton = new EndTurnButton(buttonWidth, brH, this, gm, unitQueue, scriptInt);
		} catch (IOException ioe) {
			System.out.println("Image files not found for game buttons.");
		}
		
		detailCard = mainMap.getDCard();
		
		commandCard = mainMap.getCCard();
		
		//Assemble the row of buttons
		
		buttonRow = new JPanel();
		
		buttonRow.add(mapButton);
		buttonRow.add(lastPromptButton);
		buttonRow.add(resourceCard.getView());
		buttonRow.add(scriptInterfaceButton);
		buttonRow.add(menuButton);
		buttonRow.add(etButton);
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
	
	public void turnEndUpdate() {
		//MainMap, Minimap, UnitQueue, ResourceCard, EntityCard, CommandCard, ScriptUI need to be updated
		//MainMap
		mainMap.updateView();
		//Minimap
		minimap.endTurnUpdate();
		//UnitQueue
		unitQueue.addAll();
		//ResourceCard
		////May Not Exist
		//EntityCard and CommandCard
		detailCard.update();
		//ScriptInterface
		scriptInt.update();
	}
	
	//Called by Menu when initializing a game
	public void updateGameMap(GameMap gm) {
		int ciW = (screenWidth - 100) / MainMap.getDefaultCameraWidth();
		int ciH = (int) ((((3.0 * screenHeight) / 4.0) - 100) / MainMap.getDefaultCameraHeight());
		TerrainType.setCellIconSizes(ciW, ciH);
		
		mainMap.updateGameMap(gm);
		minimap.updateAll();
		unitQueue.addAll();
		
		etButton.endTurn();
	}
	
	public Prompt getPrompts() {
		return prompts;
	}
	
	public class Prompt {
		
		private String lastTitle;
		private String lastMessage;
		private int lastMessageType;
		private Icon lastIcon;
		
		public Prompt() {
			lastTitle = "";
			lastMessage = "";
			lastMessageType = -1;
			lastIcon = null;
		}
		
		public void createMessagePrompt(String title, Object message, Icon icon) {
			if (message instanceof String) {
				lastTitle = title;
				lastMessage = (String) message;
				lastMessageType = JOptionPane.INFORMATION_MESSAGE;
				lastIcon = icon;
			}
			JOptionPane.showMessageDialog(panelPrime, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
		}
		
		public void createErrorPrompt(String title, String message, Icon icon) {
			lastTitle = title;
			lastMessage = message;
			lastMessageType = JOptionPane.ERROR_MESSAGE;
			lastIcon = icon;
			JOptionPane.showMessageDialog(panelPrime, message, title, JOptionPane.ERROR_MESSAGE, icon);
		}
		
		private void createLastPrompt() {
			if (lastMessage != "")
				JOptionPane.showMessageDialog(panelPrime, lastMessage, lastTitle, lastMessageType, lastIcon);
		}
	}
}
