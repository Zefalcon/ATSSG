package ATSSG.GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import ATSSG.GameMap;
import ATSSG.Player.Player;
import ATSSG.Player.AI.AIPlayer;
import ATSSG.Script.ScriptInterface;

public class EndTurnButton extends JButton {

	//Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Gooey holder;
	protected final GameMap gameMap;
	protected final UnitQueue uq;
	protected final ScriptInterface si;
	protected final Boolean[] prompted = {false};
	
	//Constructors
	
	public EndTurnButton(int width, int height, final Gooey holder, final GameMap gameMap, final UnitQueue uq, final ScriptInterface si) throws IOException {
		super(new ImageIcon(ImageIO.read(new File(Paths.get("src/ATSSG/Art/DemoEndTurn.png").toString())).getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		this.holder = holder;
		this.uq = uq;
		this.si = si;
		this.gameMap = gameMap;
		this.setPreferredSize(new Dimension(width, height));
	}
	
	//Methods
	
	public void endTurn() {
		for (ActionListener actlis : this.getActionListeners()) {
			this.removeActionListener(actlis);
		}
		final Collection<Player> players = gameMap.getPlayers();
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (si.isVisible()) {return;}
				if (uq.isEmpty() || prompted[0] == true) {
					GameMap.getHuman().executeAll();
					if (players != null) {
						for (Player ai : players) {
							if (ai instanceof AIPlayer) {
								ai.executeAll();
							}
						}
						prompted[0] = false;
						holder.turnEndUpdate();
					}
				} else {
					holder.getPrompts().createMessagePrompt("Are you sure?", 
							"You still have units without orders.", 
							new ImageIcon(Paths.get("src/ATSSG/Art/DemoPromptError.png").toString()));
					prompted[0] = true;
				}
				endTurn();
			}
		});
	}
	
	protected static void automaticEndTurn(GameMap gameMap) {
		final Collection<Player> players = gameMap.getPlayers();
		GameMap.getHuman().executeAll();
		if (players != null) {
			for (Player ai : players) {
				if (ai instanceof AIPlayer) {
					ai.executeAll();
				}
			}
		}
	}
}
